package br.ufjf.dcc196.mltiplasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SimplesActivity extends AppCompatActivity {
    Integer value = 0;
    Integer periodo = 0;
    Integer taxa = 0;
    Integer juros = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simples);
        Button btnVoltar = findViewById(R.id.buttonVoltar);
        Bundle bundleExtra = getIntent().getExtras();

        if(bundleExtra!= null){
            value = bundleExtra.getInt("value");
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultado = new Intent();
                resultado.putExtra("juros", juros.toString());
                setResult(MainActivity.RESULT_SIMPLES,resultado);
                finish();
            }
        });
    }

    public void calcularSimples(View origem){
        EditText editTextTaxa = findViewById(R.id.editTaxaJuros);
        EditText editTextPeriodo = findViewById(R.id.editPeriodo);
        try{
            taxa = Integer.parseInt(editTextTaxa.getText().toString());
        }catch(Exception e){
            editTextTaxa.requestFocus();
        }
        try{
            periodo = Integer.parseInt(editTextPeriodo.getText().toString());
        }catch(Exception e){
            editTextPeriodo.requestFocus();
        }

        juros = periodo * taxa * value;
    }
}