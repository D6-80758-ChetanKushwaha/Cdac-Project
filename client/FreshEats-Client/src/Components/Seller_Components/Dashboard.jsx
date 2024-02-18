import React from 'react';
import SidePanal from './SidePanal';
import { Routes, Route } from 'react-router-dom'
import Nav from './Nav';
import Content from './Content';
const Dashboard = () => {
  return (
    <div>
      <Nav/>
      <SidePanal/>
          <Routes>

            
            {/* <Route path="/" element={<Content/>}/> */}
          

          </Routes>
      
          {/* <!-- AlpineJS --> */}
        <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
        {/* <!-- Font Awesome --> */}
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" integrity="sha256-KzZiKy0DWYsnwMF+X1DvQngQ2/FxF7MF3Ff72XcpuPs=" crossorigin="anonymous"></script>


    </div>
  );
};

export default Dashboard;
