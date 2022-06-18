package br.ufjf.dcc196.mltiplasactivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextValue;
    private TextView textViewValorFinal;
    public static final int RESULT_SIMPLES = 1;
    public static final int RESULT_COMPOSTO = 2;
    public static final int RESULT_RELACAO = 3;
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewValorFinal = findViewById(R.id.textResultado);
        editTextValue = findViewById(R.id.editValor);
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){

                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Double valorFinal;
                        Bundle extras;
                        switch (result.getResultCode()){
                            case RESULT_SIMPLES:
                                extras = result.getData().getExtras();
                                valorFinal = extras.getDouble("resultado");
                                textViewValorFinal.setText("Simples: R$"+valorFinal.toString());
                                break;
                            case RESULT_COMPOSTO:
                                extras = result.getData().getExtras();
                                valorFinal = extras.getDouble("resultado");
                                textViewValorFinal.setText("Compostos: R$"+valorFinal.toString());
                                break;
                        }

                    }
                }
        );
    }

    public void jurosSimplesClick(View view){
        try{
            Double valorPresente = Double.parseDouble(editTextValue.getText().toString());
            Intent intent = new Intent(MainActivity.this, SimplesActivity.class);
            intent.putExtra("value", valorPresente);
            launcher.launch(intent);
        }catch (Exception e){
            System.out.println(e);
            editTextValue.selectAll();
            editTextValue.requestFocus();
        }
    }

    public void jurosCompostoClick(View view){
        try{
            Double valorPresente = Double.parseDouble(editTextValue.getText().toString());
            Intent intent = new Intent(MainActivity.this, CompostosActivity.class);
            intent.putExtra("value", valorPresente);
            launcher.launch(intent);
        }catch (Exception e){
            System.out.println(e);
            editTextValue.selectAll();
            editTextValue.requestFocus();
        }
    }

}