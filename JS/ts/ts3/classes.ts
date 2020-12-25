class Ev{
    odaSayisi:number;
    pencereSayisi:number;
    kat:number;

    //constructor
    constructor(odaSayisi:number,pencereSayisi:number,kat:number){
        this.odaSayisi = odaSayisi;
        this.pencereSayisi = pencereSayisi;
        this.kat = kat;   
    }

    yemekYe(){
        console.log(this.kat + " katlı evde yemek yendi")
    }
}

let ev = new Ev(3,4,5)

console.log(ev.pencereSayisi)

ev.yemekYe()

class Kisi{
    kaydet(){
        console.log("kişi kaydedildi.");
    }
}

class Musteri extends Kisi{
    satisYap(){
        console.log("Satış yapıldı");
    }
}

class Personel extends Kisi{
    maasOde(){
        console.log("Maaş ödendi")
    }
}

let musteri = new Musteri();

musteri.kaydet();
musteri.satisYap();

let personel = new Personel();

personel.kaydet();
personel.maasOde();