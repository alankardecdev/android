module.exports = function(app) {

    app.get('/login/:valor', function(req, res) {
        
        var valor = req.params.valor;

        console.log("Chegou o valor "+valor);
        res.send("Mandei o valor "+valor);

        res.send("Teste ok");
    });

    app.post('/login', function(req, res) {

        console.log(req.body);
        
        app.principal.controllers.usuarioCtl.login(app, req, res); 

        
    });
};