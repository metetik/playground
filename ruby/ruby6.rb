#dosya işlemleri
file = File.open("ogrenciler.txt","r")
puts file.read()
file.close()

puts("\n")
file1 = File.open("ogrenciler.txt","r")
puts file1.read(10)
file1.close()

puts("\n")
file2 = File.open("ogrenciler.txt","r")

puts file2.readchar()
puts file2.readchar()
puts file2.readchar()
puts file2.readchar()

file2.close()

puts("\n")
file3 = File.open("ogrenciler.txt","r")

puts file3.readline()
puts file3.readline()

file3.close()

#with open
puts "\n\n"
File.open("ogrenciler.txt","r") do |file|
    for satir in file.readlines()
        puts satir
    end
end

#with open
puts "\n\n"
File.open("ogrenciler.txt","a") do |file|
    file.write("kamil,gazi\n")
end