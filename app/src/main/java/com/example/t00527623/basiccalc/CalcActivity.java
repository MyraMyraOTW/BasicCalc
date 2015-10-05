package com.example.t00527623.basiccalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

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

        // Operands

        // Advanced Memory
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc, menu);
        return true;
    }

    // Click listener for Digits
    private View.OnClickListener handlenumbers = new View.OnClickListener() {
        public  void onClick(View v) {
            Button std = (Button)v;
            TextView resultsstd = (TextView) findViewById(R.id.results);
            resultsstd.append(std.getText());
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
