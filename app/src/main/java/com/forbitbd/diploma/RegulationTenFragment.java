package com.forbitbd.diploma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class RegulationTenFragment extends Fragment {

    AutoCompleteTextView etsemester;
    TextInputLayout tione, titwo, tithree, tifour, tifive, tisix, tiseven, tieight;
    private EditText et_first, et_second, et_third, et_forth, et_fifth, et_sixth, et_seventh, et_eight;
    private MaterialButton GetGPA;
    private TextView result;
    double number;
    DecimalFormat Formatter;
    Animation fadein,fadeout;
    double sem1, sem2, sem3, sem4, sem5, sem6, sem7, sem8;
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

        fadein = AnimationUtils.loadAnimation(getContext(),R.anim.fadein_animation);
        fadeout = AnimationUtils.loadAnimation(getContext(),R.anim.fadeout_animation);

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
        Formatter = new DecimalFormat("#0.00");

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
                        Toast.makeText(getContext(), "At least 2 Semester Required!", Toast.LENGTH_SHORT).show();
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
                        tione.setVisibility(View.VISIBLE);
                        titwo.setVisibility(View.VISIBLE);
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
                if (et_first.getText().toString().isEmpty() || et_second.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Enter At Least Two Semester's GPA!", Toast.LENGTH_SHORT).show();
                    et_first.setError("Enter 1st Semester!");
                    et_first.requestFocus();
                    et_second.setError("Enter 2nd Semester!");
                    et_second.requestFocus();
                }else{
                    if (tione.getVisibility() == View.GONE) {
                        sem1 = 0;
                    } else {
                        sem1 = Double.parseDouble(et_first.getText().toString().trim());
                    }
                    if (titwo.getVisibility() == View.GONE) {
                        sem2 = 0;
                    } else {
                        sem2 = Double.parseDouble(et_second.getText().toString().trim());
                    }
                    if (tithree.getVisibility() == View.GONE) {
                        sem3 = 0;
                    } else {
                        sem3 = Double.parseDouble(et_third.getText().toString().trim());
                    }
                    if (tifour.getVisibility() == View.GONE) {
                        sem4 = 0;
                    } else {
                        sem4 = Double.parseDouble(et_forth.getText().toString().trim());
                    }
                    if (tifive.getVisibility() == View.GONE) {
                        sem5 = 0;
                    } else {
                        sem5 = Double.parseDouble(et_fifth.getText().toString().trim());
                    }
                    if (tisix.getVisibility() == View.GONE) {
                        sem6 = 0;
                    } else {
                        sem6 = Double.parseDouble(et_sixth.getText().toString().trim());
                    }
                    if (tiseven.getVisibility() == View.GONE) {
                        sem7 = 0;
                    } else {
                        sem7 = Double.parseDouble(et_seventh.getText().toString().trim());
                    }
                    if (tieight.getVisibility() == View.GONE) {
                        sem8 = 0;
                    } else {
                        sem8 = Double.parseDouble(et_eight.getText().toString().trim());
                    }

                    Double total = (sem1 * 5 + sem2 * 5 + sem3 * 5 + sem4 * 15 + sem5 * 15 + sem6 * 20 + sem7 * 25 + sem8 * 10) / 100;
                    result.setText("CGPA-" + Formatter.format(total));
                    result.setVisibility(View.VISIBLE);
                    result.startAnimation(fadein);
                }
            }
        });
        return view;
    }
}