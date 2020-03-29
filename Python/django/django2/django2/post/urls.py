from django.urls import path, re_path
from .views import *

app_name = "post"

urlpatterns = [
    #path('', post_home,name = "home"),
    path('index/', post_index, name="index"),
    re_path(r'^(?P<id>\d+)/$', post_detail, name="detail"),
    path('create/', post_create, name = "create"),
    re_path(r'^(?P<id>\d+)/update/$', post_update, name = "update"),
    re_path(r'^(?P<id>\d+)/delete/', post_delete, name = "delete")
]
