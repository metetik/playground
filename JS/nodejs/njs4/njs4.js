//file stream

//read file
var fs = require("fs")

fs.readFile("dosya.txt",function(hata,data) {
    if(hata)
        throw hata;
    
    console.log(data.toString())
})

//write file
fs.writeFile("dosya2.txt","asfasfas\nasgasgasg\nasgagsga",function (hata) {
    if(hata)
        throw hata;
    console.log("Yazıldı")
})

//append file
fs.appendFile("dosya2.txt","asfasfas\naşklkl",function (hata) {
    if(hata)
        throw hata;
    console.log("Eklendi")
})

//delete file
fs.unlink,("dosya2.txt",function (hata) {
    if(hata)
        throw hata;
    console.log("Silindi")
})
