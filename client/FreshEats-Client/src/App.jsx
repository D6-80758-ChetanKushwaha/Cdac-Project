import { useState } from 'react'
import Example from './Components/Header'
import Login from './Components/Login'
// import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Footer from './Components/Footer'
import Dashboard from './Components/Dashboard'
import Cart from './Components/Cart'
import SignUp from './Components/SignUp'
import About from './Components/About'
import { Link } from 'react-router-dom'

let temp = [
  
]

localStorage.setItem('myCartProds', JSON.stringify(temp));

function App() {
  const [count, setCount] = useState(0)

  // Creating Global Session Storage...

  return (
    <>
      {/* <Login/> */}
      <Router>
          {/* <Route path='/' element={<Example/>} /> */}
        <Example/>

        <Routes>
          <Route path="" element={<Dashboard/>}/>
          <Route path='/login' element={<Login/>} />
          <Route path='/Cart' element={<Cart/>}/>
          <Route path='/SignUp' element={<SignUp/>} />
          <Route path='/About' element={<About/>} />
        </Routes>

        <Footer/>
      </Router>

    </>
  )
}

export default App
