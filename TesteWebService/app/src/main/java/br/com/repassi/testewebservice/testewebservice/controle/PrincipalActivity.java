package br.com.repassi.testewebservice.testewebservice.controle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.com.repassi.testewebservice.testewebservice.R;

import static br.com.repassi.testewebservice.testewebservice.R.id.edtEmail;
import static br.com.repassi.testewebservice.testewebservice.R.id.edtSenha;
import static br.com.repassi.testewebservice.testewebservice.R.id.txtEmail;
import static br.com.repassi.testewebservice.testewebservice.R.id.txtPrincipalEmail;
import static br.com.repassi.testewebservice.testewebservice.R.id.txtPrincipalNome;

public class PrincipalActivity extends AppCompatActivity {

    TextView txtNome;
    TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtNome = (TextView) findViewById(R.id.txtPrincipalNome);
        txtEmail = (TextView) findViewById(R.id.txtPrincipalEmail);

        Intent it = getIntent();

        String nome = it.getStringExtra("nome");
        txtNome.setText(nome);

        String email = it.getStringExtra("email");
        txtEmail.setText(email);



    }
}
