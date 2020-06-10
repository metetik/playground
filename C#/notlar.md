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
* Access Modifiers
    * C#'da property'nin default access modifier private'dır.
    * private : sadece tanımlandığı class'da kullanılabilir.
    * protected : tanımlandığı class'larda ve onu inherit eden class'larda kullanılabilir.
    * public : her yerde kullanılabilir.
    * bir class ya public ya da internal'dır. Ancak bir nested class private olabilir.
    * internal : internal bir class, bağlı bulunduğu projede referans ihtiyacı olmadan kullanılabilir.
    * public bir class başka bir projede import edildiğinde de kullanılabilir.

* Constructor oluştrumak için kısayol : ctor yazıp 2xTab
* private variable'lar standart olarak _ ile başlar

 ## Kaynak
 * https://www.udemy.com/course/komple-sifirdan-web-gelistirme-kursu/
