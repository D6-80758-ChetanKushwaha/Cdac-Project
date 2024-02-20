const express = require('express')
const router = express.Router()
const db = require( '../db')
const utils = require('../utils')
const cryptoJs = require('crypto-js')
const jwt = require('jsonwebtoken')
const config = require('../config')

router.post('/signup', async (req, resp)=>{


    console.log("Getting Request")
    try{

        const {createdAt,firstName, lastName, email, password, role, updatedAt, userName} = req.body
    
        const encryptedPassword = String(cryptoJs.SHA256(password))
        console.log(encryptedPassword)
        const statement = `insert into users (created_at, email, first_name, last_name,password,role,updated_at,username) 
        values (?, ?, ?, ? ,? ,? ,? ,?)`
    
        const result = await db.execute(statement, [createdAt, email, firstName, lastName, encryptedPassword, role,updatedAt, userName])
        resp.send(utils.createSuccess(result))

    }catch(ex){

        resp.send(utils.createError(ex))
    }

})


router.post('/signin', async (req,resp)=>{
    console.log("Getting Request")
    try{

        const {email, password} = req.body
    
        const encryptedPassword = String(cryptoJs.SHA256(password))
        console.log(encryptedPassword)
        const statement = `select id, first_name,last_name from users where email = ? and password = ?`
    
        const [users] = await db.execute(statement, [email, encryptedPassword])
        // resp.send(utils.createSuccess(users))
        if(users.length == 0){
            resp.send(utils.createError("User Not Exist"))
        }
        else{
            const user = users[0];
            const token = jwt.sign({
                id: user['id'], firstName: user['first_name']
            },config.secret)
            resp.send(
                utils.createSuccess(
                    {
                        token,
                        firstName:user['first_name'],
                        lastName: user["last_name"]
                    })
                )
        }

    }catch(ex){

        resp.send(utils.createError(ex))
    }
})
module.exports = router