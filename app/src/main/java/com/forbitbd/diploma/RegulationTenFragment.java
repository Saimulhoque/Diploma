package com.forbitbd.diploma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;


public class RegulationTenFragment extends Fragment {

    AutoCompleteTextView etsemester;
    TextInputLayout tione, titwo, tithree, tifour, tifive, tisix, tiseven, tieight;
    private EditText et_first, et_second, et_third, et_forth, et_fifth, et_sixth, et_seventh, et_eight;
    private MaterialButton GetGPA;
    private TextView result;
    double number;

    String[] Semesters = {"1", "2", "3", "4", "5", "6", "7", "8"};

    public RegulationTenFragment() {
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
        View view = inflater.inflate(R.layout.fragment_ten_regulation, container, false);

        tione = view.findViewById(R.id.input1);
        titwo = view.findViewById(R.id.input2);
        tithree = view.findViewById(R.id.input3);
        tifour = view.findViewById(R.id.input4);
        tifive = view.findViewById(R.id.input5);
        tisix = view.findViewById(R.id.input6);
        tiseven = view.findViewById(R.id.input7);
        tieight = view.findViewById(R.id.input8);

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

        etsemester = view.findViewById(R.id.semester);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, Semesters);
        etsemester.setThreshold(1);
        etsemester.setAdapter(adapter);
        etsemester.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String sem = etsemester.getText().toString().trim();
                if (sem.isEmpty()) {
                    Toast.makeText(getContext(), "Please Enter Values ", Toast.LENGTH_SHORT).show();
                } else {
                    number = Double.parseDouble(etsemester.getText().toString().trim());
                    if (number == 1) {
                        Toast.makeText(getContext(), "Atleast 2 Semester Required!", Toast.LENGTH_SHORT).show();
                    }
                    if (number == 2) {
                        GetGPA.setVisibility(View.VISIBLE);
                        tione.setVisibility(View.VISIBLE);
                        titwo.setVisibility(View.VISIBLE);
                        tithree.setVisibility(View.GONE);
                        tifour.setVisibility(View.GONE);
                        tifive.setVisibility(View.GONE);
                        tisix.setVisibility(View.GONE);
                        tiseven.setVisibility(View.GONE);
                        tieight.setVisibility(View.GONE);
                    }
                    if (number == 3) {
                        GetGPA.setVisibility(View.VISIBLE);
                        tithree.setVisibility(View.VISIBLE);
                        tifour.setVisibility(View.GONE);
                        tifive.setVisibility(View.GONE);
                        tisix.setVisibility(View.GONE);
                        tiseven.setVisibility(View.GONE);
                        tieight.setVisibility(View.GONE);
                    }
                    if (number == 4) {
                        GetGPA.setVisibility(View.VISIBLE);
                        tione.setVisibility(View.VISIBLE);
                        titwo.setVisibility(View.VISIBLE);
                        tithree.setVisibility(View.VISIBLE);
                        tifour.setVisibility(View.VISIBLE);
                        tifive.setVisibility(View.GONE);
                        tisix.setVisibility(View.GONE);
                        tiseven.setVisibility(View.GONE);
                        tieight.setVisibility(View.GONE);
                    }
                    if (number == 5) {
                        GetGPA.setVisibility(View.VISIBLE);
                        tione.setVisibility(View.VISIBLE);
                        titwo.setVisibility(View.VISIBLE);
                        tithree.setVisibility(View.VISIBLE);
                        tifour.setVisibility(View.VISIBLE);
                        tifive.setVisibility(View.VISIBLE);
                        tisix.setVisibility(View.GONE);
                        tiseven.setVisibility(View.GONE);
                        tieight.setVisibility(View.GONE);
                    }
                    if (number == 6) {
                        GetGPA.setVisibility(View.VISIBLE);
                        tione.setVisibility(View.VISIBLE);
                        titwo.setVisibility(View.VISIBLE);
                        tithree.setVisibility(View.VISIBLE);
                        tifour.setVisibility(View.VISIBLE);
                        tifive.setVisibility(View.VISIBLE);
                        tisix.setVisibility(View.VISIBLE);
                        tiseven.setVisibility(View.GONE);
                        tieight.setVisibility(View.GONE);
                    }
                    if (number == 7) {
                        GetGPA.setVisibility(View.VISIBLE);
                        tione.setVisibility(View.VISIBLE);
                        titwo.setVisibility(View.VISIBLE);
                        tithree.setVisibility(View.VISIBLE);
                        tifour.setVisibility(View.VISIBLE);
                        tifive.setVisibility(View.VISIBLE);
                        tisix.setVisibility(View.VISIBLE);
                        tiseven.setVisibility(View.VISIBLE);
                        tieight.setVisibility(View.GONE);
                    }
                    if (number == 8) {
                        GetGPA.setVisibility(View.VISIBLE);
                        tione.setVisibility(View.VISIBLE);
                        titwo.setVisibility(View.VISIBLE);
                        tithree.setVisibility(View.VISIBLE);
                        tifour.setVisibility(View.VISIBLE);
                        tifive.setVisibility(View.VISIBLE);
                        tisix.setVisibility(View.VISIBLE);
                        tiseven.setVisibility(View.VISIBLE);
                        tieight.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        GetGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setVisibility(View.VISIBLE);
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