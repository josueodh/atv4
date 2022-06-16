package br.ufjf.dcc196.mltiplasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SimplesActivity extends AppCompatActivity {
    Integer value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simples);
        Toast.makeText(getApplicationContext(), "ALo", Toast.LENGTH_LONG).show();
        Bundle bundleExtra = getIntent().getExtras();
        if(bundleExtra!= null){
            value = bundleExtra.getInt("value");
            System.out.println(value);
        }
    }
}