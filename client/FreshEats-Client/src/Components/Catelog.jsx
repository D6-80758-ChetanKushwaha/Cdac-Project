import {createContext, useEffect, useState } from "react";

const CartContext = createContext();

function Catelog() {
    
    const data = [
      {
        "title":"Fresh Apple",
        "price":99.9,
        "image-url":"https://componentland.com/images/86WxAQqZpR5CqrhSPKwNv.png"
      },
      {
        "title":"Stale Apple",
        "price":9.9,
        "image-url":""
      },
      {
        "title":"Fresh Apple",
        "price":7.9,
        "image-url":""
      },
      {
        "title":"Fresh Apple",
        "price":99.9,
        "image-url":""
      },
      {
        "title":"Fresh Apple",
        "price":76679.9,
        "image-url":"https://componentland.com/images/86WxAQqZpR5CqrhSPKwNv.png"
      },
      {
        "title":"Fresh Apple",
        "price":99.9,
        "image-url":""
      },
      {
        "title":"Fresh Apple",
        "price":99.9,
        "image-url":""
      },
      {
        "title":"Fresh Apple",
        "price":99.9,
        "image-url":""
      },
    ]

    const [cart, setCart] = useState(()=>{
      const storedCart = localStorage.getItem('myCartProds');
      return storedCart ? JSON.parse(storedCart) : [];
    })

    useEffect(()=>{
      localStorage.setItem('myCartProds',JSON.stringify(cart))
    },[cart])

      

    function addProdToCart(obj) {
      setCart(prevCart => [...prevCart, obj])
    }

    return (
        <div>
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

                      <CartContext.Provider value={{ cart, addProdToCart }}>

                      </CartContext.Provider>
                      
                      

                    
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

export { CartContext, Catelog };