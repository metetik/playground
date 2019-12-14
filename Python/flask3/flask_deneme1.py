#flask - mysql

from flask import Flask,render_template,flash,url_for,session,logging,request
#from flask_mysqldb import MySQL
from wtforms import Form,StringField,TextAreaField,PasswordField,validators
from passlib.hash import sha256_crypt

#Kullanıcı kayıt formu
class RegisterForm(Form):
    name = StringField()
app = Flask("__name__")

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

#dinamik url
@app.route("/dinamik/<string:id>")
def dinamik(id):
    return "dinamik url id : " + id
if __name__ == "__main__":
    app.run(debug= True)