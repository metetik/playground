#hata yakalama

begin 
    a = 5/0
    puts "Naber"
rescue
    puts "Hata"
end

begin
    a = "3"
    b = a+1
rescue TypeError
    puts "tip uyuşmazlığı"
end