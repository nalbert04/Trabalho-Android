package com.example.imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Encontra o botão pelo ID para ir para a tela de IMC
        Button btnIrParaImc = findViewById(R.id.btnIrParaImc);

        // Configura o clique do botão para abrir a ImcActivity
        btnIrParaImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria a intenção para abrir a ImcActivity
                Intent intent = new Intent(MainActivity.this, ImcActivity.class);
                startActivity(intent);
            }
        });

        // Encontra o botão pelo ID para ir para a tela de Ingestão de Água
        Button btnCalcularAgua = findViewById(R.id.button3);

        // Configura o clique do botão para abrir a AguaActivity
        btnCalcularAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria a intenção para abrir a AguaActivity
                Intent intent = new Intent(MainActivity.this, AguaActivity.class);
                startActivity(intent);
            }
        });
    }
}
