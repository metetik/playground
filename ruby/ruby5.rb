#while döngüleri
i = 0
while i <= 10
    puts i.to_s
    i+=1
end

puts "\n\n"
alf = ["a","b","c","d","e"]

alf.each do |harf|
    puts harf
end

puts "\n"
array = [1,2,3,4,5,6,7,8,9]
for j in array
    puts j
end

puts "\n"
for k in 1..9
    puts k
end

puts "\n"
4.times do |sayi|
    puts sayi
end
