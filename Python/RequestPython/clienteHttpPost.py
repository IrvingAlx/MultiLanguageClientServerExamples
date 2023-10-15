import requests

r = requests.post('http://localhost:8080/multi', json={"num1": 4, "num2": 6})

if r.status_code == 200:
    print("Solicitud exitosa", r.status_code)
    print("Respuesta del servidor")
    print(r.text)
else:
    print(f"Solicitud fallida")
