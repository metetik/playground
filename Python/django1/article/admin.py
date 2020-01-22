from django.contrib import admin

from .models import Article

# Register your models here.

@admin.register(Article)
class ArticleAdmin(admin.ModelAdmin):
    list_display = ["title","author","created_date","content"]#bu özellikleri göster
    
    list_display_links = ["title","created_date"]#article düzenleme linki
    
    search_fields = ["title"]#arama çubuğu
    
    list_filter = ["created_date"]#oluşturulma tarihine göre filtre
    class Meta:
        model = Article
