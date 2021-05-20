package com.example.covid19;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.NumberFormat;

import static com.example.covid19.Constants.COUNTRY_ACTIVE;
import static com.example.covid19.Constants.COUNTRY_DECEASED;
import static com.example.covid19.Constants.COUNTRY_NEW_CONFIRMED;
import static com.example.covid19.Constants.COUNTRY_NEW_DECEASED;
import static com.example.covid19.Constants.COUNTRY_RECOVERED;
import static com.example.covid19.Constants.COUNTRY_TESTS;

public class EachCountryDataActivity extends AppCompatActivity {

    private static final String COUNTRY_NAME = ;
    private static final String COUNTRY_CONFIRMED = ;
    private TextView tv_confirmed, tv_confirmed_new, tv_active, tv_active_new, tv_death, tv_death_new,
            tv_recovered, tv_recovered_new, tv_tests;

    private String str_countryName, str_confirmed, str_confirmed_new, str_active, str_active_new, str_death, str_death_new,
            str_recovered, str_recovered_new, str_tests;
    private PieChart pieChart;
    private MainActivity activity = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_country_data);

        //Fetching data which is passed from previous activity into this activity
        GetIntent();

        //Setting up the title of actionbar as State name
        getSupportActionBar().setTitle(str_countryName);

        //back menu icon on toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Initialise all textviews
        Init();

        LoadCountryData();
    }

    private void Init() {
        tv_confirmed = findViewById(R.id.activity_each_country_data_confirmed_textView);
        tv_confirmed_new = findViewById(R.id.activity_each_country_data_confirmed_new_textView);
        tv_active = findViewById(R.id.activity_each_country_data_active_textView);
        tv_active_new = findViewById(R.id.activity_each_country_data_active_new_textView);
        tv_recovered = findViewById(R.id.activity_each_country_data_recovered_textView);
        tv_recovered_new = findViewById(R.id.activity_each_country_data_recovered_new_textView);
        tv_death = findViewById(R.id.activity_each_country_data_death_textView);
        tv_death_new = findViewById(R.id.activity_each_country_data_death_new_textView);
        tv_tests = findViewById(R.id.activity_each_country_data_tests_textView);
        pieChart = findViewById(R.id.activity_each_country_data_piechart);
    }

    private void LoadCountryData() {
        //Show dialog
        activity.ShowDialog(this);

        Handler postDelayToshowProgress = new Handler();
        postDelayToshowProgress.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv_confirmed.setText(NumberFormat.getInstance().format(Integer.parseInt(str_confirmed)));
                tv_confirmed_new.setText("+"+NumberFormat.getInstance().format(Integer.parseInt(str_confirmed_new)));

                tv_active.setText(NumberFormat.getInstance().format(Integer.parseInt(str_active)));
                /*int int_active_new = Integer.parseInt(str_confirmed_new)
                        - (Integer.parseInt(str_recovered_new) + Integer.parseInt(str_death_new));
                tv_active_new.setText("+"+NumberFormat.getInstance().format(int_active_new<0 ? 0 : int_active_new));*/
                tv_active_new.setText("N/A");

                tv_death.setText(NumberFormat.getInstance().format(Integer.parseInt(str_death)));
                tv_death_new.setText("+"+NumberFormat.getInstance().format(Integer.parseInt(str_death_new)));

                tv_recovered.setText(NumberFormat.getInstance().format(Integer.parseInt(str_recovered)));
                //tv_recovered_new.setText("+"+NumberFormat.getInstance().format(Integer.parseInt(str_recovered_new)));
                tv_recovered_new.setText("N/A");

                tv_tests.setText(NumberFormat.getInstance().format(Integer.parseInt(str_tests)));

                //setting piechart
                pieChart.addPieSlice(new PieModel("Active", Integer.parseInt(str_active), Color.parseColor("#007afe")));
                pieChart.addPieSlice(new PieModel("Recovered", Integer.parseInt(str_recovered), Color.parseColor("#08a045")));
                pieChart.addPieSlice(new PieModel("Deceased", Integer.parseInt(str_death), Color.parseColor("#F6404F")));

                pieChart.startAnimation();

                activity.DismissDialog();
            }
        },1000);

    }

    private void GetIntent() {
        Intent intent = getIntent();
        str_countryName = intent.getStringExtra(COUNTRY_NAME);
        str_confirmed = intent.getStringExtra(COUNTRY_CONFIRMED);
        str_active = intent.getStringExtra(COUNTRY_ACTIVE);
        str_death = intent.getStringExtra(COUNTRY_DECEASED);
        str_recovered = intent.getStringExtra(COUNTRY_RECOVERED);
        str_confirmed_new = intent.getStringExtra(COUNTRY_NEW_CONFIRMED);
        str_death_new = intent.getStringExtra(COUNTRY_NEW_DECEASED);
        str_tests = intent.getStringExtra(COUNTRY_TESTS);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public static class StateWiseModel {
        private String state;
        private String confirmed;
        private String confirmed_new;
        private String active;
        private String death;
        private String death_new;
        private String recovered;
        private String recovered_new;
        private String lastupdate;
    
        public StateWiseModel(String state, String confirmed, String confirmed_new, String active,
                              String death, String death_new, String recovered, String recovered_new, String lastupdate) {
            this.state = state;
            this.confirmed = confirmed;
            this.confirmed_new = confirmed_new;
            this.active = active;
            this.death = death;
            this.death_new = death_new;
            this.recovered = recovered;
            this.recovered_new = recovered_new;
            this.lastupdate = lastupdate;
        }
    
        public String getState() {
            return state;
        }
    
        public String getConfirmed() {
            return confirmed;
        }
    
        public String getConfirmed_new() {
            return confirmed_new;
        }
    
        public String getActive() {
            return active;
        }
    
        public String getDeath() {
            return death;
        }
    
        public String getDeath_new() {
            return death_new;
        }
    
        public String getRecovered() {
            return recovered;
        }
    
        public String getRecovered_new() {
            return recovered_new;
        }
    
        public String getLastupdate() {
            return lastupdate;
        }
    }
}