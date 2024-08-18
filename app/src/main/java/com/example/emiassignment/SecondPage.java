package com.example.emiassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class SecondPage extends AppCompatActivity {
    //Define Button variable so we can use it later on
    private Button StartOver;
    //Define TextView variable so we can use it later on
    private TextView EMINumber, TenureNumber, TotalInterest, TotalPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        // Set the textviews up with the IDs
        EMINumber = findViewById(R.id.EMINumber);
        TenureNumber = findViewById(R.id.TenureNumber);
        TotalInterest = findViewById(R.id.TotalInterest);
        TotalPayment = findViewById(R.id.TotalPayment);

        // Create the intent and get the information being passed
        Intent intent = getIntent();
        double EMIFINIAL = intent.getDoubleExtra("EMI_RESULT",0.0);
        double TenureFINIAL = intent.getDoubleExtra("Tenure_FINAL", 0 );
        double InterstFinal = intent.getDoubleExtra("TotalInterest_FINIAL" , 0.0);
        double PaymentFinal = intent.getDoubleExtra("TotalPayment_FINIAL", 0.0);

        // Making the numbers rounded
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String EMIRounded = decimalFormat.format(EMIFINIAL);
        String interestRounded = decimalFormat.format(InterstFinal);
        String PaymentRounded = decimalFormat.format(PaymentFinal);

        // Displaying the output numbers
        EMINumber.setText("Your EMI is: $ " + EMIRounded);
        TenureNumber.setText("Your Tenure is: " + TenureFINIAL);
        TotalInterest.setText("Your Finial Interest is: " + interestRounded);
        TotalPayment.setText("Your Finial Payment is: " + PaymentRounded);

        // Creating the OnClick Button and making it when the user clicks goes back
        // To the main page
        StartOver = findViewById(R.id.StartOver);
        StartOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondPage.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}