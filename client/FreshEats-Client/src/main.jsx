import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import Seller from './Seller.jsx'
import { BrowserRouter , Routes, Route} from 'react-router-dom'


ReactDOM.createRoot(document.getElementById('root')).render(
  
  <React.StrictMode>

      <BrowserRouter>
        <Routes>
          <Route path="/user/*" element={<App/>}/>
          <Route path="/seller/*" element={<Seller/>}/>
        </Routes>
      </BrowserRouter>

  </React.StrictMode>,
)
