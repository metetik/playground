#dönüştürme : .to_s .to_i .....

print "birinci sayı : "
firstNumber = gets.to_i #ekrandan oku, integer'a dönüştür

print "ikinci sayı : "
secondNumber = gets.to_i 

puts firstNumber + secondNumber
puts firstNumber.to_s + secondNumber.to_s

print "\n\n"

#string özellikleri
a = "yazilim"

puts "a'nin uzunlugu" + a.length().to_s
puts "z'nin indexi" + a.index("a").to_s
puts "0-3 -> " + a[0,3]

#array
#array'lerde farklı veri tipleri depolanabilir
b = ["aaa",1,true]

#hash
#hash ~ dictionary

sehirler = {
    "Afyon" => 3,
    "Ankara" => 6,
    "İstanbul" => 34
}
puts "\n\n\n"
puts sehirler["Afyon"]