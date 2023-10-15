from socket import *

servidor = socket(AF_INET, SOCK_STREAM) # Crear TCP/IP socket
server_address = ('localhost', 8000)    # Bind el socket al puerto 
print('Conexion en {} puerto {}'.format(*server_address))
servidor.bind(server_address)
servidor.listen(1)  # Escuchar conecciones entrantes

while True:
    print('Esperando conexion')
    c,a = servidor.accept()
    try:
        print('Conectadod desde', a)

        data = c.recv(1000)
        print('Mensaje recibido {!r}'.format(data))
        c.send(b'HOLA DESDE SERVIDOR!!!\n')

    finally:
        c.close()   # Cerrrar la conexion 
