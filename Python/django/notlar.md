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
* ORM : Object to Relational Mapping. SQl kodu yazmadan veritabanını yönetebilmek.
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
* Varsayılan port 8000'dir.8080'de çalıştırmak için : 
> python manage.py runserver 8080

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
    <br>&emsp;&emsp;`list_display_links = ['title',&emsp;&emsp;'publishing_date']`
    <br>&emsp;&emsp;`list_filter = ['publishing_date']`
    <br>&emsp;&emsp;`search_fields = ['title','content']`
    <br>&emsp;&emsp;`class Meta:`
        <br>&emsp;&emsp;&emsp;&emsp;`model = Post`

## Kaynaklar
* [Barış Aslan Youtube Oynatma Listesi](https://www.youtube.com/playlist?list=PLPrHLaayVkhny4WRNp05C1qRl1Aq3Wswh) - [GitHub Kodları](https://github.com/barissaslan/django-dersleri)