import { useState } from 'react'
import Example from './Components/Header'
import Login from './Components/Login'
// import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Footer from './Components/Footer'
import Dashboard from './Components/Dashboard'
import Cart from './Components/Cart'

function App() {
  const [count, setCount] = useState(0)

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
        </Routes>

        <Footer/>
      </Router>

    </>
  )
}

export default App
