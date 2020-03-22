# Ruby on Rails Notlar

* Erb(Embedded Ruby) : HTML dosyasına ruby kodlarını gömmeye yarar.
    Erb kullanmak için HTML dökümanında ruby kodları "<% %>" işaretleri içine yerleştirilir.
    Eğer kodun çıktısı isteniyorsa "<%= %>" kullanılır.
## Rails'in güçlü yönleri
* Metaprogramming : programın çalıştığı sürece kendi kodlarını yazmaya devam etmesi. Ruby metaprogramming için en iyi dillerden birisi.

* Active Record : Veritabanını aktif olarak gümncel tutmak.

* Convention over Configuration : Bi çok web framework sayfalarca configuration kodu yazmaya zorlar. Ama Rails'de naming conventions'a dikkat edilirse buna gerek kalmaz.

* Scaffolding : Hızlıcar geçici kod iskelesi kurmaya yarar.

* Built-in testing
* Three environments : development, testing, production

## Rails proje oluşturma ve çalıştırma

proje oluşturma
>rails new proje_adi

serveri çalıştırma(RoR WEBrick server kullanıyor)
>cd proje_adi
>rails server

herhangi bir hatayla karşılaşmadıysak server localhost:3000'de çalışıyor.
