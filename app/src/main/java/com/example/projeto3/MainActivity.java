package com.example.projeto3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends DebugActivity {
    private static final String CATEGORIA = "COMP_MOVEL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(onClickLogin());
    }
    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();
                if ("adm".equals(login) && "123".equals(senha)) {
                    // Navega para a próxima tela
                    Intent intent = new Intent(MainActivity.this, BemVindoActivity.class);
                    Bundle params = new Bundle();
                    params.putString("nome", "Marcelo Petri");
                    intent.putExtras(params);
                    startActivity(intent);
                } else {
                    alert("Login e senha incorretos.");
                }
            }
        };
    }
    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}