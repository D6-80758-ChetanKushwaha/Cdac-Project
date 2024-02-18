import { useEffect, useState } from "react";
import { useQuery } from "@tanstack/react-query";
import  Axios  from "axios";
import ToastCom from "./Toast";
function Catelog() {

    // const {d1} = useQuery(["prod-data"],()=>{
    //   return Axios.get("https://localhost:8080/user/products").then((res)=> res.data);
    // });

    const [data, setData] = useState([
      {
          "key": 1,
          "title": "Juicy Apple",
          "price": 109.9,
          "image-url": "https://componentland.com/images/86WxAQqZpR5CqrhSPKwNv.png"
      },
      {
          "key": 2,
          "title": "Old Apple",
          "price": 19.9,
          "image-url": ""
      },
      {
          "key": 3,
          "title": "Sweet Apple",
          "price": 17.9,
          "image-url": ""
      },
      {
          "key": 4,
          "title": "Tasty Apple",
          "price": 119.9,
          "image-url": ""
      },
      {
          "key": 5,
          "title": "Delicious Apple",
          "price": 77679.9,
          "image-url": "https://componentland.com/images/86WxAQqZpR5CqrhSPKwNv.png"
      },
      {
          "key": 6,
          "title": "Crunchy Apple",
          "price": 119.9,
          "image-url": ""
      },
      {
          "key": 7,
          "title": "Yummy Apple",
          "price": 119.9,
          "image-url": ""
      },
      {
          "key": 8,
          "title": "Sour Apple",
          "price": 119.9,
          "image-url": ""
      },
  ])

  const token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJja3VzaHdhaGE1MzZAZ21haWwuY29tIiwiaWF0IjoxNzA4MjU0NTQ1LCJleHAiOjE3MDgzNDA5NDUsImF1dGhvcml0aWVzIjoiU0VMTEVSIn0.oGw_scLgG_IhVncdN00v_OLjC_eRYQjzMJzAwOuDGwIF-c0XuYz3957LAKtejUAjxJF0vSRZEfylSZsVTKe8wg"

  const axiosInstance = Axios.create({
    headers: {
      // 'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json', // You can adjust the content type based on your API requirements
    },
  });

    useEffect(()=>{
      axiosInstance.get("http://localhost:8080/seller/products/1").then((res)=>{
          console.log(res.data)
          if(res!=null){
              setData(res.data)
          }
        })
    },[])
    
  
    const [cart, setCart] = useState(()=>{

      const storedCart = localStorage.getItem('myCartProds');
      return storedCart ? JSON.parse(storedCart) : [];

    })

    useEffect(()=> {
      localStorage.setItem('myCartProds',JSON.stringify(cart))
    },[cart])

      

    function addProdToCart(obj) {
      obj["quantity"] = 1
      setCart([...cart, obj])
      // debugger
      // {ToastCom}
      

      console.log(cart)
    }

    return (
        <div>
              {/* <p>?</p> */}
              <section class="bg-white py-12 text-gray-700 sm:py-16 lg:py-20">
                <div class="mx-auto max-w-screen-xl px-4 sm:px-6 lg:px-8">
                  <div class="mx-auto max-w-md text-center">
                    <h2 class="font-serif text-2xl font-bold sm:text-3xl">Fresh Fruits & Vegetables</h2>
                  </div>

                  <div class="mt-10 grid grid-cols-2 gap-6 sm:grid-cols-4 sm:gap-4 lg:mt-16">
                    
                    {/* {data-rendering login} */}
                  
                    

                        {
                          data.map((obj,index)=>(
                            <article class="relative flex flex-col overflow-hidden rounded-lg border">
                              <div class="aspect-square overflow-hidden">
                                <img class="h-full w-full object-cover transition-all duration-300 group-hover:scale-125" src={obj["image-url"]} alt="" />
                              </div>
                              <div class="absolute top-0 m-2 rounded-full bg-white">
                                <p class="rounded-full bg-emerald-500 p-1 text-[8px] font-bold uppercase tracking-wide text-white sm:py-1 sm:px-3">Sale</p>
                              </div>
                              <div class="my-4 mx-auto flex w-10/12 flex-col items-start justify-between">
                                <div class="mb-2 flex">
                                  <p class="mr-3 text-sm font-semibold">&#8377; {obj.price}</p>
                                  <del class="text-xs text-gray-400"> &#8377; {index} </del> 
                                </div>
                                <h3 class="mb-2 text-sm text-gray-400">{obj.title}</h3>
                              </div>
                              <button onClick={()=> addProdToCart(obj)} class="group mx-auto mb-2 flex h-10 w-10/12 items-stretch overflow-hidden rounded-md text-gray-600">
                                
                                <div class="flex w-full items-center justify-center bg-gray-100 text-xs uppercase transition group-hover:bg-emerald-600 group-hover:text-white">Add</div>
                                <div class="flex items-center justify-center bg-gray-200 px-5 transition group-hover:bg-emerald-500 group-hover:text-white">+</div>
                              </button> 
                            </article>
                          ))
                        }

                      
                      
                      

                    
                    {/* <article class="relative flex flex-col overflow-hidden rounded-lg border">
                      <div class="aspect-square overflow-hidden">
                        <img class="h-full w-full object-cover transition-all duration-300 group-hover:scale-125" src="https://componentland.com/images/7ObHe1EuFqmsZmri6-ROD.png" alt="" />
                      </div>
                      <div class="absolute top-0 m-2 rounded-full bg-white">
                        <p class="rounded-full bg-emerald-500 p-1 text-[8px] font-bold uppercase tracking-wide text-white sm:py-1 sm:px-3">Sale</p>
                      </div>
                      <div class="my-4 mx-auto flex w-10/12 flex-col items-start justify-between">
                        <div class="mb-2 flex">
                          <p class="mr-3 text-sm font-semibold">&#8377; 99.00</p>
                          <del class="text-xs text-gray-400"> &#8377; 79.00 </del>
                        </div>
                        <h3 class="mb-2 text-sm text-gray-400">Fresh Apples</h3>
                      </div>
                      <button class="group mx-auto mb-2 flex h-10 w-10/12 items-stretch overflow-hidden rounded-md text-gray-600">
                        <div class="flex w-full items-center justify-center bg-gray-100 text-xs uppercase transition group-hover:bg-emerald-600 group-hover:text-white">Add</div>
                        <div class="flex items-center justify-center bg-gray-200 px-5 transition group-hover:bg-emerald-500 group-hover:text-white">+</div>
                      </button>
                    </article> */}

                    
                  </div>
                </div>
              </section>

              
        </div>
    )
}

export default Catelog;