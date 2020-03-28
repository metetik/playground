from django.shortcuts import render,HttpResponse

def home(request):
    if request.user.is_authenticated:
        context = {"user" : request.user.username}
    else:
        context = {"user" : "Misafir"}
        
    return render(request,"home.html",context)
    
    
# Create your views here.
