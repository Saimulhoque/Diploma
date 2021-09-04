package com.forbitbd.diploma.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.forbitbd.diploma.R;

public class ActivityDev extends AppCompatActivity {

    private Button btnmoreapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);

        btnmoreapp = findViewById(R.id.moreapps);
        btnmoreapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Forbit+Bangladesh&hl=en"));
                startActivity(intent);
            }
        });
    }
}