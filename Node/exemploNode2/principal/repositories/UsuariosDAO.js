var crypto = require("crypto");

function UsuariosDAO(app) {

    this._app = app;
}

UsuariosDAO.prototype.login = function(email, senha, callback) {

    var poolDeConexoes = this._app.config.poolDeConexoes;

    var senha_criptografada = crypto.createHash("md5").update(senha).digest("hex");
    
    poolDeConexoes.query('SELECT U.NOME nome, U.EMAIL email FROM TB_USUARIO U WHERE U.EMAIL = $1 AND U.SENHA = $2', 
                         [email, senha_criptografada], callback);
}

module.exports = function() {
    return UsuariosDAO;
}