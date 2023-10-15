const http = require('http')

const server = http.createServer( (req,res) => {
    res.writeHead(200, { 'Content-Type':'text/html'})
    res.end('<html><body><h1>Hola soy el servidor de Irving en nodejs</h1></body></html>')
})

server.listen(8001, 'localhost', () => {
    console.log('Servidor escuchando el http://localhost:8001')
})