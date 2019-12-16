#flask - mysql

from flask import Flask,render_template,flash,redirect,url_for,session,logging,request
from flask_mysqldb import MySQL
from wtforms import Form,StringField,TextAreaField,PasswordField,validators
from passlib.hash import sha256_crypt
from functools import wraps

#Kullanıcı giriş decorator'ı
def login_required(f):
    @wraps(f)
    def decorated_function(*args, **kwargs):
        if "logged_in" in session:
            return f(*args, **kwargs)
        
        else:
            flash("Bu sayfayı görüntülemek için lütfen giriş yapın","primary")
            
            return redirect(url_for("login"))
    return decorated_function

#Kullanıcı kayıt formu
class RegisterForm(Form):
    #isim soyisim alanı oluştur,min 4 max 25 değer alabilsin
    name = StringField("İsim Soyisim",validators = [validators.Length(min = 4,max = 25)])
    
    username = StringField("Kullanıcı Adı",validators = [validators.Length(min = 5,max = 35)])
    
    #girilen adres email mi kontrol et, değilse mesajı yaz
    email = StringField("E-Mail",validators = [validators.Email(message = "Lütfen geçerli bir email adresi giriniz.")])
    
    password = PasswordField("Parola",validators = [
        validators.DataRequired(message = "Lütfen bir parola giriniz"),
        
        #parola ile confirm uyuşmuyorsa mesajı yazdır
        validators.EqualTo(fieldname = "confirm", message = "Parola uyuşmuyor..") 
    ])

    confirm = PasswordField("Parola Doğrula")

class LoginForm(Form):
    username = StringField("Kullanıcı Adı")      
    password = PasswordField("Parola")

class ArticleForm(Form):
    title = StringField("Makale Başlığı",validators = [validators.Length(min = 5,max = 100)])

    content = TextAreaField("Makale İçeriği",validators = [validators.Length(min = 5,max = 1000)])

app = Flask("__name__")

app.secret_key = "ybblog"#flash mesaj özelliğini kullanmak için bir secret key gerekir

# Veritabanı ayarları
app.config["MYSQL_HOST"] = "localhost"
app.config["MYSQL_USER"] = "root"
app.config["MYSQL_PASSWORD"] = ""
app.config["MYSQL_DB"] = "ybblog"#tablo adı
app.config["MYSQL_CURSORCLASS"] = "DictCursor"#Cursor'den gelen sonuçlar dict biçininde olacak

mysql = MySQL(app) #MySQL'e flask objesini gönderiyor

@app.route("/")
def index():
    return render_template("index.html",sayi = "2")

@app.route("/about")
def about():
    return "Hakkımda"

#kayıt olma
@app.route("/register",methods = ["GET","POST"])#Hem get request hem de post request alabilir
def register():
    form = RegisterForm(request.form)

    if request.method == "POST" and form.validate():#request postsa ve form validate ise
        name = form.name.data
        username = form.username.data
        email = form.email.data
        password = sha256_crypt.encrypt(form.password.data)#parolayı alırken şifrele

        cursor = mysql.connection.cursor()

        sorgu = "insert into users(name,email,username,password) values(%s,%s,%s,%s)"

        cursor.execute(sorgu,(name,email,username,password))
        mysql.connection.commit()
        cursor.close()

        flash("Kayıt Başarılı...","success")#succes tipinde flash messagı kullanılacak

        return redirect(url_for("login")) #index fonksiyonunun adresine git
    else:
        return render_template("register.html",form = form) 

@app.route("/login",methods = ["GET","POST"])
def login():
    form = LoginForm(request.form)
    
    if request.method == "POST":
        username = form.username.data
        password_entered = form.password.data

        cursor = mysql.connection.cursor()
        
        sorgu = "select * from users where username = %s"

        sonuc = cursor.execute(sorgu,(username,))

        if sonuc > 0:
            data = cursor.fetchone()

            real_password = data["password"]

            if sha256_crypt.verify(password_entered,real_password):
                #Session kontrolü,giriş yapıldı
                session["logged_in"] = True
                session["username"] = username

                flash("Giriş Başarılı...","success")

                return redirect(url_for("index"))
            else:
                flash("Parola yanlış...","danger")

                return redirect(url_for("login"))
        else:
            flash("Kullanıcı bulunamadı","danger")

            return redirect(url_for("login"))
    else:
        return render_template("login.html",form = form)

