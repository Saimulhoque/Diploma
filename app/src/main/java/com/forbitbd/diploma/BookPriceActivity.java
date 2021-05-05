package com.forbitbd.diploma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.card.MaterialCardView;

public class BookPriceActivity extends AppCompatActivity {

    MaterialCardView tech1, tech2, tech3, tech4, tech5, tech6, tech7, tech8, tech9, tech10, tech11, tech12, tech13, tech14, tech15, tech16, tech17, tech18, tech19, tech20, tech21, tech22, tech23;
    AutoCompleteTextView technology;
    Animation fadein, fadeout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_price);

        tech1 = findViewById(R.id.civil);
        tech2 = findViewById(R.id.electrical);
        tech3 = findViewById(R.id.mechanical);
        tech4 = findViewById(R.id.computer);
        tech5 = findViewById(R.id.electronics);
        tech6 = findViewById(R.id.power);
        tech7 = findViewById(R.id.automobile);
        tech8 = findViewById(R.id.architecture);
        tech9 = findViewById(R.id.construction);
        tech10 = findViewById(R.id.environment);
        tech11 =findViewById(R.id.telecom);
        tech12 =findViewById(R.id.marine);
        tech13 =findViewById(R.id.textile);
        tech14 =findViewById(R.id.garments);

        fadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein_animation);
        fadeout = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout_animation);

        technology = findViewById(R.id.technology);
        String[] techno = getResources().getStringArray(R.array.technology);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, techno);
        technology.setText(arrayAdapter.getItem(0).toString(), false);
        technology.setAdapter(arrayAdapter);

        technology.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    tech1.setVisibility(View.GONE);
                    tech2.setVisibility(View.GONE);
                    tech3.setVisibility(View.GONE);
                    tech4.setVisibility(View.GONE);
                    tech5.setVisibility(View.GONE);
                    tech6.setVisibility(View.GONE);
                    tech7.setVisibility(View.GONE);
                    tech8.setVisibility(View.GONE);
                    tech9.setVisibility(View.GONE);
                    tech10.setVisibility(View.GONE);
                    tech11.setVisibility(View.GONE);
                    tech12.setVisibility(View.GONE);
                    tech13.setVisibility(View.GONE);
                    tech14.setVisibility(View.GONE);
                }else {
                    if (position == 1){
                        tech1.setVisibility(View.VISIBLE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 2){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.VISIBLE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 3){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.VISIBLE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 4){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.VISIBLE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 5){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.VISIBLE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 6){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.VISIBLE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 7){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.VISIBLE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 8){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.VISIBLE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 9){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.VISIBLE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 10){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.VISIBLE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 11){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.VISIBLE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 12){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.VISIBLE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 13){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.VISIBLE);
                        tech14.setVisibility(View.GONE);
                    }else if (position == 14){
                        tech1.setVisibility(View.GONE);
                        tech2.setVisibility(View.GONE);
                        tech3.setVisibility(View.GONE);
                        tech4.setVisibility(View.GONE);
                        tech5.setVisibility(View.GONE);
                        tech6.setVisibility(View.GONE);
                        tech7.setVisibility(View.GONE);
                        tech8.setVisibility(View.GONE);
                        tech9.setVisibility(View.GONE);
                        tech10.setVisibility(View.GONE);
                        tech11.setVisibility(View.GONE);
                        tech12.setVisibility(View.GONE);
                        tech13.setVisibility(View.GONE);
                        tech14.setVisibility(View.VISIBLE);
                    }
                }

            }
        });
    }
}