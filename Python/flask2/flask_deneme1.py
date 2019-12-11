from flask import Flask,render_template

app = Flask("__name__")

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