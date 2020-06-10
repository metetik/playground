# Django notlar

## Giriş
### Neden django?

* Hızlı geliştirme,az kod çok iş
* Detaylı hata raporları
* Hazır admin paneli ve kullanıcı sistemi
* MVT : Model-View-Template. MVC'ye benzer
    * Model : Veritabanı nesneleri
    * View : Arkaplanda çalışan metodlar
    * Template : Dinamik HTML sayfaları
* ORM : Object to Relational Mapping. SQL kodu yazmadan veritabanını yönetebilmek.
---
Django resmi dökümanları : docs.djangoproject.com
### Django için gerekenler
1. Python
2. Virtualenv kütüphanesi
3. Django

### Virtualenv Kurulumu
1. >pip install virtualenv
2. >virtualenv sanort

    (sanort : sanal ortamımızın adı)
3. Sanalortamı aktive etmek :

    Linux :
    >source sanort/bin/activate

    Windows :
    >sanort/Scripts/activate

    komut satırında "(sanort)" yazıyorsa sanal ortam aktifdir.
4. Sanalortamı deaktive etmek : 
    >deactive

## Django projesi oluşturma
 Sanal ortam aktif olmalı
1. Django kur
>pip3 install django
2. Django projesini oluştur
>django-admin startproject proje_adi .
* "." : bu dizine kur 

3. Dosyalar ne işe yarar?
    * manage.py : django ile ilgili komut çalıştırmaya yarıyor.
    * __init__.py : bu klasörün bir modül olduğunu belirtir.
    * settings.py : ayarlar
        * `INSTALLED_APPS` : projedeki uygulamaların tanımlandığı yer.
        * `TEMPLATE` : template ayarları burada bulunur.
        * `DATABASES` : veritabanı ayarları
        * `LAGUAGE_CODE` : dil ayarı.Türkçe desteği var.Türkçe yapmak için 'tr'.
        * `TIME_ZONE` : zaman dilimi.Türkiye'ye ayarlamak için 'Europe/Istanbul'
    * urls.py : URL adresleri burada tanımlanır.
    * wsgi.py : web sunucusuyla ilgili ayarların yapıldığı yer.

4. Server'i çalıştır
>python manage.py runserver
* Varsayılan port 8000'dir. 8080'de çalıştırmak için : 
>python manage.py runserver 8080

5. Migration
* Migration : uygulamaların içindeki verileri veritabanına taşımak.
>python manage.py migrate

6. Admin hesabı oluşturma
    * >python manage.py createsuperuser
    * username,email,password

## Uygulama Oluşturma
1. >python manage.py startapp uygulama_adi
2. Uygulama dosyaları:
    * __init__.py : bu klasörün bir modül olduğunu belirtir.
    * admin.py : yönetim paneliyle ilgili ayarların bulunduğu yer.
    * apps.py : uygulamayla ilgili ayarların bulunduğu dosya.
    * models.py : veritabanı nesnelerinin bulunduğu dosya.
    * tests.py : test yapmak için kullanılan dosya.
    * views.py : route fonksiyonlarının bulunduğu dosya.
    * migrations : uygulamanın veritabanını tutuyor.
3. settings.py'de `INSTALLED_APPS` kısmına uygulama adımız eklenir.
4. Veritabanı modeli oluşturma
    * models.py'nin içine veritabanı nesneleri class olarak tanımlanır.
    * model'in sql kodunu görmek için :
    > python manage.py sqlmigrate uygulama_adi 0001
5. migration dosyasını oluşturma
>python manage.py makemigrations
6. migration 
>python manage.py migrate
7. uygulamayı admin paneline bağlama : 
    * admin.py'nin içine şu kodlar eklenir : 
    
        `from .models import Model_Adi`
        <br>
        `admin.site.register(Model_Adi)`
    
8. Admin panelini özelleştirme :
    * Yukarıdaki kodları hatasız yazarsak uygulama ve bağlı modeller admin panelinde görünür. Admin panelindeki ekleme kısmındaki formların başlığını değiştirmek için models.py'nin içinde oluşturulan nesnelerinin constructer'larına parametre olarak `verbose_name` parametresini kullanabiliriz.

    * admin panelinde listelenen objelerin ismini özelleştirmek için models.py içinde örnek kod :

        `def __str__(self):`
        <br>&emsp;&emsp;`return self.title`

    * Admin paneline yeni özellikler eklemek için örnek kod :
    <br>`class PostAdmin(admin.ModelAdmin):`
    <br>&emsp;&emsp;`list_display = ['title','publishing_date']`
    <br>&emsp;&emsp;`list_display_links = ['title','publishing_date']`
    <br>&emsp;&emsp;`list_filter = ['publishing_date']`
    <br>&emsp;&emsp;`search_fields = ['title','content']`
    <br>&emsp;&emsp;`class Meta:`
        <br>&emsp;&emsp;&emsp;&emsp;`model = Post`
        
        * list_display : listeleme ekranında görünecekler
        * list_display_links : listeleme ekranında link olanlar
        * list_filter : filtreleme
        * search_fields : arama alanı

