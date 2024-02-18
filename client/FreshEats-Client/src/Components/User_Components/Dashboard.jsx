import Carousel from "./Carousel"
import Catelog from "./Catelog"
// import { Carousel as car, initTE  } from "tw-elements"
function Dashboard() {

    return (

        <div>
          <div style={{height: "100%"}}>
            <Carousel/>
          </div>
          <div>

            <Catelog/>
          </div>
        </div>
            
    )
}

// initTE({ car });
export default Dashboard