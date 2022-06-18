package br.ufjf.dcc196.mltiplasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CompostosActivity extends AppCompatActivity {

    private Double valorPresente;
    private Double valorFinal;
    private Double valorFinalRelacao;
    private TextView textViewValorPresente;
    private EditText editTextTaxaDeJuros;
    private EditText editTextPeriodos;
    private TextView textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compostos);
        textViewValorPresente = findViewById(R.id.textViewValorPresenteComposto);
        Bundle extras = getIntent().getExtras();
        valorPresente = extras.getDouble("value");
        textViewValorPresente.setText("Valor : $" +valorPresente.toString());

        editTextTaxaDeJuros = findViewById(R.id.editTaxaJurosComposto);
        editTextPeriodos = findViewById(R.id.editPeriodoComposto);
        textViewResultado = findViewById(R.id.textViewResultadoComposto);
    }


    public void retornarClick(View view){
        Intent resultado = new Intent();
        resultado.putExtra("resultado", valorFinal);
        resultado.putExtra("relacao", valorFinalRelacao);
        setResult(MainActivity.RESULT_COMPOSTO, resultado);
        finish();
    }


    public void calcularClick(View view ){
        Double taxaDeJuros;
        Integer periodos;
        taxaDeJuros = Double.parseDouble(editTextTaxaDeJuros.getText().toString())/100.0;
        periodos = Integer.parseInt(editTextPeriodos.getText().toString());
        valorFinal = valorPresente*Math.pow(1+taxaDeJuros,periodos);
        textViewResultado.setText("Resultado: $" +valorFinal.toString());
        valorFinalRelacao =  100.0 * valorFinal/valorPresente;
        System.out.println(valorFinal);
        System.out.println(valorPresente);
    }
}