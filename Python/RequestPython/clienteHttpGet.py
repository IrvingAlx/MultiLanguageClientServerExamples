import requests
r = requests.get('http://localhost:8001')

if r.status_code == 200:
    print("Solicitud exitosa", r.status_code)
    print("Contenido HTML:")
    print(r.text)
else:
    print(f"Solicitud fallida")
