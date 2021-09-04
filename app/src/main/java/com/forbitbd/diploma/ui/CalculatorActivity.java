package com.forbitbd.diploma.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.forbitbd.diploma.R;
import com.forbitbd.diploma.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class CalculatorActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private RegulationSixteenFragment sixteenFragment;
    private RegulationTenFragment tenFragment;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        sixteenFragment = new RegulationSixteenFragment();
        tenFragment = new RegulationTenFragment();
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(tenFragment, "Regulation-2010");
        viewPagerAdapter.addFragment(sixteenFragment, "Regulation-2016");
        viewPager.setAdapter(viewPagerAdapter);
    }


}