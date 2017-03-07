package com.example.davial02.economybuilder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private float EconomyAdvisorHappiness = 1;    //5+ == happy
    private float economicStagnationYears = 0;
    private float PoliticalAdvisorHappiness = 1;  //2-4 == neutral
    private float politicalStagnationYears = 0;
    private float MilitaryAdvisorHappiness = 1;   //0-1 == angry
    private float militaryStagnationYears = 0;    //Begins stagnation with 5+ unhappiness, unchecked for five years
    private float SocialAdvisorHappiness = 1;   //0- == rebellious
    private float socialStagnationYears = 0;
    private int currentYear = 1000;             //Events happen every 25 years
    private Integer mainBudget = 1000;
    private Integer mainPersonalFunds = 0;

    //REDRAW VIEW
    public void redrawView() {
        final TextView mainBudgettv = (TextView) findViewById(R.id.mainBudgetView);
        mainBudgettv.setText(mainBudget.toString());

        final GridLayout mainMilitaryView = (GridLayout) findViewById(R.id.militaryMainLayout);
        if (MilitaryAdvisorHappiness >= 5) {
            mainMilitaryView.setBackgroundColor(Color.parseColor("#6ED958"));
        } else if (MilitaryAdvisorHappiness >= 2 && MilitaryAdvisorHappiness < 5) {
            mainMilitaryView.setBackgroundColor(Color.parseColor("#F3E93C"));
        } else if (MilitaryAdvisorHappiness >= 0 && MilitaryAdvisorHappiness < 2) {
            mainMilitaryView.setBackgroundColor(Color.parseColor("#F39A3C"));
        } else if (MilitaryAdvisorHappiness < 0) {
            mainMilitaryView.setBackgroundColor(Color.parseColor("#EF3B44"));
        }

        final GridLayout mainSocialView = (GridLayout) findViewById(R.id.socialMainLayout);
        if (SocialAdvisorHappiness >= 5) {
            mainSocialView.setBackgroundColor(Color.parseColor("#6ED958"));
        } else if (SocialAdvisorHappiness >= 2 && SocialAdvisorHappiness < 5) {
            mainSocialView.setBackgroundColor(Color.parseColor("#F3E93C"));
        } else if (SocialAdvisorHappiness >= 0 && SocialAdvisorHappiness < 2) {
            mainSocialView.setBackgroundColor(Color.parseColor("#F39A3C"));
        } else if (SocialAdvisorHappiness < 0) {
            mainSocialView.setBackgroundColor(Color.parseColor("#EF3B44"));
        }

        final GridLayout mainEconomyView = (GridLayout) findViewById(R.id.economyMainLayout);
        if (EconomyAdvisorHappiness >= 5) {
            mainEconomyView.setBackgroundColor(Color.parseColor("#6ED958"));
        } else if (EconomyAdvisorHappiness >= 2 && EconomyAdvisorHappiness < 5) {
            mainEconomyView.setBackgroundColor(Color.parseColor("#F3E93C"));
        } else if (EconomyAdvisorHappiness >= 0 && EconomyAdvisorHappiness < 2) {
            mainEconomyView.setBackgroundColor(Color.parseColor("#F39A3C"));
        } else if (EconomyAdvisorHappiness < 0) {
            mainEconomyView.setBackgroundColor(Color.parseColor("#EF3B44"));
        }

        final GridLayout mainPoliticalView = (GridLayout) findViewById(R.id.politicalMainLayout);
        if (PoliticalAdvisorHappiness >= 5) {
            mainPoliticalView.setBackgroundColor(Color.parseColor("#6ED958"));
        } else if (PoliticalAdvisorHappiness >= 2 && PoliticalAdvisorHappiness < 5) {
            mainPoliticalView.setBackgroundColor(Color.parseColor("#F3E93C"));
        } else if (PoliticalAdvisorHappiness >= 0 && PoliticalAdvisorHappiness < 2) {
            mainPoliticalView.setBackgroundColor(Color.parseColor("#F39A3C"));
        } else if (PoliticalAdvisorHappiness <= 0) {
            mainPoliticalView.setBackgroundColor(Color.parseColor("#EF3B44"));
        }
    }

    public void nextYear() {
        final TextView tvpersonal1 = (TextView) findViewById(R.id.personal_salary_val);
        final TextView tvpersonaltotal = (TextView) findViewById(R.id.personal_salary_total_val);
        mainBudget += 250;
        EconomyAdvisorHappiness -= 0.25;
        PoliticalAdvisorHappiness -= 0.25;
        MilitaryAdvisorHappiness -= 0.25;
        SocialAdvisorHappiness -= 0.25;

        //Take salary and add it to the personal bank account
        Integer currentSalary = Integer.parseInt(tvpersonal1.getText().toString());
        mainPersonalFunds+=currentSalary;
        tvpersonaltotal.setText(mainPersonalFunds.toString());

        redrawView();
    }

    //onCreate (all init button code)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redrawView();


        final Button nextYear = (Button) findViewById(R.id.nextday);
        nextYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextYear();
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////

        /////MILITARY - ALL/////

