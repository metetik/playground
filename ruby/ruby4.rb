print "Bir sayi giriniz(0-3) : "

#.chomp : sondaki \n'i almıyor
a = gets.chomp()

if a == "0"
    puts "sıfır"
elsif a == "1"
    puts "bir"
elsif a == "2"
    puts "iki"
elsif a == "3"
    puts "üç"
else
    puts "hata"
end

#case-option ~ switch-case
case a.to_i

when 0
    puts "sıfır"
when 1
    puts "bir"
when 2
    puts "iki"
when 3
    puts "üç"
else
    puts "hata"
end