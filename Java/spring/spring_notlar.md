# Spring notlarım
* Kurulumlar : JDK, Apache Tomcat, Eclipse for EE, Spring jar files
### Başlangıç
* Servers kısmından tomcat'i eclipse'e bağla
* Eclipse projesi oluştur
* Eclipse => Window>Perspective>Open Perspective>Java
* Spring jar dosyalarını eclipse'e ekle
* Eclipse => java_project>new folder ==> "lib"
* lib'in içine tüm jar'aları kopyala
* Eclipse => java_project>properties>java build path>libraries>add jars>tüm jar dosyalarını seç>apply and close

### Dependency Injection ve IoC
* Bir class başka bir classı kullandığında onu new'lememelidir.
* Alternatif işlemler için farklı class'lar oluşturulmalı ve bu class'lar bir ortak interface'i implement etmelidir.
* Mesela bir spor yönetim sistemi içinde bir tane BaseballCoach sınıfı yerine, bir tane Coach interface'i ve onu implement eden bir BaseballCoach class'ı olmalıdır. Ki daha sonra başka basketbol için BasketballCoach class'ı yazıldığında Coach interface'ini implement etsin.
* Spring container : Bir IoC container.Spring object factory ile object üretir. IoC ve Dependency Injection sağlar.
* [Engin Demiroğ Dependency Injection](https://www.youtube.com/watch?v=YqDLfjE-mes)

### Spring development process
1. Configure your spring beans
2. Create a spring container(ApplicationContext)
3. Retrieve beans from Spring Container

* What is a Spring Bean? <br>
A "Spring Bean" is simply a Java object. When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans".Spring Beans are created from normal Java classes .... just like Java objects.

### Java OOP
* initialize a class : class'ı new'lemek.
* primitive type'lar(int,double,boolean vs.) value type'dır.
* Class'lar reference type'dır.
* Bir class'ın reference'ı kalmassa o class'ı garbage collector bellekten siler.
* Sadece ihtiyaç duyulduğunda new'lemek gerekir.
* Value type'da değişkenler stack'de tutulur, reference type'da reference'lar stack'de value'lar heap'de tutulur.
* Array'ler reference type'dır.
* Single-Responsibility Principle : Bir class sadece bir görevden sorumlu olmalıdır. Mesela product özellikleri bir class'da product operation'ları başka bir class'da tutulmalıdır.
* public bir class'ın tüm attribute'ları default olarak public'dir.
* private bir attribute sadece tanımlandığı blok'ta geçerlidir.
* this = bu class
* bir class sadece bir kere extend edebilir. Ancak birden çok kez inherit edebilir.
* parent class, child class'ların referansını tutabilir.
* bir method'un override edilmesini istemiyorsak final anahtar kelimesi kullanılır.