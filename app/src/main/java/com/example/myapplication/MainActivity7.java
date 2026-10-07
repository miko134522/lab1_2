package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText wysokosc = findViewById(R.id.editTextText4);
        EditText waga = findViewById(R.id.editTextText5);
        Button button1 = findViewById(R.id.button6);
        RadioButton kobieta =findViewById(R.id.radioButton);
        RadioButton menszczyzna =findViewById(R.id.radioButton2);
        TextView bmi = findViewById(R.id.textView3);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String wysokosc1 = wysokosc.getText().toString().trim();
                String waga1 = waga.getText().toString().trim();


                if (wysokosc1.isEmpty() || waga1.isEmpty()) {
                    Toast.makeText(MainActivity7.this, "Podaj wagę oraz wysokość!", Toast.LENGTH_SHORT).show();
                    if (wysokosc1.isEmpty()) wysokosc.setError("podaj wzrost");
                    if (waga1.isEmpty()) waga.setError("podaj wage");
                } else {
                    double cm = Double.parseDouble(wysokosc1);
                    double kg = Double.parseDouble(waga1);
                    double metry = cm / 100.0;
                    double wynikBmi = kg / (metry * metry);
                    String sformatowanyWynik = String.format("%.1f", wynikBmi);
                    String opisWyniku = "";
                    if (wynikBmi < 18.5) {
                        opisWyniku = "Niedowaga";
                    } else if (wynikBmi >= 18.5 && wynikBmi <= 24.9) {
                        opisWyniku = "Waga prawidłowa";
                    } else if (wynikBmi >= 25.0 && wynikBmi <= 29.9) {
                        opisWyniku = "Nadwaga";
                    } else {
                        opisWyniku = "Otyłość";
                    }
                    bmi.setText("Twoje BMI to: " + sformatowanyWynik + " (" + opisWyniku + ")");
                }

            }
        });


    }
}