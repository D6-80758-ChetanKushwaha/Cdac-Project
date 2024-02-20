const express = require('express')
const cors = require('cors')
const morgan  = require('morgan')

// create new react app

const app = express()

app.use(cors())
app.use(morgan('combined'))
app.use(express.json())
app.use(express.urlencoded({extended: true}))

const userRouter= require('./routes/users')
app.use('/user',userRouter)

app.listen(4000, '0.0.0.0',()=>{
    console.log('server started on port 4000')
})