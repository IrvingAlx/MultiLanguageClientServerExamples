from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route("/")
def heola_mundo():
    return "<p>Hola, Mundo!</p>"

@app.route("/suma/<int:num1>/<int:num2>")
def suma(num1,num2):
    resultado = num1 + num2
    return f"<p>Suma de: {num1} + {num2} = {resultado}</p>"

@app.route("/rest/<int:num1>/<int:num2>")
def resta(num1,num2):
    resultado = num1 - num2
    return f"<p>Suma de: {num1} - {num2} = {resultado}</p>"

@app.route("/mult",methods=['POST'])
def multiplicacion():
    data = request.get_json()
    if "num1" in data and "num2" in data:
        num1 = data["num1"]
        num2 = data["num2"]
        resultado = num1 * num2
        return jsonify({"resultado": resultado})
    else:
        return jsonify({"error":"Faltan datos"}),400 

@app.route("/divi",methods=['POST'])
def division():
    data = request.get_json()
    if "num1" in data and "num2" in data:
        num1 = data["num1"]
        num2 = data["num2"]
        resultado = num1 / num2
        return jsonify({"Resultado": resultado})
    else:
        return jsonify({"Error":"Faltan datos"}),400