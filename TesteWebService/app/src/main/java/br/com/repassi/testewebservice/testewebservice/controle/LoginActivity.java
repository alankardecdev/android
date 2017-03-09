package br.com.repassi.testewebservice.testewebservice.controle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import br.com.repassi.testewebservice.testewebservice.R;
import br.com.repassi.testewebservice.testewebservice.http.LoginCliente;
import br.com.repassi.testewebservice.testewebservice.modelo.Usuario;
import br.com.repassi.testewebservice.testewebservice.modelo.UsuarioParameter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail;
    EditText edtSenha;
    TextView mTextMensagem;
    ProgressBar mProgressBar;
    Context _this;

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        _this = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

        View view = getLayoutInflater().inflate(R.layout.activity_login, null);
        mTextMensagem = (TextView)view.findViewById(android.R.id.empty);
        mProgressBar = (ProgressBar)view.findViewById(R.id.progressBar);

        Button btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://10.0.3.2:3000")
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.build();
    }

    @Override
    public void onClick(View view) {

        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        UsuarioParameter usuarioParameter = new UsuarioParameter(email, senha);

        LoginCliente loginCliente = retrofit.create(LoginCliente.class);
        Call<Usuario> call = loginCliente.logar(usuarioParameter);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario usuario = response.body();
                Intent intent = new Intent(_this, PrincipalActivity.class);
                intent.putExtra("nome", usuario.getNome());
                intent.putExtra("email", usuario.getEmail());
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Erro :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
