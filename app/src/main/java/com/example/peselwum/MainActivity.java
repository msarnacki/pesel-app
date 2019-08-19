package com.example.peselwum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void obliczWiek(View view) throws ParseException {

        EditText pesel = findViewById(R.id.editText);
        TextView wiek = findViewById(R.id.textView2);
        Button przycisk = findViewById(R.id.button);

        String inputText = pesel.getText().toString();

        String starzy = "19";
        String mlodzi = "20";

        String pelnadata = new String();

        if( Character.getNumericValue(inputText.charAt(2)) >= 2)
        {
            pelnadata = mlodzi + inputText;

            String pierwsze4 = pelnadata.substring(0,4);
            String piata = pelnadata.substring(4,5);
            String ostatnie = pelnadata.substring(5);

            int piataint = Character.getNumericValue(piata.charAt(0)) - 2;

            pelnadata = pierwsze4 + Integer.toString(piataint) + ostatnie;
        }
        else {
            pelnadata = starzy + inputText;
        }

        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");

        Date date = dt.parse(pelnadata);
        Date dzis = new Date();

        long ile_ms = dzis.getTime() - date.getTime();
        long ile_lat = ile_ms/31556952/1000;

        wiek.setText(String.valueOf(ile_lat));
    }

}
