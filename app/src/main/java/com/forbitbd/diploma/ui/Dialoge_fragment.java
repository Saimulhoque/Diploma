package com.forbitbd.diploma.ui;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;

import android.widget.TextView;

import com.forbitbd.diploma.MyListener;
import com.forbitbd.diploma.R;
import com.forbitbd.diploma.model.Result;
import com.google.android.material.button.MaterialButton;



public class Dialoge_fragment extends DialogFragment {

    private TextView tvone,sem,year,roll;
    private MaterialButton btncancel;
    private MyListener listener;

    private Result result;

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


        if (getArguments() != null){
            this.result = (Result) getArguments().getSerializable("result");
            roll.setText(result.getRoll());
            sem.setText(String.valueOf(result.getSemester()));
            year.setText(String.valueOf(result.getYear()));
        }

        if(result.getState().equals("Pass")){
            tvone.setText("Your result is " + result.getCgpa());
        }else {
            tvone.setText("You've failed in" + getSubjects(result));
        }

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onCloseButtonClick();
                    dismiss();
                }
            }
        });

        AlertDialog alertDialog = new AlertDialog.Builder(getContext(), R.style.Theme_AppCompat_Dialog_Alert).create();
        alertDialog.setView(view);
        return alertDialog;
    }

    private String getSubjects(Result result){
        String val = "\n";
        for (String x:result.getSubjects()){
            val = val+x+"\n";
        }
        return val;
    }
}