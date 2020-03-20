#fonksiyonlar
def fonksiyon1
    puts "Merhaba Dünya"
end

fonksiyon1

def toplama(a,b)
    puts "Toplamları : " + (a+b).to_s
end

toplama(2,3)

def merhaba(firstname = "Bilgi Yok",lastname = "Bilgi Yok")
    puts "İsim : " + firstname + "\nSoyisim : " + lastname
end

merhaba("muhammed","tetik")
merhaba
