package br.ufjf.dcc196.mltiplasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RelacaoActivity extends AppCompatActivity {
    private Double valorPresente;
    private Double valorFinal;
    private TextView textViewValorPresente;
    private EditText editTextValorFuturo;
    private TextView textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacao);
        textViewValorPresente = findViewById(R.id.textViewValorPresenteRelacao);
        Bundle extras = getIntent().getExtras();
        valorPresente = extras.getDouble("value");
        textViewValorPresente.setText(valorPresente.toString());

        editTextValorFuturo = findViewById(R.id.editTextValorFuturo);
        textViewResultado = findViewById(R.id.textViewResultadoRelacao);
    }

    public void retornarClick(View view){
        Intent resultado = new Intent();
        resultado.putExtra("relacao", valorFinal);
        setResult(MainActivity.RESULT_RELACAO, resultado);
        finish();
    }

    public void calcularClick(View view ){
        Double valorFuturo;
        valorFuturo = Double.parseDouble(editTextValorFuturo.getText().toString());
        valorFinal = 100.0 * valorFuturo/valorPresente;
        textViewResultado.setText(valorFinal.toString() + "%");
    }
}