## View'ler
1. Anasayfa için bir uygulama oluşturalım.

2. Anasayfa uygulamasındaki views.py'nin içine anasayfanın URL fonksiyonunu ekleyelim:

    `def home(request)`
    <br>&emsp;&emsp; `return HttpResponse("<h1>Anasayfa</h1>")`

3. Fonksiyonu urls.py'ye ekleyelim:
     
     `from home.views import home`
     <br>&emsp;&emsp;&emsp;&emsp;`.....`
     <br>&emsp;&emsp;`path('', home)`
4. Post uygulaması içinde farklı işler gören farklı adresler var(index, create, delete gibi). Bu adresleri tanımlamak için önce post/urls.py'ye şu kodu ekleyelim : 
     
    `from views import *`
    <br>&emsp;&emsp;&emsp;&emsp;`.....`
    <br>&emsp;&emsp;`path('', post_home),`
    <br>&emsp;&emsp;`path('index/', post_index),`
    <br>&emsp;&emsp;`path('detail/', post_detail),`
    <br>&emsp;&emsp;`path('create/', post_create),`
    <br>&emsp;&emsp;`path('update/', post_update),`
    <br>&emsp;&emsp;`path('delete/', post_delete)`
5. Bu adreslerin view'lerini yazalım :

    `def post_home(request):`
    <br>&emsp;&emsp;`return HttpResponse("<h1>Post Home</h1>")`
    <br>`def post_index(request):`
    <br>&emsp;&emsp;`return HttpResponse("<h1>Post Index</h1>")`
    <br>`def post_detail(request):`
    <br>&emsp;&emsp;`return HttpResponse("<h1>Post Detail</h1>")`
    <br>`def post_create(request):`
    <br>&emsp;&emsp;`return HttpResponse("<h1>Post Create</h1>")`
    <br>`def post_update(request):`
    <br>&emsp;&emsp;`return HttpResponse("<h1>Post Update</h1>")`
    <br>`def post_delete(request):`
    <br>&emsp;&emsp;`return HttpResponse("<h1>Post Delete</h1>")`
6. Projenin içindeki urls.py'nin içine şu kodu ekleyelim :

    `path('post/', include('post.urls'))`

## Templates

1. Proje dizini içerisinde templates adında bir klasör oluşturalım.

2. templates kalsörünü projenin tanıması için settings.py>`TEMPLATES`>`DIRS`'e ekleyelim : 

    `'DIRS': [BASE_DIR+'/templates'],`

3. templates klasörü içinde home.html dosyasını oluşturalım.

4. home>views.py ye şu kodu ekleyelim : 

    `return render(request,"home.html",{})`

## Sayfaya içerik göndermek
* Anasayfa'da eğer oturum açılmışsa kullanıcı adını yazması değilse misafir yazması için : 
    * home>views.py :

        `def home(request):`
        <br>&emsp;&emsp;`if request.user.is_authenticated:`
        <br>&emsp;&emsp;&emsp;&emsp;`context = {"user" : request.user.username}`
        <br>&emsp;&emsp;`else:`
        <br>&emsp;&emsp;&emsp;&emsp;`context = {"user" : "Misafir"}`
        <br><br>&emsp;&emsp;`return render(request,"home.html",context)`
    * templates>home.html :

        `<h1>Hoşgeldiniz,{{ user }}</h1>`
## Django shell
* >python manage.py shell
> `>>> from post.models import Post`<br>
>`>>> from django.utils import timezone`<br>
* Tüm postları listeleme :
> `>>> Post.objects.all()`
* Post ekleme
> `>>> su_an = timezone.now()`<br>
> `>>> Post.objects.create(title="deneme1",content="deneme1 içerik",publishing_date=su_an)`

veya 
> `>>> nesne = post()`<br>
> `>>> nesne.title = "deneme2"`<br>
> `>>> nesne.content = "deneme2 içerik"`<br>
> `>>> nesne.publishing_date = su_an`<br>
> `>>> Post.objects.all()`

* Post getirme
> `>>> a = Post.objects.get(id=1)`

* Post silme
> `>>> a.delete()`
 
* Filtreleme
> `>>> Post.objects.filter(title__contains='deneme')`

## Notlar
* regular expression path : re_path
* get metoduyla giden istekler adres çubuğunda görülür.Post metoduyla giden istekler görülmez.

#### Shell'de kullanıcı oluşturma
>`>>> from django.contrib.auth.models import User`<br>
>`>>> user=User.objects.create_user('foo', password='bar')`<br>
>`>>> user.is_superuser=False`<br>
>`>>> user.is_staff=False`<br>
>`>>> user.save()`<br>

* form dosyalarından dosya almak için form tagina şu ayarı yapmak gerekir : `enctype="multipart/form-data"`
## Kaynaklar
* [Barış Aslan Youtube Oynatma Listesi](https://www.youtube.com/playlist?list=PLPrHLaayVkhny4WRNp05C1qRl1Aq3Wswh) - [GitHub Kodları](https://github.com/barissaslan/django-dersleri)