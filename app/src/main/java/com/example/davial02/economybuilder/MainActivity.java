package com.example.davial02.economybuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    final int EconomyAdvisorHappiness = 0;
    final int PoliticalAdvisorHappiness = 0;
    final int MilitaryAdvisorHappiness = 0;
    final int CulturalAdvisorHappiness = 0;


    public String intstrconverter(Integer value) {
        String finalString = value.toString();
        finalString = finalString.substring(0, -3);
        finalString = finalString+"k";
        return finalString;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


//Have a variable keep track of how happy each advisor is:
//Economy, Political, Military, Cultural. Each advisor takes a different amount of time to
//have their faction become happy again.

//Overall goal is for leader to make 1000000$ before they are killed/deposed

//Define a function that takes an integer and returns a string in format 10000 = "10k"

//Add exclamation points to show which categories are suffering