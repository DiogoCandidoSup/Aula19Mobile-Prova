package br.ulbra.aula19prova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    EditText edConta,edPessoas,edParcelas,edJuros;
    Button btCalcular,btLimpar;
    TextView txtResultado;
    ImageView imagem;

    private static final DecimalFormat dfTwo = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        IniciarComponetes();

        btLimpar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Limpar();
            }
        });

        btCalcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(edConta.equals(null) || edParcelas.equals(null) || edPessoas.equals(null) || edJuros.equals(null))
                {
                    Toast.makeText(MainActivity.this, "CAMPO EM BRANCO!!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String resultado;

                    double conta = Double.parseDouble(edConta.getText().toString());
                    int pessoas = Integer.parseInt(edPessoas.getText().toString());
                    int parcelas = Integer.parseInt(edParcelas.getText().toString());

                    double juros = Double.parseDouble(edJuros.getText().toString()) / 100;

                    double racha = conta / pessoas;
                    double total = conta * (juros + 1);
                    double parcela = total / parcelas;

                    resultado = "Valor por cada pessoa: R$" + dfTwo.format(racha) + '\n'
                            + "Valor total (sem juros): R$" + dfTwo.format(conta) + '\n' + '\n'
                            + "Valor de cada parcela: R$" + dfTwo.format(parcela) + '\n'
                            + "Valor total (com juros): R$" + dfTwo.format(total);
                    txtResultado.setText(resultado);
                }
            }
        });

        imagem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
    }

    public void IniciarComponetes()
    {
        edConta = findViewById(R.id.edConta);
        edPessoas = findViewById(R.id.edPessoas);
        edParcelas = findViewById(R.id.edParcelas);
        edJuros = findViewById(R.id.edJuros);

        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);

        txtResultado = findViewById(R.id.txtResultado);

        imagem = findViewById(R.id.imagem);
    }

    public void Limpar()
    {
        edConta.setText("");
        edParcelas.setText("");
        edPessoas.setText("");
        edJuros.setText("");
        txtResultado.setText("RESULTADO");
    }
}