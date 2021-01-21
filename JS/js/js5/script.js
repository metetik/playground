//Eski usul fonksiyon tanımı
function fonk1() {
    console.log("asgas")
}
//Yeni usul fonksiyon tanımı
var fonk2 = () => {
    console.log("asgas")
}
//Tek satır fonksiyon
var fonk3 = () => console.log("asgagaggaeg")

//for each
var dizi1 = [1,3,5,7,9]

dizi1.forEach(element => {
    console.log(element)
});

//Map
var mapDizi = dizi1.map(i => i*i )
console.log(mapDizi)

//Filter
var filtreliDizi = dizi1.filter(i => i>5)
console.log(filtreliDizi)

//string içinde değişken
var ad = "Muhammed"
var mesaj = `Merhaba ${ad}`

console.log(mesaj)