package com.example.t00527623.basiccalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        // FIXED ALL THE BUGS!!!!!!!

        // Digits
        findViewById(R.id.B1).setOnClickListener(handlenumbers);
        findViewById(R.id.B2).setOnClickListener(handlenumbers);
        findViewById(R.id.B3).setOnClickListener(handlenumbers);
        findViewById(R.id.B4).setOnClickListener(handlenumbers);
        findViewById(R.id.B5).setOnClickListener(handlenumbers);
        findViewById(R.id.B6).setOnClickListener(handlenumbers);
        findViewById(R.id.B7).setOnClickListener(handlenumbers);
        findViewById(R.id.B8).setOnClickListener(handlenumbers);
        findViewById(R.id.B9).setOnClickListener(handlenumbers);
        findViewById(R.id.B0).setOnClickListener(handlenumbers);
        findViewById(R.id.B00).setOnClickListener(handlenumbers);
        findViewById(R.id.Bpoint).setOnClickListener(handlenumbers);

        // Operands
        findViewById(R.id.Cclear).setOnClickListener(handleoperands);
        findViewById(R.id.Bplus).setOnClickListener(handleoperands);
        findViewById(R.id.Bminus).setOnClickListener(handleoperands);
        findViewById(R.id.Bdiv).setOnClickListener(handleoperands);
        findViewById(R.id.Btimes).setOnClickListener(handleoperands);
        findViewById(R.id.BBack).setOnClickListener(handleoperands);
        findViewById(R.id.Bequal).setOnClickListener(handleoperands);
        findViewById(R.id.PMC).setOnClickListener(handleoperands);

        // Advanced Memory
        findViewById(R.id.MemC).setOnClickListener(handlememory);
        findViewById(R.id.MemR).setOnClickListener(handlememory);
        findViewById(R.id.MemN).setOnClickListener(handlememory);
        findViewById(R.id.MemP).setOnClickListener(handlememory);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc, menu);
        return true;
    }

    // Class variable used to check if equals has been operated and makes it so operations
    // performed after equals has been pressed do not include previous variables
    private boolean equalschck = false;

    // Memory Class Variable
    private double Memory = 0.0;
    private String lastchar;
    private boolean decimalchk = false;

    // Click listener for Memory
    private View.OnClickListener handlememory = new View.OnClickListener() {
        public void onClick(View v) {
            double tmpdbl;
            String tmp;
            TextView resultsstd = (TextView) findViewById(R.id.results);
            switch (v.getId()) {
                case R.id.MemC:
                    Memory = 0.0;
                    break;

                case R.id.MemN:
                    tmp = resultsstd.getText().toString();
                    if(resultsstd.length() > 0) {
                        tmp = resultsstd.getText().toString();
                        if (tmp.equals(null) || tmp.equals(".")) {
                            resultsstd.setText("");
                            break;
                        } else {
                            tmpdbl = Double.parseDouble(tmp);
                            Memory = Memory - tmpdbl;
                        }
                    }
                    break;

                case R.id.MemP:
                    tmp = resultsstd.getText().toString();
                    if(resultsstd.length() > 0) {
                        tmp = resultsstd.getText().toString();
                        if (tmp.equals(null) || tmp.equals(".")) {
                            resultsstd.setText("");
                            break;
                        } else {
                            tmpdbl = Double.parseDouble(tmp);
                            Memory = Memory + tmpdbl;
                        }
                    }
                    break;

                case R.id.MemR:
                    equalschck = true;
                    resultsstd.setText(String.valueOf(Memory));
                    break;
            }
        }
    };





    // Click listener for Digits
    private View.OnClickListener handlenumbers = new View.OnClickListener() {
        public void onClick(View v) {
            TextView resultsstd = (TextView) findViewById(R.id.results);
            TextView hist = (TextView) findViewById(R.id.history);
            if (equalschck == true) {
                hist.setText("");
                resultsstd.setText("");
            }
            equalschck = false;
            Button std = (Button)v;
            resultsstd.append(std.getText());
        }
    };

    // Click Listener for Operands
    private View.OnClickListener handleoperands = new View.OnClickListener() {
        public void onClick(View v) {
            TextView resultsstd = (TextView) findViewById(R.id.results);
            TextView hist = (TextView) findViewById(R.id.history);
            String tmp, tmp1, tmp2, tmp3;
            double plus=0, minus=0, div=0, times=0, equals=0, PMCs, PMCc;
            switch (v.getId()) {
                case R.id.Cclear:
                    resultsstd.setText("");
                    hist.setText("");
                    break;

                case R.id.Bplus:
                    if(resultsstd.length() > 0){
                        if (equalschck == true){
                            hist.setText("");
                        }
                        equalschck = false;
                        tmp = resultsstd.getText().toString();
                        if (tmp.equals("NaN") || tmp.equals("Infinity") || tmp.equals(null) || tmp.equals(".")){
                            resultsstd.setText("");
                            break;
                        } else {
                            tmp2 = hist.getText().toString();
                            plus = Double.parseDouble(tmp);
                            hist.setText(tmp2 + tmp + " + ");
                            lastchar = "+";
                            resultsstd.setText("");
                        }
                    }
                    break;

                case R.id.Bminus:
                    if(resultsstd.length() > 0) {
                        if (equalschck == true){
                            hist.setText("");
                        }
                        equalschck = false;
                        tmp = resultsstd.getText().toString();
                        if (tmp.equals("NaN") || tmp.equals("Infinity") || tmp.equals(null) || tmp.equals(".")) {
                            resultsstd.setText("");
                            break;
                        } else {
                            tmp2 = hist.getText().toString();
                            minus = Double.parseDouble(tmp);
                            hist.setText(tmp2 + tmp + " ‑ ");
                            lastchar = "‑";
                            resultsstd.setText("");
                        }
                    }
                    break;

                case R.id.Btimes:
                    if(resultsstd.length() > 0) {
                        if (equalschck == true){
                            hist.setText("");
                        }
                        equalschck = false;
                        tmp = resultsstd.getText().toString();
                        if (tmp.equals("NaN") || tmp.equals("Infinity") || tmp.equals(null) || tmp.equals(".")) {
                            resultsstd.setText("");
                            break;
                        } else {
                            tmp2 = hist.getText().toString();
                            times = Double.parseDouble(tmp);
                            hist.setText(tmp2 + tmp + " * ");
                            lastchar = "*";
                            resultsstd.setText("");
                        }
                    }
                    break;

                case R.id.Bdiv:
                    if(resultsstd.length() > 0) {
                        if (equalschck == true){
                            hist.setText("");
                        }
                        equalschck = false;
                        tmp = resultsstd.getText().toString();
                        if (tmp.equals("NaN") || tmp.equals("Infinity") || tmp.equals(null) || tmp.equals(".")) {
                            resultsstd.setText("");
                            break;
                        } else {
                            tmp2 = hist.getText().toString();
                            div = Double.parseDouble(tmp);
                            hist.setText(tmp2 + tmp + " ÷ ");
                            lastchar = "÷";
                            resultsstd.setText("");
                        }
                    }
                    break;

                case R.id.BBack:
                    tmp = resultsstd.getText().toString();
                    if (resultsstd.length() > 0){
                        tmp1 = tmp.substring(0, tmp.length() - 1);
                        resultsstd.setText(tmp1);
                    }
                    break;

                case R.id.Bequal:
                    if(resultsstd.length() > 0) {
                        if (equalschck == true){
                            break;
                        } else {
                            equalschck = false;
                            tmp = resultsstd.getText().toString();

                            // Equals 0 Functions not fully implemented atm
                            if (tmp.equals("NaN") || tmp.equals("Infinity") || tmp.equals(null) || tmp.equals(".")) {
                                resultsstd.setText(tmp);
                                break;
                            } else {
                                tmp2 = hist.getText().toString();
                                hist.setText(tmp2 + tmp);
                                tmp3 = hist.getText().toString();
                                equalscalc(tmp3);
                                equalschck = true;
                            }
                        }
                    }
                    break;

                case R.id.PMC:
                    String chkperiod;
                    chkperiod = resultsstd.getText().toString();
                    if(resultsstd.length() > 0 && !chkperiod.equals(".")) {
                        tmp = resultsstd.getText().toString();
                        PMCs = Double.parseDouble(tmp);
                        PMCc = PMCs * -1;
                        resultsstd.setText(String.valueOf(PMCc));
                    }
                    break;
            }
        }
    };

    // Math operation function
    public void equalscalc (String input) {
        TextView resultsstd = (TextView) findViewById(R.id.results);
        input = input.replace(" ","");

        String parsedInteger = "";
        String operator = "";
        double num = 0;
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            // Checks if digit is digit or period so doubles are allowed unfortunately multiple
            // periods will result in an error
            if (Character.isDigit(c) || c == '.' || c == '-') {
                parsedInteger += c;
            }
            // Checks for operators Minus in this case has been modified to the UTF-8 character
            // named non-breaking hyphen for added functionality with negative numbers
            if (c == '+' || c == '‑' || c == '*' || c == '÷' || i == input.length()-1){
                double parsed = Double.parseDouble(parsedInteger);
                if (operator == "") {
                    num = parsed;
                }
                else {
                    if (operator.equals("+")) {
                        num += parsed;
                    }else if (operator.equals("‑")){
                        num -= parsed;
                    }else if (operator.equals("*")){
                        num = num * parsed;
                    }else if (operator.equals("÷")){
                        num = num / parsed;
                    }
                }

                parsedInteger ="";
                operator = ""+c;
            }
        }
        DecimalFormat formatter = new DecimalFormat("##.#####E0");
        String chk = String.valueOf(num);
        if(chk.length() > 12) {
            resultsstd.setText(String.valueOf(formatter.format(num)));
        } else {
            resultsstd.setText(String.valueOf(String.valueOf(num)));
        }
    }
}
