//request url
var http = require("http")

http.createServer(function (request,response) {
    if(request.url == "/admin")
        response.write("Admin Sayfası")
    else
        response.write("Admin Sayfası Değil")
    response.end()
}).listen(8080)