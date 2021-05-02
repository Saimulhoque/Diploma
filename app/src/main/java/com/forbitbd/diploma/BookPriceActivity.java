package com.forbitbd.diploma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class BookPriceActivity extends AppCompatActivity {

    MaterialCardView tech1, tech2;
    AutoCompleteTextView technology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_price);

        tech1 = findViewById(R.id.computer);
        tech2 = findViewById(R.id.electrical);

        technology = findViewById(R.id.technology);
        String[] techno = getResources().getStringArray(R.array.technology);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, techno);
        technology.setText(arrayAdapter.getItem(0).toString(), false);
        technology.setAdapter(arrayAdapter);

        technology.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String tech = technology.getText().toString();
                if (position == 0){
                    tech1.setVisibility(View.GONE);
                    tech2.setVisibility(View.GONE);
                }
                if (position == 1){
                    tech1.setVisibility(View.VISIBLE);
                    tech2.setVisibility(View.GONE);
                }if (position == 2){
                    tech2.setVisibility(View.VISIBLE);
                    tech1.setVisibility(View.GONE);
                }


            }
        });
    }
}