var express = require('express');
var bodyParser = require('body-parser');
var consign = require('consign');

var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

consign()
  .include('principal/controllers')
  .then('principal/routes')
  .then('principal/repositories')
  .into(app);

app.listen(3000, function(){
    console.log("Projeto WebServices executando");
});