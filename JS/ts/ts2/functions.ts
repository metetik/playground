function topla(x,y){
    return x+y;
}

function topla2(x:number,y:number):number{
    return x+y;
}

let topla3 = function(x:number,y:number):number{
    return x+y;
}

console.log(topla(2,3))
console.log(topla("aaaa",22))
console.log(topla2(2,4))
console.log(topla3(4,8))

//default parametre
function topla4(x:number,y:number=4):number{
    return x+y;
}

console.log(topla4(3,8))
console.log(topla4(3))

//optional parametre
function topla5(x:number,y?:number):number{
    if(y){
        return x+y;
    }
    else{
        return x
    }
}

console.log(topla5(3,8))
console.log(topla5(3))

function davetEt(ilkDavetli:string,...digerleri:string[]):string{
    return ilkDavetli + digerleri.join(" ");
}

console.log(davetEt("Muhammed ","ahmet","furkan","ramazan","bayram"))