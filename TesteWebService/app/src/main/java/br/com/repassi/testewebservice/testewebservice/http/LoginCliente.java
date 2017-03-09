package br.com.repassi.testewebservice.testewebservice.http;

import br.com.repassi.testewebservice.testewebservice.modelo.Usuario;
import br.com.repassi.testewebservice.testewebservice.modelo.UsuarioParameter;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by Regis on 07/03/17.
 */

public interface LoginCliente {

    @POST("/login")
    Call<Usuario> logar(@Body UsuarioParameter usuarioParameter);
}