@app.route("/logout")
def logout():
    session.clear()
    
    flash("Çıkış yapıldı...","success")

    return redirect(url_for("index"))

@app.route("/dashboard")
@login_required
def dashboard():
    cursor = mysql.connection.cursor()
    sorgu = "select * from articles where author = %s"
    sonuc = cursor.execute(sorgu,(session["username"],))
    
    if sonuc > 0:
        articles = cursor.fetchall()

        return render_template("dashboard.html",articles = articles)
    else:
        render_template("dashboard.html")

    return render_template("dashboard.html")

@app.route("/addarticle",methods = ["GET","POST"])
def addarticle():
    form = ArticleForm(request.form)
    
    if request.method == "POST" and form.validate():
        title = form.title.data
        content = form.content.data

        cursor = mysql.connection.cursor()
        sorgu = "insert into articles(title,author,content) values(%s,%s,%s)"
        cursor.execute(sorgu,(title,session["username"],content))
        mysql.connection.commit()
        cursor.close()

        flash("Makale başarıyla eklendi","success")

        return redirect(url_for("dashboard"))
    else:
        return render_template("addarticle.html",form = form)

@app.route("/articles",methods = ["GET","POST"])
def articles():
    cursor = mysql.connection.cursor()
    sorgu = "select * from articles"
    sonuc = cursor.execute(sorgu)

    if sonuc > 0:
        articles = cursor.fetchall()
        return render_template("articles.html",articles = articles)
    else:
        return render_template("articles.html")

#makale görüntüleme
@app.route("/article/<string:id>")
def article(id):
    cursor = mysql.connection.cursor()
    sorgu = "select * from articles where id = %s"
    sonuc = cursor.execute(sorgu,(id,))
    
    if sonuc > 0:
        article = cursor.fetchone()

        return render_template("article.html",article = article)
    else:
        return render_template("article.html")

#makale silme
@app.route("/delete/<string:id>")
@login_required
def delete(id):
    cursor = mysql.connection.cursor()
    sorgu = "select * from articles where id = %s and author = %s"
    sonuc = cursor.execute(sorgu,(id,session["username"]))
    
    if sonuc > 0:
        sorgu2 = "delete from articles where id = %s"
        cursor.execute(sorgu2,(id,))
        mysql.connection.commit()

        return redirect(url_for("dashboard"))
    else:
        flash("Böyle bir makale yok veya makaleyi silmeye yetkiniz yok...","danger")

        return redirect(url_for("index"))

#makale güncelleme
@app.route("/edit/<string:id>",methods = ["GET","POST"])
@login_required
def update(id):
    if request.method == "GET":
        cursor = mysql.connection.cursor()

        sorgu = "select * from articles where id = %s and author = %s"
        sonuc = cursor.execute(sorgu,(id,session["username"]))

        if sonuc == 0:
            flash("Böyle bir makale yok veya bu işleme yetkiniz yok","danger")
        
            return redirect(url_for("index"))
        else:
            article = cursor.fetchone()
            form = ArticleForm()
            form.title.data = article["title"]
            form.content.data = article["content"]

            return render_template("update.html",form = form)
    else:
        form = ArticleForm(request.form)
        
        newTitle = form.title.data
        newContent = form.content.data
        
        cursor = mysql.connection.cursor()
        sorgu = "update articles set title = %s,content = %s where id = %s"
        cursor.execute(sorgu,(newTitle,newContent,id))
        mysql.connection.commit()

        flash("Makale başarıyla güncellendi...","success")
        return redirect(url_for("dashboard"))

@app.route("/search",methods = ["GET","POST"])
def search():
    if request.method == "GET":
        return redirect(url_for("index"))
    else:
        keyword = request.form.get("keyword")

        print(keyword)
        
        cursor = mysql.connection.cursor()
        sorgu = "select * from articles where title like '%" +keyword+ "%'"
        sonuc = cursor.execute(sorgu)

        if sonuc == 0:
            flash("Makale bulunamadı","primary")
            
            return redirect(url_for("articles"))
        else:
            articles = cursor.fetchall()

            return render_template("articles.html",articles = articles)

if __name__ == "__main__":
    app.run(debug= True)