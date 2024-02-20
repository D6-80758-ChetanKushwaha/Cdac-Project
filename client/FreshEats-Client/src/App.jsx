import { useState } from 'react'
import Example from './Components/User_Components/Header'
import Login from './Components/User_Components/Login'
// import './App.css'
import { Routes, Route } from 'react-router-dom'
import Footer from './Components/User_Components/Footer'
import Dashboard from './Components/User_Components/Dashboard'
import Cart from './Components/User_Components/Cart'
import SignUp from './Components/User_Components/SignUp'
import About from './Components/User_Components/About'
import { Link } from 'react-router-dom'
import ToastCom from './Components/User_Components/Toast'
import Seller from './Seller'
import NotFound from './Components/NotFound'
import ProductDetails from './Components/User_Components/ProductDetails'

function App() {
  
  return (
    <>
        {/* User Side Of Application */}
        <Example/>
          <Routes>

            {/* User Routes */}
            {/* <Route path="/user"> */}

            <Route index element={<Dashboard/>}/>
            <Route path="/home" element={<Dashboard/>}/>
            <Route path='/login' element={<Login/>} />
            <Route path='/Cart' element={<Cart/>}/>
            <Route path='/SignUp' element={<SignUp/>} />
            <Route path='/About' element={<About/>} />
            <Route path='/ProductDetails' element={<ProductDetails/>} />
            <Route path='*' element={<NotFound/>} />

            {/* </Route> */}

          </Routes>
        <Footer/>
        
    </>
  )
}

export default App
