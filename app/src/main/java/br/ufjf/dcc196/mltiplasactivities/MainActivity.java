package br.ufjf.dcc196.mltiplasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextValue;
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

}