package com.example.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImcActivity extends AppCompatActivity {
    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imcactivity);

        // Configuração do EdgeToEdge (opcional, para bordas do sistema)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa os elementos da interface
        textResultado = findViewById(R.id.textResultado);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
    }

    public void calcularImc(View view) {
        try {
            // Obtém os valores inseridos pelo usuário
            double peso = Double.parseDouble(editPeso.getText().toString());
            double altura = Double.parseDouble(editAltura.getText().toString());

            // Verifica se a altura é válida
            if (altura <= 0) {
                textResultado.setText("Altura deve ser maior que zero.");
                return;
            }

            // Calcula o IMC
            double resultado = peso / (altura * altura);

            // Classificação do IMC
            String classificacao;
            if (resultado < 18.5) {
                classificacao = "Abaixo do peso";
            } else if (resultado < 25.0) {
                classificacao = "Peso normal";
            } else if (resultado < 30.0) {
                classificacao = "Sobrepeso";
            } else {
                classificacao = "Obesidade";
            }

            // Exibe o resultado e a classificação
            textResultado.setText(String.format("IMC: %.2f - %s", resultado, classificacao));
        } catch (NumberFormatException e) {
            textResultado.setText("Por favor, insira valores válidos.");
        }
    }
}
