package com.forbitbd.diploma;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.daasuu.ahp.AnimateHorizontalProgressBar;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyListener {

    private EditText roll;
    private MaterialButton btn,btncalculator;
    private AutoCompleteTextView semester, year;
    private InterstitialAd mInterstitialAd;
    private AnimateHorizontalProgressBar progressBar;
    private Handler handler = new Handler();
    private int a = 0;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        progressBar = findViewById(R.id.progressbar);
        btncalculator = findViewById(R.id.calculator);
        btncalculator.setOnClickListener(this);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5474497946967422/7341540413");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

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
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo data = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        int id = view.getId();
        if (id == R.id.btn){
            if ((wifi != null & data != null) && (wifi.isConnected() | data.isConnected())) {
            }else{
                Toast toast = Toast.makeText(MainActivity.this, "No Internet Connection!", Toast.LENGTH_LONG);
                toast.show();
            }

            String broll = roll.getText().toString();
            if (broll.equals("")) {
                roll.setError("Enter Your Board Roll");
                roll.requestFocus();
            }
            String sem = semester.getText().toString();
            String byear = year.getText().toString();
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgressWithAnim(90);
            progressBar.setMaxWithAnim(100);
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("http")
                    .authority("project.riajtech.com")
                    .appendPath("app.php")
                    .appendQueryParameter("roll", broll)
                    .appendQueryParameter("sem", sem)
                    .appendQueryParameter("year", byear);
            String myUrl = builder.build().toString();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(myUrl)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String mydata = response.body().string();
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (mydata.equals("")) {
                                } else {
                                    progressBar.setVisibility(View.GONE);
                                    progressBar.setProgressWithAnim(0);
                                    progressBar.setMaxWithAnim(100);
                                    Dialoge_fragment dialog_fragment = new Dialoge_fragment();
                                    dialog_fragment.setCancelable(false);
                                    Bundle data = new Bundle();
                                    data.putString("data", mydata);
                                    data.putString("roll",broll);
                                    data.putString("sem",sem);
                                    data.putString("year",byear);
                                    dialog_fragment.setArguments(data);
                                    dialog_fragment.show(getSupportFragmentManager(), "GHGJHGJHGHJ");
                                }
                            }
                        });
                    }
                }
            });
        }else if (id == R.id.calculator){
            Intent intent = new Intent(MainActivity.this,CalculatorActivity.class);
            startActivity(intent);
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
        if (item.getItemId()==R.id.polytechnic){
            Intent intent = new Intent(MainActivity.this,PolytechnicActivty.class);
            startActivity(intent);
        }else if (item.getItemId()==R.id.developer){
            Intent intent = new Intent(MainActivity.this,ActivityDev.class);
            startActivity(intent);
            return true;
        }else if (item.getItemId()==R.id.share){
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.forbitbd.diploma");
            startActivity(Intent.createChooser(sharingIntent, "BTEB Result"));
            return true;
        }else if (item.getItemId()==R.id.bookprice){
            Intent intent = new Intent(MainActivity.this,BookPriceActivity.class);
            startActivity(intent);
            return true;
        }else if (item.getItemId()==R.id.googleplay){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.forbitbd.diploma"));
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
    public void onRewardButtonClick() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}
