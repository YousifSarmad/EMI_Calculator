package com.example.emiassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Define Button variable so we can use it later on
    private Button Calculate;
    //Define EditText variable so we can use it later on
    private EditText LoanAmount, InterestRate, Tenure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign the values inputed by the user
        LoanAmount = findViewById(R.id.LoanAmount);
        InterestRate = findViewById(R.id.InterestRate);
        Tenure = findViewById(R.id.Tenure);

        // Set the Calculate Button up
        Calculate = findViewById(R.id.Calculate);
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is pressed call the function
                calculateNumbers();
            }
        });
    }

    // Create the Function
    public void calculateNumbers(){
        // Defines the variables to use in the calculations
        double LoanAmount2 = Double.parseDouble(LoanAmount.getText().toString());
        double InterestRate2 = Double.parseDouble(InterestRate.getText().toString());
        double Tenure2 = Double.parseDouble(Tenure.getText().toString());

        // Figure out the Monthly rate, EMI number, Total Interest and payment fourmulas
        double monthlyRate = (InterestRate2/12) / 100;
        double EMINum = (LoanAmount2 * monthlyRate) / (1 - Math.pow(1 + monthlyRate, - Tenure2));
        double TotalInterest = (EMINum * Tenure2) - LoanAmount2;
        double TotalPayment = EMINum * Tenure2;

        // Make the Intents to send over the information for the finial results
        // And make the button switch pages when clicked on
        Intent intent = new Intent(MainActivity.this, SecondPage.class);
        intent.putExtra("EMI_RESULT" , EMINum);
        intent.putExtra("Tenure_FINAL", Tenure2);
        intent.putExtra("TotalInterest_FINIAL" , TotalInterest);
        intent.putExtra("TotalPayment_FINIAL" , TotalPayment);
        startActivity(intent);


    }
}