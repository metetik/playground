//Class
class Personel{
    constructor(ad,soyad){
        this.ad = ad;
        this.soyad = soyad;
    }
    kaydet(){
        console.log("Personel kaydedildi")
    }
}

var personel = new Personel("muhammed","tetik")

console.log(personel.ad+" "+personel.soyad)
personel.kaydet()