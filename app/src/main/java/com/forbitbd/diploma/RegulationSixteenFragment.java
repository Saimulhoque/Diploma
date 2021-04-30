package com.forbitbd.diploma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;


public class RegulationSixteenFragment extends Fragment {

    private EditText et_first, et_second, et_third, et_forth, et_fifth, et_sixth, et_seventh, et_eight;
    private TextView result;
    private MaterialButton GetGPA;

    public RegulationSixteenFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sixteen_regulation, container, false);
        et_first = view.findViewById(R.id.first);
        et_second = view.findViewById(R.id.second);
        et_third = view.findViewById(R.id.third);
        et_forth = view.findViewById(R.id.forth);
        et_fifth = view.findViewById(R.id.fifth);
        et_sixth = view.findViewById(R.id.sixth);
        et_seventh = view.findViewById(R.id.seventh);
        et_eight = view.findViewById(R.id.eighth);

        result = view.findViewById(R.id.cgpa);
        GetGPA = view.findViewById(R.id.btn_get);
        GetGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double first_semister = Double.parseDouble(et_first.getText().toString().trim());
                Double first = (first_semister) * 5;
                Double second_semister = Double.parseDouble(et_second.getText().toString().trim());
                Double second = (second_semister) * 5;
                Double third_semister = Double.parseDouble(et_third.getText().toString().trim());
                Double third = (third_semister) * 5;
                Double forth_semister = Double.parseDouble(et_forth.getText().toString().trim());
                Double forth = (forth_semister) * 10;
                Double fifth_semister = Double.parseDouble(et_fifth.getText().toString().trim());
                Double fifth = (fifth_semister) * 15;
                Double sixth_semister = Double.parseDouble(et_sixth.getText().toString().trim());
                Double sixth = (sixth_semister) * 20;
                Double seventh_semister = Double.parseDouble(et_seventh.getText().toString().trim());
                Double seventh = (seventh_semister) * 25;
                Double eight_semister = Double.parseDouble(et_eight.getText().toString().trim());
                Double eight = (eight_semister) * 15;
                Double sum = (first + second + third + forth + fifth + sixth + seventh + eight) / 100;
                String final_sum = new Double(sum).toString();
                result.setText(final_sum);
            }
        });
        return view;
    }
}