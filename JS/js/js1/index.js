var kullanicilar = [
    {email:"met1@gmail.com",sifre:"12345"},
    {email:"met2@gmail.com",sifre:"12345"}
]

var tweetler = [
    {email:"met1@gmail.com",tweet:"selam herkese"},
    {email:"met1@gmail.com",tweet:"selam naber"},
    {email:"met2@gmail.com",tweet:"selam herkese,bugün hava çok güzel"}
]

var email  = prompt("email : ")

var sifre = prompt("sifre : ")

function giris(){
    if((email == kullanicilar[0].email && sifre == kullanicilar[0].sifre)||
    (email == kullanicilar[1].email && sifre == kullanicilar[1].sifre)){
        console.log(tweetler)
    }
    else{
        console.log("giriş başarısız")
    }
}

giris()