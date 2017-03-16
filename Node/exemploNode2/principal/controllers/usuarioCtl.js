module.exports.login = function(app, req, res) {

    var email = req.body.email;
    var senha = req.body.senha;

    req.assert('email', 'E-mail é obrigatório').notEmpty();
    req.assert('email', 'E-mail inválido').isEmail();
    req.assert('senha', 'Senha é obrigatória').notEmpty();
    req.assert('senha', 'Senha deve ter entre 6 e 8 caracteres').len(6,8);

    var erros = req.validationErrors();

    if (erros) {
        var validacao = {"erros" : erros};
        console.log(validacao);
        res.send(validacao);
        return;
    }

    var usuariosModel = new app.principal.repositories.UsuariosDAO(app);
    usuariosModel.login(email, senha, function(err, result) {
            res.send({ nome : result.rows[0].nome, email : result.rows[0].email });
    });

}