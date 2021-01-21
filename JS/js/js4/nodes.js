var baslik = document.createElement("h3")
var node = document.createTextNode("Node Eklendi")
baslik.appendChild(node)

var div1 = document.getElementById("div1")
var p2 = document.getElementById("p2")

document.getElementById("dugme1").addEventListener("click",fonk1)
document.getElementById("dugme2").addEventListener("click",fonk2)

function fonk1() {
    div1.insertBefore(baslik,p2)
}
function fonk2() {
    baslik.remove()
}