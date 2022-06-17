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
    private TextView textViewResultado;
    public static final int RESULT_SIMPLES = 1;
    public static final int RESULT_COMPOSTO = 2;
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResultado = findViewById(R.id.textResultado);
        Button btnSimples = findViewById(R.id.buttonSimples);
        Button btnComposto = findViewById(R.id.buttonCompostos);
        editTextValue = findViewById(R.id.editValor);
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    @Override
                    public void onActivityResult(ActivityResult result){
                        Bundle extras;
                        Double resultadoFinal;
                        switch (result.getResultCode()){
                            case RESULT_SIMPLES:
                                extras = result.getData().getExtras();
                                resultadoFinal = extras.getDouble("juros");
                                textViewResultado.setText("Simples: " + resultadoFinal.toString());
                                break;
                            case RESULT_COMPOSTO:
                                extras = result.getData().getExtras();
                                resultadoFinal = extras.getDouble("juros");
                                textViewResultado.setText("Compostos: " + resultadoFinal.toString());
                                break;
                        }
                    }
                }
        );

        btnSimples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SimplesActivity.class);
                intent.putExtra("value",Integer.parseInt(editTextValue.getText().toString()));
                startActivity(intent);
            }
        });

        btnComposto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CompostosActivity.class);
                intent.putExtra("value",Integer.parseInt(editTextValue.getText().toString()));
                startActivity(intent);
            }
        });
    }


}