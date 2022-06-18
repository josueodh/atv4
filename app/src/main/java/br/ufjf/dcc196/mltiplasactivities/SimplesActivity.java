package br.ufjf.dcc196.mltiplasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimplesActivity extends AppCompatActivity {
    private Double valorPresente;
    private Double valorFinal;

    private TextView textViewValorPresente;
    private EditText editTextTaxaDeJuros;
    private EditText editTextPeriodos;
    private TextView textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simples);
        textViewValorPresente = findViewById(R.id.textViewValorPresente);
        Bundle extras = getIntent().getExtras();
        valorPresente = extras.getDouble("value");
        textViewValorPresente.setText("Valor : $" +valorPresente.toString());

        editTextTaxaDeJuros = findViewById(R.id.editTaxaJuros);
        editTextPeriodos = findViewById(R.id.editPeriodo);
        textViewResultado = findViewById(R.id.textViewResultadoSimples);
    }


    public void retornarClick(View view){
        Intent resultado = new Intent();
        resultado.putExtra("resultado", valorFinal);
        setResult(MainActivity.RESULT_SIMPLES, resultado);
        finish();
    }


    public void calcularClick(View view ){
        Double taxaDeJuros;
        Integer periodos;
        taxaDeJuros = Double.parseDouble(editTextTaxaDeJuros.getText().toString())/100.0;
        periodos = Integer.parseInt(editTextPeriodos.getText().toString());
        valorFinal = valorPresente*(1+taxaDeJuros*periodos);
        textViewResultado.setText("Resultado: $" +valorFinal.toString());
    }
}