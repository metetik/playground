//Modül
var log = require("./log.js")
var sayHello = require("./log-2.js")
var http = require("http")

http.createServer(function (request,response) {
    response.end("Merhaba")
}).listen(8080)

log.information("bilgi")
log.fault("hata")

sayHello()