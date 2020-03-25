from django.db import models

class Article(models.Model):
    author = models.ForeignKey("auth.User",on_delete = models.CASCADE,#eğer user silinirse article'ı da sil
    verbose_name = "Yazar")#label'da yazar yazacak
    title = models.CharField(max_length=50,verbose_name="Başlık")
    content = models.TextField(verbose_name="İçerik")
    created_date = models.DateTimeField(auto_now_add=True,verbose_name="Oluşturulma Tarihi")#tarih otomatik olarak dolduruluyor
    def __str__(self):
        return self.title#object1 yerine title ismi yazacak

