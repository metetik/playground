# C# Notlarım
* Solution : İçinde birden fazla projeyi barındıran mimari
* .net core : farklı platfromlarda da çalışabilen açık kaynak .net mimarisi
* byte,short,int,long,bool,char,string,double,decimal,enum,var
* decimal > double
* single line if condititon => 1:2?3
* vs comment : ctrl+k + ctrl+c
* vs uncomment : ctrl+k + ctrl+u
* c# metodları default value özelliğini destekler.
    * default value'lar en sona yazılmalı
* c#'da referansla parametre göndermek için ref keyword'u kullanılır.
* out : ref'in aynısı ama out'ta variable'ı set etme zorunluluğu yoktur.
*  params int[] ifadesini kullanarak method'lara istediğimiz kadar parametre gönderebiliriz.
    * params parametresi, method'un son parametresi olmak zorunda

* string kullanımı : 
    * `string[] students = new string[3];`<br>
    `students[0] = "asdas";`
    * veya : 
    <br>
    `string[] students2 = {"asds","saf","asdf"}`
* `foreach(var student in students)`
* çok boyutlu diziler : 
    * `string[,] students = new string[7,3];`
    * veya <br>`string [,] students = {`
    <br>`{"adad","saddas"},`
    <br>`{"ada23d","sasdaddas"}`
    <br>`};`
    * for kullanımı : 
    <br>`for(int i = 0;i<=students.GetUpperBound(0);i++)`
    <br>`{`
    <br>&emsp;`for(int j = 0;j<=students.GetUpperBound(1);j++)`
    <br>&emsp;`{`
    <br>&emsp;&emsp;`Console.WriteLine(students[i,j]);`
    <br>&emsp;`}`
    <br>`}`

* visual studio'da bir kod parçasını seçip>sağ tıklayıp>refactor>extract method yapmak o kod parçasını bir method haline getirir.

* C#'da foreach döngüsündeki döngü değişkeni değiştirilemez.

## String
* String metodları : 
    * string.Length
    * string.Clone()
    * string.EndsWith()
    * string.StartsWith()
    * string.IndexOf()
    * string.LastIndexOF()
    * string.Insert()
    * string.Substring()
    * string.ToLower()
    * string.ToUpper()
    * string.Replace()
    * string.Remove()
* String'in başına "@" gelirse "\\"'ları yok sayar.

## C# OOP
* C# Constructor => `Object obj = new Object{Id=2,Name="name"};
* Encapsulation
    * `public int Id` => field olarak tanımlama
    * `public int Id{ get; set; }` => property olarak tanımlama
    * `public string _firstName;`
    <br>`public string FirstName`
    <br>`{`
    <br>&emsp;`get { return _firstName; }`
    <br>&emsp;`set { _firstName = value; }`
    <br>`}`

* Interface
    * standart olarak inteface isimleri 'I' ile başlar
    * `class Customer:IPerson`
    * `IPerson person = new IPerson();`=>çalışmaz,
    * `IPerson person = new Customer();`=>çalışır
    *  bir class sadece bir inheritance yapabilir ancak birden çok implementation yapabilir.
    * Eğer implementation iş görüyorsa inheritance kullanılmaması gerekrir.

* Overriding yapmak için virtual methods kullanılır.

* Abstract class : hem normal method hem de abstract method barındıran class.
    * Abstract class'dan obje oluşturulamaz.
    * Abstract class'lar da birer inheritance'dır.

* Access Modifiers
    * C#'da property'nin default access modifier private'dır.
    * private : sadece tanımlandığı class'da kullanılabilir.
    * protected : tanımlandığı class'larda ve onu inherit eden class'larda kullanılabilir.
    * public : her yerde kullanılabilir.
    * bir class ya public ya da internal'dır. Ancak bir nested class private olabilir.
    * internal : internal bir class, bağlı bulunduğu projede referans ihtiyacı olmadan kullanılabilir.
    * Class'ların default access modifier'ı internal'dır.
    * public bir class başka bir projede import edildiğinde de kullanılabilir.
    * private bir variable'ın bulunduğu class extend edilirse, private variable extend edildiği class'da kullanılamaz.

* Constructor oluştrumak için kısayol : ctor yazıp 2xTab
* private variable'lar standart olarak _ ile başlar
* Constructor Injection : new içinde new

* Static class
    * C#'da static class'lar new'lenemez
    * Static olmayan bir class'ın içinde static bir method olabilir. Bu methodu kullanmak için class'ı new'lemeye gerek yoktur.

## Referans ve değer tipler
* Değer Tipleri: “int”, “long”, “float”, “double”, “decimal”, “char”, “bool”, “byte”, “short”, “struct”, “enum”
* Referans Tipleri: “string”, “object”, “class”, “interface”, “array”, “delegate”, “pointer”

## Collections
* ArrayList'e herhangi bir tipte nesne gönderilebilir.
* List'e ise belirli tiplerde nesne gönderilebilir.
* Collection Methodları
    * Count : obje sayısı
    * Add : obje ekle
    * AddRange : objeleri array ile ekle 
    * Clear : List'i temizle
    * Contains : obje var mı?
    * IndexOf : obje kaçıncı sırada
    * Insert : sıraya ekle
    * Remove : silme
    * RemoveAll : `customers.RemoveAll(c=>c.FirstName="Muhammed");`
    customer'ların içinde FirstName'i Muhammed olanların hepsini sil.


 ## Kaynak
 * https://www.udemy.com/course/komple-sifirdan-web-gelistirme-kursu/
