from django.db import models
from django.urls import reverse
from ckeditor.fields import RichTextField

# Create your models here.

class Post(models.Model):
    user = models.ForeignKey('auth.User',verbose_name="Yazar",related_name="posts",on_delete=models.CASCADE)
    title = models.CharField(max_length=120,verbose_name='Başlık')
    content = RichTextField(verbose_name='İçerik')
    publishing_date = models.DateTimeField(verbose_name='Oluşturulma Tarihi', auto_now_add=True)
    image = models.ImageField(null=True, blank=True)
    
    def __str__(self):
        return self.title
    
    def get_absolute_url(self):
        return reverse("post:detail", kwargs = {"id" : self.id})
    def get_create_url(self):
        return reverse("post:create")
    def get_update_url(self):
        return reverse("post:update", kwargs = {"id" : self.id})
    def get_delete_url(self):
        return reverse("post:delete", kwargs = {"id" : self.id})      

    class Meta:
        ordering =['-publishing_date']

class Comment(models.Model):
    post = models.ForeignKey('post.Post', related_name='comments', on_delete=models.CASCADE)
    name = models.CharField(max_length=50,verbose_name='İsim')
    content = models.TextField(verbose_name='Yorum')
    created_date = models.DateTimeField(auto_now_add=True)