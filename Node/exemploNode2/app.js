var express = require('express');
var bodyParser = require('body-parser');
var consign = require('consign');
var expressValidator = require('express-validator');

var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(expressValidator());

consign()
  .include('config/poolDeConexoes.js')
  .then('principal/controllers')
  .then('principal/routes')
  .then('principal/repositories')
  .into(app);

app.listen(3000, function(){
    console.log("Projeto WebServices executando");
});