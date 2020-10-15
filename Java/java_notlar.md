# Java notlarım

## Java OOP
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
* abstract class'lar new'lenemez.
* Interface'ler reference tutabilir.
* Bir method'a reference'dan ulaşmak için o method'un static olması gerekir.
* Ana class static olamaz. Ama inner class'lar olabilir.
* abstract method : inherit eden override etmek zorunda.
* final method : inherit eden aynı şekilde kullanmak zorunda, değiştiremez
* Polymorphism : Aralarında inheritance olan classların birbirinin referansını tutması.
* Static constructor oluşturulabilir. 
    > static {  }
* Static method'un içinde static olmayan method çağrılamaz. Çağırmak için obje oluşturmak gerekir.
* [Erişim belirleyiciler](https://ramazanbiyikci.com.tr/java-erisim-belirleyiciler-access-modifiers/)

# Spring
* Servers kısmından tomcat'i eclipse'e bağla
* Eclipse projesi oluştur
* Eclipse => Window>Perspective>Open Perspective>Java
* Spring jar dosyalarını eclipse'e ekle
* Eclipse => java_project>new folder ==> "lib"
* lib'in içine tüm jar'ları kopyala
* Eclipse => java_project>properties>java build path>libraries>add jars>tüm jar dosyalarını seç>apply and close


### Spring Beans <br>
A "Spring Bean" is simply a Java object. When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans".Spring Beans are created from normal Java classes .... just like Java objects.
* Default Bean Id :
    Classname = MyClass => Default Bean Id = myClass

### Dependency Injection ve IoC
* Bir class başka bir classı kullandığında onu new'lememelidir.
* Alternatif işlemler için farklı class'lar oluşturulmalı ve bu class'lar bir ortak interface'i implement etmelidir.
* Mesela bir spor yönetim sistemi içinde bir tane BaseballCoach sınıfı yerine, bir tane Coach interface'i ve onu implement eden bir BaseballCoach class'ı olmalıdır. Ki daha sonra başka basketbol için BasketballCoach class'ı yazıldığında Coach interface'ini implement etsin.
* Spring container : Bir IoC container.Spring object factory ile object üretir. IoC ve Dependency Injection sağlar.
* IoC container : Benim anladığım dependent class'ları üretme aracı.
* _Çıplak class kalmamalı_ : tüm class'lar implementation yapmalıdır.
* [Engin Demiroğ Dependency Injection](https://www.youtube.com/watch?v=YqDLfjE-mes)
* Class Injection Çözümleri : 
    1. Constructor Injection
    2. Setter Injection
* Spring IoC Teknikleri : 
    1. XML File
    2. Java Annotations
    3. Java Source Code
* Autowiring : dependency'lerin bir annotation yardımıyla otomatik inject edilmesi.

    
### Spring Bean Scopes
* singleton : Create a single shared instance of the bean. Default scope.
* prototype : Creates a new bean instance for each container request.
* request : Scoped to an HTTP web request. Only used for web apps.
* session : Scoped to an HTTP web session. Only used for web apps.
* global : Scoped to a global HTTP web session. Only used for web apps. 

### Spring Bean Lifecycle Methods
* You can add custom codes for your bean initialization or destruction.


### Spring Boot
* Spring boot devtools : projeyi kaydettiğinde server'i otomatik yeniden başlatma.

### Hibernate
#### Session Factory
* Reads the hibernate config file
* Creates Session objects
* Heavy-weight object
* Only create once in your app
#### Session
* Wraps a JDBC connection
* Main object used to save/retrieve objects
* Short-lived object
* Retrieved from SessionFactory
#### Eager ve Lazy Loading
* https://medium.com/@e.karabudak7/lazy-loading-vs-eager-loading-67d09c6a251


### Tomcat 
* ubuntu tomcat stop :
    > sudo service tomcat9 stop

### SQL
* auto increment değerini sıfırlamak için truncate kullanılır
* Cascade delete : bir row silindiğinde o row'un foreign key'lerinin referans ettiği row'ların da silinmesi
* 