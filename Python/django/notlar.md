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
    >source sanort/bin/activate
    
    komut satırında "(sanort)" yazıyorsa sanal ortam aktifdir.
4. Sanalortamı deaktive etmek : 
    >deactive

## Django projesi oluşturma
* Sanal ortam aktif olmalı
1. Django kur
>pip3 install django
2. Django projesini oluştur
>django-admin startproject proje_adi .

'.' :  bu dizine kur.
3. 
## Kaynaklar
* [Barış Aslan Youtube Oynatma Listesi](https://www.youtube.com/playlist?list=PLPrHLaayVkhny4WRNp05C1qRl1Aq3Wswh)