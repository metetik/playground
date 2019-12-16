#flask - mysql

from flask import Flask,render_template,flash,redirect,url_for,session,logging,request
from flask_mysqldb import MySQL
from wtforms import Form,StringField,TextAreaField,PasswordField,validators
from passlib.hash import sha256_crypt

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

        return redirect(url_for("index")) #index fonksiyonunun adresine git
    else:
        return render_template("register.html",form = form) 
     
def dinamik(id):
    return "dinamik url id : " + id
if __name__ == "__main__":
    app.run(debug= True)