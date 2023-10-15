const express = require('express')

const app = express()

const port = 8080

app.use(express.json())

app.post('/suma', (req,res) =>{
    const {num1,num2} = req.query
    if(!num1 || !num2 || isNaN(num1) || isNaN(num2)){
        res.status(400).json({error: 'Debes ingresar valores y deben ser validos'})
    }else{
        const resultado = parseInt(num1) + parseInt(num2)
        res.json(resultado)
    }
})

app.post('/rest', (req,res) =>{
    const {num1,num2} = req.query
    if(!num1 || !num2 || isNaN(num1) || isNaN(num2)){
        res.status(400).json({error: 'Debes ingresar valores y deben ser validos'})
    }else{
        const resultado = parseInt(num1) - parseInt(num2)
        res.json(resultado)
    }
})

app.post('/multi', (req,res) =>{
    const {num1,num2} = req.body
    if (typeof(num1) !== 'number' || typeof(num2) !== 'number'){
        res.status(400).json({error : 'Ambos deben ser valores numericos'})
    }else{
        const resultado = num1 * num2;
        res.json(resultado)
    }
})

app.post('/divi', (req,res) =>{
    const {num1,num2} = req.body
    if(typeof(num1) !== 'number' || typeof(num2) !== 'number'){
        res.status(400).json({error: 'Debes ingresar valores y deben ser validos'})
    }else{
        const resultado = num1 / num2
        res.json(resultado)
    }
})

app.listen(port, ()=>{
    console.log('Servidor en ejecucion...')
})