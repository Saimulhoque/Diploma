package com.forbitbd.diploma;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

import static android.content.ContentValues.TAG;

public class Dialoge_fragment extends DialogFragment {

    private TextView tvone,sem,year,roll;
    private MaterialButton btncancel;
    private MyListener listener;

    public Dialoge_fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.listener = (MyListener) getActivity();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.fragment_dialoge_fragment, null);

        sem = view.findViewById(R.id.semester);
        roll = view.findViewById(R.id.roll);
        year = view.findViewById(R.id.year);
        tvone = view.findViewById(R.id.result);
        btncancel = view.findViewById(R.id.btncancel);

        String getArgument = getArguments().getString("data");

        if (getArguments() != null){
            roll.setText(getArguments().getString("roll"));
            sem.setText(getArguments().getString("sem"));
            year.setText(getArguments().getString("year"));
        }

        if (getArgument.length() > 8) {
            tvone.setText("You've failed in" + getArgument);

        }else {
            tvone.setText("Your result is " + getArgument);
        }

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onRewardButtonClick();
                    dismiss();
                }
            }
        });

        AlertDialog alertDialog = new AlertDialog.Builder(getContext(), R.style.Theme_AppCompat_Dialog_Alert).create();
        alertDialog.setView(view);
        return alertDialog;
    }
}