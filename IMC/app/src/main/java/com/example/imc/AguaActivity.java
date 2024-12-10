package com.example.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AguaActivity extends AppCompatActivity {

    private EditText editTextPeso;
    private Button buttonCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aguaactivity); // Certifique-se de que o layout XML correto foi usado

        // Inicializa os componentes da telas
        editTextPeso = findViewById(R.id.editTextText4);
        buttonCalcular = findViewById(R.id.button2);
        textViewResultado = findViewById(R.id.textView3);

        // Configura o clique do botão
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIngestaoAgua();
            }
        });
    }

    private void calcularIngestaoAgua() {
        try {
            // Obtém o peso inserido no EditText
            String pesoStr = editTextPeso.getText().toString();

            if (pesoStr.isEmpty()) {
                // Caso o campo de peso esteja vazio, mostra um aviso
                Toast.makeText(AguaActivity.this, "Por favor, insira o peso.", Toast.LENGTH_SHORT).show();
                return;
            }

            double peso = Double.parseDouble(pesoStr); // Converte o peso para double

            // Calcula a ingestão de água (35 ml por kg de peso)
            double aguaRecomendada = peso * 35;

            // Exibe o resultado no TextView
            textViewResultado.setText(String.format("Você deve tomar %.2f ml de água por dia.", aguaRecomendada));

        } catch (NumberFormatException e) {
            // Caso o valor inserido não seja um número válido, mostra um erro
            Toast.makeText(AguaActivity.this, "Por favor, insira um peso válido.", Toast.LENGTH_SHORT).show();
        }
    }
}
