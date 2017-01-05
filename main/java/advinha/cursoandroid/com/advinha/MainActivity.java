package advinha.cursoandroid.com.advinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText jogador1;
    private EditText jogador2;
    private Button botaoJogar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogador1 = (EditText) findViewById(R.id.numJogador1Id); // Associa as váriasveis aos seus respectivos IDs.
        jogador2 = (EditText) findViewById(R.id.numJogador2Id);
        botaoJogar = (Button) findViewById(R.id.botaoJogarId);
        resultado = (TextView) findViewById(R.id.resultadoId);

        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numJogador1;
                String numJogador2;

                numJogador1 = jogador1.getText().toString();
                numJogador2 = jogador2.getText().toString();

                if (numJogador1.isEmpty() && numJogador2.isEmpty()){ //Testa se os campos foram preenchidos e caso estejam vazios apresenta uma mensagem de erro.

                    jogador1.setError("Campo obrigatorio.");
                    jogador2.setError("Campo obrigatorio.");

                } else if (numJogador1.isEmpty()){

                    jogador1.setError("Campo obrigatorio.");

                } else if (numJogador2.isEmpty()) {

                    jogador2.setError("Campo obrigatorio.");

                } else {

                    Double numJogador11 = Double.parseDouble(jogador1.getText().toString()); //Cria uma váriavel do tipo Double, converte e armazena os dados informados.
                    Double numJogador22 = Double.parseDouble(jogador2.getText().toString());

                    if (numJogador11 < 0 || numJogador11 > 10) { // Testa se o número informado no primeiro campo é válido.

                        resultado.setText("Jogador 1, valor inválido."); // Apresenta uma mensagem de erro informando caso o valor informado seja invalido.

                    } else if (numJogador22 < 0 || numJogador22 > 10) { // Testa se o número informado no segundo campo é válido.

                        resultado.setText("Jogador 2, valor inválido."); // Apresenta uma mensagem de erro informando caso o valor informado seja invalido.

                    } else {

                        Random numAleatorio = new Random(); // Cria e inicia a váriavel numAleatorio.
                        int numGerado = numAleatorio.nextInt(10); // Cria a váriavel numGerado e atribui a ela um valor aleatorio entre 0 e 10;

                        // Apresenta as informações preenchidas pelo usuario e o número gerado randomicamente.
                        resultado.setText("O jogador 1 escolheu: " + numJogador1 + "\n" + "O jogador 2 escolheu: " + numJogador2 + "\n" + "O número aleatorio é: " + numGerado);
                    }
                }
            }
        });

    }
}
