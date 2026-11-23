# Ejemplos cliente-servidor en varios lenguajes

La misma idea (un cliente que pide y un servidor que responde) implementada en Java, Python, Node.js y Flask, para comparar cómo se resuelve en cada uno, desde sockets hasta HTTP.

## Qué incluye

| Carpeta | Lenguaje | Qué demuestra |
| --- | --- | --- |
| `Java/ServidorSocket`, `Java/ClienteSocket` | Java | Comunicación con sockets TCP |
| `Java/ChatServidor`, `Java/ChatCliente` | Java | Chat entre cliente y servidor |
| `Java/ServidorHttp`, `Java/ClienteHttp` | Java | Servidor y cliente HTTP |
| `Python/SocketPython` | Python | Cliente y servidor con sockets |
| `Python/RequestPython` | Python | Cliente HTTP con peticiones GET y POST |
| `Flask/webServiceFlask` | Python (Flask) | Servicio web con operaciones aritméticas: GET `/suma/<a>/<b>`, `/rest/<a>/<b>` y POST `/mult`, `/divi` |
| `nodejs` | Node.js (Express) | Servicio con POST `/suma`, `/rest`, `/multi` y `/divi` |

## Cómo correr un ejemplo

- **Python:** `python Python/SocketPython/servidor.py` y en otra terminal `python Python/SocketPython/cliente.py`.
- **Flask:** instala `flask` y ejecuta `flask --app Flask/webServiceFlask/webService run`.
- **Node.js:** `cd nodejs && npm install && node app.js`.
- **Java:** abre cada carpeta como proyecto en IntelliJ y ejecuta `Main` (primero el servidor, luego el cliente).

## Para qué sirve

Es material de estudio de redes y sistemas distribuidos: ver lado a lado cómo cambia el código entre un socket crudo y un servicio HTTP, y entre lenguajes.