////////////////////////////////////////////////////////////////////////////////////////////////////

        final TextView tvmilitary1 = (TextView) findViewById(R.id.sm_unit_val);
        final TextView tvmilitary2 = (TextView) findViewById(R.id.med_unit_val);
        final TextView tvmilitary3 = (TextView) findViewById(R.id.lg_unit_val);

        final Button clearMilitary = (Button) findViewById(R.id.clear_all_military);
        clearMilitary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Restores mainBudget
                Integer input1 = Integer.parseInt(tvmilitary1.getText().toString());
                Integer input2 = Integer.parseInt(tvmilitary2.getText().toString());
                Integer input3 = Integer.parseInt(tvmilitary3.getText().toString());
                float input1float = (float) input1;
                float input2float = (float) input2;
                float input3float = (float) input3;
                MilitaryAdvisorHappiness -= (input1float/10*(float) 0.1) + (input2float/20*(float) 0.2) + (input3float/50*(float) 0.5);
                SocialAdvisorHappiness += (input1float/10*(float) 0.05) + (input2float/20*(float) 0.1) + (input3float/50*(float) 0.25);
                SocialAdvisorHappiness -= (input1float/10*(float) 0.025) + (input2float/20*(float) 0.05) + (input3float/50*(float) 0.125);
                mainBudget += input1 + input2 + input3;
                //Erases military textviews
                tvmilitary1.setText("0");
                tvmilitary2.setText("0");
                tvmilitary3.setText("0");
                redrawView();
            }
        });

        final Button increase_sm_units = (Button) findViewById(R.id.increase_sm_units);
        increase_sm_units.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and adds to it
                Integer input1 = Integer.parseInt(tvmilitary1.getText().toString());
                Integer finalInt = input1 + 10;

                if (mainBudget-10 >= 0) {
                    MilitaryAdvisorHappiness += .1;
                    SocialAdvisorHappiness -= 0.05;
                    PoliticalAdvisorHappiness += 0.025;
                    mainBudget -= 10;
                    tvmilitary1.setText(finalInt.toString());

                    redrawView();
                }


            }
        });
        final Button decrease_sm_units = (Button) findViewById(R.id.decrease_sm_units);
        decrease_sm_units.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tvmilitary1.getText().toString());
                Integer finalInt = input1 - 10;

                if (input1-10 >= 0) {
                    MilitaryAdvisorHappiness -= .1;
                    SocialAdvisorHappiness += 0.05;
                    PoliticalAdvisorHappiness -= 0.025;
                    tvmilitary1.setText(finalInt.toString());
                    mainBudget += 10;
                    redrawView();
                }
            }
        });
        final Button increase_med_units = (Button) findViewById(R.id.increase_med_units);
        increase_med_units.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and adds to it
                Integer input1 = Integer.parseInt(tvmilitary2.getText().toString());
                Integer finalInt = input1 + 20;

                if (mainBudget-20 >= 0) {
                    MilitaryAdvisorHappiness += .2;
                    SocialAdvisorHappiness -= 0.1;
                    PoliticalAdvisorHappiness += 0.05;
                    mainBudget -= 20;
                    tvmilitary2.setText(finalInt.toString());

                    redrawView();
                }


            }
        });
        final Button decrease_med_units = (Button) findViewById(R.id.decrease_med_units);
        decrease_med_units.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tvmilitary2.getText().toString());
                Integer finalInt = input1 - 20;

                if (input1-20 >= 0) {
                    MilitaryAdvisorHappiness -= .2;
                    SocialAdvisorHappiness += 0.1;
                    PoliticalAdvisorHappiness -= 0.05;
                    tvmilitary2.setText(finalInt.toString());
                    mainBudget += 20;
                    redrawView();
                }
            }
        });
        final Button increase_lg_units = (Button) findViewById(R.id.increase_lg_units);
        increase_lg_units.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and adds to it
                Integer input1 = Integer.parseInt(tvmilitary3.getText().toString());
                Integer finalInt = input1 + 50;

                if (mainBudget-50 >= 0) {
                    MilitaryAdvisorHappiness += .5;
                    SocialAdvisorHappiness -= 0.25;
                    PoliticalAdvisorHappiness += 0.0125;
                    mainBudget -= 50;
                    tvmilitary3.setText(finalInt.toString());

                    redrawView();
                }


            }
        });
        final Button decrease_lg_units = (Button) findViewById(R.id.decrease_lg_units);
        decrease_lg_units.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tvmilitary3.getText().toString());
                Integer finalInt = input1 - 50;

                if (input1-50 >= 0) {
                    MilitaryAdvisorHappiness -= .5;
                    SocialAdvisorHappiness += 0.25;
                    PoliticalAdvisorHappiness -= 0.0125;
                    tvmilitary3.setText(finalInt.toString());
                    mainBudget += 50;
                    redrawView();
                }
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////

        /////ECONOMY - ALL/////

