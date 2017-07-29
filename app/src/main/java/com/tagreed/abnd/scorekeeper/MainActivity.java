package com.tagreed.abnd.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int TotalScore_A=0;
    int TotalScore_B=0;
    int Click_count = 0;
    EditText Score_A_Input;
    EditText Score_B_Input;
    int Display_Score_A;
    int Display_Score_B;

    TextView View_Total_A;
    TextView View_Total_B;
    TextView View_Winner;

    TextView View_R1TA_Score;
    TextView View_R1TB_Score;

    TextView View_R2TA_Score;
    TextView View_R2TB_score;

    TextView View_R3TA_Score;
    TextView View_R3TB_Score;

    TextView ViewR4TA_Score;
    TextView ViewR4TB_Score;

    TextView View_Teams_Percentage;
    TextView View_TEamA_Percentage;
    TextView View_TeamB_Percentage;

    TextView View_Diffrences;

    LinearLayout Round2_View;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Adding_Score(View Button_Add_Score_Layout)
    {
        Click_count = Click_count +1;
        if (Click_count <=4)
            Get_Team_Score();

        else {
            Calculate_Total_Scores();
        }
    }

    public void Get_Team_Score() {

        String Input_A;
        String Input_B;

        Score_A_Input = (EditText) findViewById(R.id.Team_A_Score_Input);
        Input_A = Score_A_Input.getText().toString();

        Score_B_Input = (EditText) findViewById(R.id.Team_B_Score_Input);
        Input_B = Score_B_Input.getText().toString();

        if (Input_A.matches("")) Display_Score_A = 0;
        else
            Display_Score_A = Integer.parseInt(Score_A_Input.getText().toString());
        if (Input_B.matches("")) Display_Score_B = 0;
        else
            Display_Score_B = Integer.parseInt(Score_B_Input.getText().toString());

        TotalScore_A = TotalScore_A + Display_Score_A;
            TotalScore_B = TotalScore_B + Display_Score_B;

            if (Click_count == 1) {
                //TextView View_R1TA_Score;
                //TextView View_R1TB_Score;

                View_R1TA_Score = (TextView) findViewById(R.id.Round1_TeamA_Score_Dispaly);
                View_R1TA_Score.setText(String.valueOf(Display_Score_A));

                View_R1TB_Score = (TextView) findViewById(R.id.Round1_TeamB_Score_Display);
                View_R1TB_Score.setText(String.valueOf(Display_Score_B));

            }

            if (Click_count == 2) {
                //TextView View_R2TA_Score;
                //TextView View_R2TB_score;

                View_R2TA_Score = (TextView) findViewById(R.id.Round2_TeamA_Score_Dispaly);
                View_R2TA_Score.setText(String.valueOf(Display_Score_A));

                View_R2TB_score = (TextView) findViewById(R.id.Round2_TeamB_Score_Dispaly);
                View_R2TB_score.setText(String.valueOf(Display_Score_B));

            }

            if (Click_count == 3) {
                //TextView View_R3TA_Score;
                //TextView View_R3TB_Score;

                View_R3TA_Score = (TextView) findViewById(R.id.Round3_TeamA_Score_Display);
                View_R3TA_Score.setText(String.valueOf(Display_Score_A));

                View_R3TB_Score = (TextView) findViewById(R.id.Round3_TeamB_Score_Display);
                View_R3TB_Score.setText(String.valueOf(Display_Score_B));
            }

            if (Click_count == 4) {
                //TextView ViewR4TA_Score;
                //TextView ViewR4TB_Score;

                ViewR4TA_Score = (TextView) findViewById(R.id.Round4_TeamA_Score_Display);
                ViewR4TA_Score.setText(String.valueOf(Display_Score_A));

                ViewR4TB_Score = (TextView) findViewById((R.id.Round4_TeamB_Score_Display));
                ViewR4TB_Score.setText(String.valueOf(Display_Score_B));
            }


    }


    public void Calculate_Total_Scores()
    {
        //TextView View_Total_A;
        //TextView View_Total_B;
        //TextView View_Winner;

        View_Total_A = (TextView) findViewById(R.id.TeamA_Total_Dispaly);
        View_Total_A.setText(String.valueOf(TotalScore_A));

        View_Total_B = (TextView) findViewById(R.id.TeamB_Total_Display);
        View_Total_B.setText(String.valueOf(TotalScore_B));

        View_Winner = (TextView) findViewById((R.id.Winner_Display));

        if(TotalScore_A >TotalScore_B)
        {
            View_Winner.setText("Winner Team is Team A");
        }
        else
            if (TotalScore_B>TotalScore_A) {

                View_Winner.setText("Winner Team is Team B");
            }
    }

    public void Reset_Score ( View App_Buttons_Layout)
    {
        TotalScore_A = 0;
        TotalScore_B = 0;
        Click_count = 0;
        Score_A_Input.setText("");
        Score_B_Input.setText("");
        Display_Score_A = 0;
        Display_Score_B = 0;

        View_R1TA_Score.setText("");
        View_R1TB_Score.setText("");
        View_R2TA_Score.setText("");
        View_R2TB_score.setText("");
        View_R3TA_Score.setText("");
        View_R3TB_Score.setText("");
        ViewR4TA_Score.setText("");
        ViewR4TB_Score.setText("");
        View_Total_A.setText("");
        View_Total_B.setText("");
        View_Winner.setText("");

        View_TEamA_Percentage.setText("");
        View_Teams_Percentage.setText("");
        View_TeamB_Percentage.setText("");
        View_Diffrences.setText("");


    }

    public void Calculate_Winner_Percentage (View App_Buttons_Layout)
    {
        int Total_Score =0;

        double TeamA_Percentage;
        double TeamB_Percentage;

        //TextView View_Teams_Percentage;
        //TextView View_TEamA_Percentage;
        //TextView View_TeamB_Percentage;

        Total_Score = TotalScore_A + TotalScore_B ;
        TeamA_Percentage = ((TotalScore_A * 100 ))/ Total_Score;
        TeamB_Percentage = ((TotalScore_B * 100))/ Total_Score;

        View_Teams_Percentage = (TextView) findViewById(R.id.Teams_Percentage);
        View_Teams_Percentage.setText("Percentage:");

        View_TEamA_Percentage = (TextView) findViewById(R.id.TeamA_Percentage);
        View_TEamA_Percentage.setText(Double.toString(TeamA_Percentage)+"%");

        View_TeamB_Percentage = (TextView) findViewById(R.id.TeamB_Percentage);
        View_TeamB_Percentage.setText(Double.toString(TeamB_Percentage)+"%");
    }

    public void Calculate_Diffrence (View App_Buttons_Layout)
    {
        int Diffrence_Value = 0;

        //TextView View_Diffrences;

        if (TotalScore_A > TotalScore_B)
            Diffrence_Value = TotalScore_A - TotalScore_B;
        else if (TotalScore_B > TotalScore_A)
            Diffrence_Value = TotalScore_B - TotalScore_A;

        View_Diffrences = (TextView) findViewById(R.id.Teams_Difference);
        View_Diffrences.setText("The Deffrence Between Team A and B is " + Diffrence_Value + " scores");
    }
}
