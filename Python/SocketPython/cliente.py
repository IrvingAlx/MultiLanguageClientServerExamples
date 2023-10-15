from socket import *
cliente = socket(AF_INET, SOCK_STREAM)
cliente.connect(("localhost",8000))
cliente.send(b'HOLA DESDE PYTHON!!!\n')
data = cliente.recv(1000)
print('received {!r}'.format(data))
print(data.decode('ascii'))