////////////////////////////////////////////////////////////////////////////////////////////////////

        final TextView tveconomy1 = (TextView) findViewById(R.id.social_funding_val);
        final TextView tveconomy2 = (TextView) findViewById(R.id.tax_break_val);
        final TextView tveconomy3 = (TextView) findViewById(R.id.pay_bribe_economy_price_label);

        final Button clearEconomy = (Button) findViewById(R.id.clear_all_economy);
        clearEconomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Restores mainBudget
                Integer input1 = Integer.parseInt(tveconomy1.getText().toString());
                Integer input2 = Integer.parseInt(tveconomy2.getText().toString());
                float input1float = (float) input1;
                float input2float = (float) input2;
                EconomyAdvisorHappiness -= (input1float/15*(float) 0.15) + (input2float/25*(float) 0.25);
                SocialAdvisorHappiness -= (input1float/15*(float) 0.0725) - (input2float/25*(float) 0.125);
                mainBudget += input1 + input2;
                //Erases military textviews
                tveconomy1.setText("0");
                tveconomy2.setText("0");
                redrawView();
            }
        });

        final Button increase_social_funding = (Button) findViewById(R.id.increase_social_funding);
        increase_social_funding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and adds to it
                Integer input1 = Integer.parseInt(tveconomy1.getText().toString());
                Integer finalInt = input1 + 15;

                if (mainBudget-15 >= 0) {
                    EconomyAdvisorHappiness += .15;
                    SocialAdvisorHappiness -= 0.0725;
                    mainBudget -= 15;
                    tveconomy1.setText(finalInt.toString());

                    redrawView();
                }


            }
        });
        final Button decrease_social_funding = (Button) findViewById(R.id.decrease_social_funding);
        decrease_social_funding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tveconomy1.getText().toString());
                Integer finalInt = input1 - 15;

                if (input1-15 >= 0) {
                    EconomyAdvisorHappiness -= 0.15;
                    SocialAdvisorHappiness += 0.0725;
                    tveconomy1.setText(finalInt.toString());
                    mainBudget += 15;
                    redrawView();
                }
            }
        });
        final Button increase_tax_breaks = (Button) findViewById(R.id.increase_taxbreaks);
        increase_tax_breaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and adds to it
                Integer input1 = Integer.parseInt(tveconomy2.getText().toString());
                Integer finalInt = input1 + 25;

                if (mainBudget-25 >= 0) {
                    EconomyAdvisorHappiness += 0.25;
                    SocialAdvisorHappiness += 0.125;
                    mainBudget -= 25;
                    tveconomy2.setText(finalInt.toString());

                    redrawView();
                }


            }
        });
        final Button decrease_tax_breaks = (Button) findViewById(R.id.decrease_taxbreaks);
        decrease_tax_breaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tveconomy2.getText().toString());
                Integer finalInt = input1 - 25;

                if (input1-25 >= 0) {
                    EconomyAdvisorHappiness -= 0.25;
                    SocialAdvisorHappiness -= 0.125;
                    tveconomy2.setText(finalInt.toString());
                    mainBudget += 25;
                    redrawView();
                }
            }
        });
        final Button pay_economy_bribe = (Button) findViewById(R.id.pay_bribe_economy);
        pay_economy_bribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tveconomy3.getText().toString());
                if (mainBudget-input1 >= 0) {
                    EconomyAdvisorHappiness += 3;
                    PoliticalAdvisorHappiness -= 1;
                    mainBudget -= input1;
                    Integer finalInt = input1 + 250;
                    tveconomy3.setText(finalInt.toString());
                    redrawView();
                }
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////

        /////POLITICAL - ALL/////

