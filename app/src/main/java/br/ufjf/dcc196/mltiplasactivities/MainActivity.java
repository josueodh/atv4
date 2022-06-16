package br.ufjf.dcc196.mltiplasactivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextValue;
    public static final int RESULT_SIMPLES = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSimples = findViewById(R.id.buttonSimples);
        editTextValue = findViewById(R.id.editValor);
        btnSimples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SimplesActivity.class);
                intent.putExtra("value",Integer.parseInt(editTextValue.getText().toString()));
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Integer juros = Integer.getInteger(extras.getString("juros"));
            System.out.println(juros);
        }
    }

}