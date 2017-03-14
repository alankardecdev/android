module.exports = function(app) {

    app.get('/login/:valor', function(req, res) {
        
        var valor = req.params.valor;

        console.log("Chegou o valor "+valor);
        res.send("Mandei o valor "+valor);

        res.send("Teste ok");
    });

    app.post('/login', function(req, res) {

        console.log(req.body);

        
        var nome = req.body.nome;
                
        console.log("Chegou o nome "+nome);
        res.send("Mandei o nome "+nome);       
    });
};