////////////////////////////////////////////////////////////////////////////////////////////////////

        final TextView tvpolitical1 = (TextView) findViewById(R.id.lobbyists_val);
        final TextView tvpolitical2 = (TextView) findViewById(R.id.politicial_salary_val);
        final TextView tvpolitical3 = (TextView) findViewById(R.id.pay_bribe_political_price_label);

        final Button clearPolitical = (Button) findViewById(R.id.clear_all_political);
        clearPolitical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Restores mainBudget
                Integer input1 = Integer.parseInt(tvpolitical1.getText().toString());
                Integer input2 = Integer.parseInt(tvpolitical2.getText().toString());
                float input1float = (float) input1;
                float input2float = (float) input2;
                PoliticalAdvisorHappiness -= (input1float/15*(float) 0.15) + (input2float/25*(float) 0.25);
                SocialAdvisorHappiness += (input1float/15*(float) 0.0725) + (input2float/25*(float) 0.125);
                mainBudget += input1 + input2;
                //Erases military textviews
                tvpolitical1.setText("0");
                tvpolitical2.setText("0");
                redrawView();
            }
        });

        final Button increase_lobbyists = (Button) findViewById(R.id.increase_lobbyists);
        increase_lobbyists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and adds to it
                Integer input1 = Integer.parseInt(tvpolitical1.getText().toString());
                Integer finalInt = input1 + 15;

                if (mainBudget-15 >= 0) {
                    PoliticalAdvisorHappiness += .15;
                    SocialAdvisorHappiness -= 0.0725;
                    mainBudget -= 15;
                    tvpolitical1.setText(finalInt.toString());

                    redrawView();
                }


            }
        });
        final Button decrease_lobbyists = (Button) findViewById(R.id.decrease_lobbyists);
        decrease_lobbyists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tvpolitical1.getText().toString());
                Integer finalInt = input1 - 15;

                if (input1-15 >= 0) {
                    PoliticalAdvisorHappiness -= 0.15;
                    SocialAdvisorHappiness += 0.0725;
                    tvpolitical1.setText(finalInt.toString());
                    mainBudget += 15;
                    redrawView();
                }
            }
        });
        final Button increase_politican_salary = (Button) findViewById(R.id.increase_politician_salary);
        increase_politican_salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and adds to it
                Integer input1 = Integer.parseInt(tvpolitical2.getText().toString());
                Integer finalInt = input1 + 25;

                if (mainBudget-25 >= 0) {
                    PoliticalAdvisorHappiness += 0.25;
                    SocialAdvisorHappiness -= 0.125;
                    //SocialAdvisorHappiness -= 0.1;
                    mainBudget -= 25;
                    tvpolitical2.setText(finalInt.toString());
                    redrawView();
                }


            }
        });
        final Button decrease_politican_salary = (Button) findViewById(R.id.decrease_politician_salary);
        decrease_politican_salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tvpolitical2.getText().toString());
                Integer finalInt = input1 - 25;

                if (input1-25 >= 0) {
                    PoliticalAdvisorHappiness -= 0.25;
                    SocialAdvisorHappiness += 0.125;
                    //SocialAdvisorHappiness += 0.1;
                    tvpolitical2.setText(finalInt.toString());
                    mainBudget += 25;
                    redrawView();
                }
            }
        });
        final Button pay_political_bribe = (Button) findViewById(R.id.pay_bribe_political);
        pay_political_bribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tvpolitical3.getText().toString());
                if (mainBudget-input1 >= 0) {
                    PoliticalAdvisorHappiness += 3;
                    EconomyAdvisorHappiness -= 1;
                    mainBudget -= input1;
                    Integer finalInt = input1 + 250;
                    tvpolitical3.setText(finalInt.toString());
                    redrawView();
                }
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////

        /////SOCIAL - ALL/////

