package com.example.prova_web_ex5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnIMC, btnConversor, btnVoltar, btnCalcIMC, btnCalcTemp;

    TextView txtPeso, txtAltura, txtGc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarregarTelaPrincipal();
    }

    private void CarregarTelaPrincipal()
    {
        setContentView(R.layout.activity_main);

        btnIMC = findViewById(R.id.btnIMC);
        btnIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaImc();
            }
        });


        btnConversor = findViewById(R.id.btnConversor);
        btnConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaTemp();
            }
        });

    }

    private void CarregarTelaImc()
    {
        setContentView(R.layout.imc);

        btnCalcIMC = findViewById(R.id.btnCalcIMC);
        btnCalcIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtPeso = (TextView) findViewById(R.id.txtPeso);
                txtAltura = (TextView) findViewById(R.id.txtAltura);

                int peso = Integer.parseInt(txtPeso.getText().toString());
                float altura = Float.parseFloat(txtAltura.getText().toString());

                float resultado = peso / (altura * altura);

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Atenção!");
                alert.setMessage("seu imc é: " + resultado);
                alert.setNeutralButton("Fechar",null);
                alert.show();

                peso = 0;
                altura = 0;
                resultado = 0;
            }
        });

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });
    }

    private void CarregarTelaTemp()
    {
        setContentView(R.layout.temp);

        btnCalcTemp = findViewById(R.id.btnCalcTemp);
        btnCalcTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtGc = (TextView) findViewById(R.id.txtGc);

                float c = Float.parseFloat(txtGc.getText().toString());
                double resultado = c * 1.8 + 32;
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Convertendo em Fahrenheit");
                alert.setMessage(c + " °C equivale a " + resultado + " °F");
                alert.setNeutralButton("Fechar",null);
                alert.show();

            }
        });

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });
    }
}