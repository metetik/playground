from django.shortcuts import render,HttpResponse

def post_home(request):
    return HttpResponse("<h1>Post Home</h1>")
def post_index(request):
    return HttpResponse("<h1>Post Index</h1>")
def post_detail(request):
    return HttpResponse("<h1>Post Detail</h1>")
def post_create(request):
    return HttpResponse("<h1>Post Create</h1>")
def post_update(request):
    return HttpResponse("<h1>Post Update</h1>")
def post_delete(request):
    return HttpResponse("<h1>Post Delete</h1>")

# Create your views here.
