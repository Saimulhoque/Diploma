package com.forbitbd.diploma.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.forbitbd.diploma.R;
import com.forbitbd.diploma.ui.main.MainActivity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class BaseActivity extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    public void checkInternet(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo data = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifi != null & data != null) && (wifi.isConnected() | data.isConnected())) {
        }else{
            Toast toast = Toast.makeText(BaseActivity.this, "No Internet Connection!", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void showAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        }
    }

    public void createAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, getString(R.string.test_ad_id), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;

                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                createAd();
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }

}
