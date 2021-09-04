package com.forbitbd.diploma.ui.main;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.daasuu.ahp.AnimateHorizontalProgressBar;
import com.forbitbd.diploma.MyListener;
import com.forbitbd.diploma.R;
import com.forbitbd.diploma.fcm.FirebaseMessageReceiver;
import com.forbitbd.diploma.model.Result;
import com.forbitbd.diploma.ui.ActivityDev;
import com.forbitbd.diploma.ui.BookPriceActivity;
import com.forbitbd.diploma.ui.CalculatorActivity;
import com.forbitbd.diploma.ui.Dialoge_fragment;
import com.forbitbd.diploma.ui.NoticeActivity;
import com.forbitbd.diploma.utils.BaseActivity;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends BaseActivity implements MainContract.View, View.OnClickListener, MyListener {

    private MainPresenter mPresenter;
    private EditText roll;
    private MaterialButton btn,btncalculator;
    private AutoCompleteTextView semester, year;
    private InterstitialAd mInterstitialAd;
    private AnimateHorizontalProgressBar progressBar;
    private Handler handler = new Handler();
    private int a = 0;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);

//        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
//            @Override
//            public void onComplete(@NonNull Task<String> task) {
//
//                String token = task.getResult();
//
//                // Log and toast
//                String msg = getString(R.string.msg_token_fmt, token);
//                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//            }
//
//        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        progressBar = findViewById(R.id.progressbar);
        btncalculator = findViewById(R.id.calculator);
        btncalculator.setOnClickListener(this);

        createAd();
        initView();
        createNotificationChannel();
    }

    private void initView() {
        roll = findViewById(R.id.roll);
        semester = findViewById(R.id.exm_semester);
        String[] exm_semester = getResources().getStringArray(R.array.exm_semester);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, exm_semester);
        semester.setText(arrayAdapter.getItem(0).toString(), false);
        semester.setAdapter(arrayAdapter);

        year = findViewById(R.id.exm_year);
        String[] exm_year = getResources().getStringArray(R.array.exm_year);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,exm_year);
        year.setText(yearAdapter.getItem(0).toString(), false);
        year.setAdapter(yearAdapter);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn){
            checkInternet();

            String broll = roll.getText().toString().trim();
            int sem = Integer.parseInt(semester.getText().toString().trim());
            int byear = Integer.parseInt(year.getText().toString().trim());

            if (roll.getText().toString().isEmpty()){
                roll.setError("Enter your Board roll!");
                roll.requestFocus();
            }else if (semester.getText().toString().isEmpty()){
                semester.setError("Enter your semester");
                semester.requestFocus();
            }else if (year.getText().toString() == null){
                year.setError("Enter your exam year");
                year.requestFocus();
            }

            Result result = new Result();
            result.setSemester(sem);
            result.setYear(byear);
            result.setRoll(broll);

            mPresenter.getResults(result);

        }else if (id == R.id.calculator){
            startActivity(new Intent(MainActivity.this,CalculatorActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.notice){
            startActivity(new Intent(MainActivity.this,NoticeActivity.class));
        }else if (item.getItemId()==R.id.developer){
            Intent intent = new Intent(MainActivity.this, ActivityDev.class);
            startActivity(intent);
            return true;
        }else if (item.getItemId()==R.id.share){
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.share_link));
            startActivity(Intent.createChooser(sharingIntent, "BTEB Result"));
            return true;
        }else if (item.getItemId()==R.id.bookprice){
            startActivity(new Intent(MainActivity.this,BookPriceActivity.class));
            return true;
        }else if (item.getItemId()==R.id.googleplay){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getString(R.string.share_link)));
            startActivity(intent);
            return true;
        }else if (item.getItemId()==R.id.exit){
            finishAffinity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
      finishAffinity();
    }

    @Override
    public void onCloseButtonClick() {
        showAd();
    }

    @Override
    public void showProgressbar() {
        progressBar.setMaxWithAnim(90);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBar.setProgress(0);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void openDialog(Result result) {
        Dialoge_fragment dialog_fragment = new Dialoge_fragment();
        dialog_fragment.setCancelable(false);
        Bundle data = new Bundle();
        data.putSerializable("result",result);
        dialog_fragment.setArguments(data);
        dialog_fragment.show(getSupportFragmentManager(), "GHGJHGJHGHJ");
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel chan1 = new NotificationChannel(
                    "default",
                    "default",
                    NotificationManager.IMPORTANCE_NONE);

            chan1.setLightColor(Color.TRANSPARENT);
            chan1.setLockscreenVisibility(Notification.VISIBILITY_SECRET);
            notificationManager.createNotificationChannel(chan1);
        }
    }
}
