package com.example.lebaquoc_2050531200260_btapthuchanh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lebaquoc_2050531200260_btapthuchanh.R;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    public void myButtonListenerMethod() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText heightText = findViewById(R.id.height);
                String heightStr = heightText.getText().toString();
                double height = Double.parseDouble(heightStr);
                double heightM = height/100;
                final EditText weightText = findViewById(R.id.weight);
                String weightStr = weightText.getText().toString();
                double weight = Double.parseDouble(weightStr);
                double BMI = (weight) / (heightM * heightM);
                DecimalFormat df = new DecimalFormat("#.#");
                double BMI_trimmed = Double.parseDouble(df.format(BMI));
                final TextView BMIResult = findViewById(R.id.result);
                BMIResult.setText(Double.toString(BMI_trimmed));
                String BMI_Cat;
                if (BMI < 18) {
                    BMI_Cat = "Gầy";
                }
                else if (BMI >=18.5 && BMI < 25){
                    BMI_Cat = "Người Bình Thường";
                }
                else if (BMI >= 25 && BMI < 30){
                    BMI_Cat = "Người Béo Phì Độ 1";
                }
                else if (BMI>=30 && BMI < 35 ){
                    BMI_Cat = "Người Béo Phì Độ 2";
                }
                else {
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";

                }
                final TextView BMICategory = findViewById(R.id.bmiCat);
                BMICategory.setText(BMI_Cat);
            }
        });
    }
}
