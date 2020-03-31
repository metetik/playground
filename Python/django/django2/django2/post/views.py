from django.shortcuts import render,HttpResponse,get_object_or_404,HttpResponseRedirect,redirect,Http404
from .models import Post
from .forms import PostForm
from django.contrib import messages

def post_home(request):
    return HttpResponse("<h1>Post Home</h1>")

def post_index(request):
    posts = Post.objects.all()
    return render(request,"post/index.html",{'posts' : posts})

def post_detail(request,id):
    post = get_object_or_404(Post,id = id)
    context = {
        'post' : post,
    }
    return render(request,"post/detail.html",context)

def post_create(request):
    if not request.user.is_authenticated:
        return Http404
#    form = PostForm()   
#    if request.method == "POST":
        # Formdan gelen bilgileri kaydet
#        form = PostForm(request.POST)
#
#        if form.is_valid():
#            form.save()
#    else:
        # Formu kullanıcıya göster
#        form = PostForm()
#    return render(request, "post/form.html",context)

#   yukardaki uzun kodun aynısı
    form = PostForm(request.POST or None, request.FILES or None)
    if form.is_valid():
        post = form.save()
        messages.success(request, "Başarılı bir şekilde oluşturdunuz..")
        return HttpResponseRedirect(post.get_absolute_url())
    context = {
        "form" : form,
    }
    return render(request, "post/form.html",context)
 
def post_update(request, id):
    if not request.user.is_authenticated:
        return Http404
    post = get_object_or_404(Post, id = id)
    form = PostForm(request.POST or None,request.FILES or None,instance=post)
    if form.is_valid():
        post = form.save()
        messages.success(request,"Başarılı bir şekilde güncellediniz..")
        return HttpResponseRedirect(post.get_absolute_url())
    context = {
        "form" : form,
    }
    return render(request, "post/form.html",context)
def post_delete(request,id):
    if not request.user.is_authenticated:
        return Http404
    post = get_object_or_404(Post, id = id)
    post.delete()
    return redirect("post:index")

# Create your views here.