////////////////////////////////////////////////////////////////////////////////////////////////////

        final TextView tvsocial1 = (TextView) findViewById(R.id.welfare_val);
        final TextView tvsocial2 = (TextView) findViewById(R.id.education_val);

        final Button clearSocial = (Button) findViewById(R.id.clear_all_social);
        clearSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Restores mainBudget
                Integer input1 = Integer.parseInt(tvsocial1.getText().toString());
                Integer input2 = Integer.parseInt(tvsocial2.getText().toString());
                float input1float = (float) input1;
                float input2float = (float) input2;
                SocialAdvisorHappiness -= (input1float/15*(float) 0.15) + (input2float/25*(float) 0.25);
                PoliticalAdvisorHappiness += (input1float/15*(float) 0.0725) + (input2float/25*(float) 0.125);
                EconomyAdvisorHappiness += (input1float/15*(float) 0.0725) + (input2float/25*(float) 0.125);
                MilitaryAdvisorHappiness +=  (input2float/25*(float) 0.125);
                mainBudget += input1 + input2;

                tvsocial1.setText("0");
                tvsocial2.setText("0");
                redrawView();
            }
        });

        final Button increase_welfare = (Button) findViewById(R.id.increase_welfare);
        increase_welfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and adds to it
                Integer input1 = Integer.parseInt(tvsocial1.getText().toString());
                Integer finalInt = input1 + 15;

                if (mainBudget-15 >= 0) {
                    SocialAdvisorHappiness += .15;
                    PoliticalAdvisorHappiness -= 0.0725;
                    EconomyAdvisorHappiness -= 0.0725;
                    mainBudget -= 15;
                    tvsocial1.setText(finalInt.toString());

                    redrawView();
                }


            }
        });
        final Button decrease_welfare = (Button) findViewById(R.id.decrease_welfare);
        decrease_welfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tvsocial1.getText().toString());
                Integer finalInt = input1 - 15;

                if (input1-15 >= 0) {
                    SocialAdvisorHappiness -= 0.15;
                    PoliticalAdvisorHappiness += 0.0725;
                    EconomyAdvisorHappiness += 0.0725;
                    tvsocial1.setText(finalInt.toString());
                    mainBudget += 15;
                    redrawView();
                }
            }
        });
        final Button increase_education = (Button) findViewById(R.id.increase_education);
        increase_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and adds to it
                Integer input1 = Integer.parseInt(tvsocial2.getText().toString());
                Integer finalInt = input1 + 25;

                if (mainBudget-25 >= 0) {
                    SocialAdvisorHappiness += 0.25;
                    PoliticalAdvisorHappiness -= 0.125;
                    EconomyAdvisorHappiness -= 0.125;
                    MilitaryAdvisorHappiness -= 0.125;
                    mainBudget -= 25;
                    tvsocial2.setText(finalInt.toString());
                    redrawView();
                }


            }
        });
        final Button decrease_education = (Button) findViewById(R.id.decrease_education);
        decrease_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tvsocial2.getText().toString());
                Integer finalInt = input1 - 25;

                if (input1-25 >= 0) {
                    SocialAdvisorHappiness -= 0.25;
                    PoliticalAdvisorHappiness += 0.125;
                    EconomyAdvisorHappiness += 0.125;
                    MilitaryAdvisorHappiness += 0.125;
                    tvsocial2.setText(finalInt.toString());
                    mainBudget += 25;
                    redrawView();
                }
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////

        /////PERSONAL - ALL/////

////////////////////////////////////////////////////////////////////////////////////////////////////

        final TextView tvpersonal1 = (TextView) findViewById(R.id.personal_salary_val);

        final Button increase_personal = (Button) findViewById(R.id.increase_personal_salary);
        increase_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and adds to it
                Integer input1 = Integer.parseInt(tvpersonal1.getText().toString());
                Integer finalInt = input1 + 300;

                if (mainBudget-300 >= 0) {
                    mainBudget -= 300;
                    mainPersonalFunds += 300;
                    tvpersonal1.setText(finalInt.toString());
                    redrawView();
                }


            }
        });
        final Button decrease_personal = (Button) findViewById(R.id.decrease_personal_salary);
        decrease_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes values from textview and substracts from it
                Integer input1 = Integer.parseInt(tvpersonal1.getText().toString());
                Integer finalInt = input1 - 300;

                if (input1-300 >= 0) {
                    tvpersonal1.setText(finalInt.toString());
                    mainPersonalFunds -= 300;
                    mainBudget += 300;
                    redrawView();
                }
            }
        });

    }
}


//Have a variable keep track of how happy each advisor is:
//Economy, Political, Military, Cultural. Each advisor takes a different amount of time to
//have their faction become happy again.

//Overall goal is for leader to make 100000$ before they are killed/deposed

//Define a function that takes an integer and returns a string in format 10000 = "10k"

//Add exclamation points to show which categories are suffering