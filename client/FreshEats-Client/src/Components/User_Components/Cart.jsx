import React, { useState, useEffect } from 'react';



const Cart = () => {

    const [dataList, setDataList] = useState(()=>{
        const data = localStorage.getItem("myCartProds")
        return data ? JSON.parse(data) : [];
    })

    const [quantity, setQuantity] = useState(1);
    const productPrice = 19.99;
    const taxes = 1.99;
    const shipping = 0.00;
    

    const handleDecrease = (k) => {
        const updatedItems = dataList.map(item => {
            if(item.key === k){
                if(item.quantity - 1 < 1){
                    console.log(item.key)
                    return null; // return null for the item to delete
                }
                return { ...item, quantity: item.quantity - 1 }
            }
            return item;
        }).filter(item => item !== null); // filter out null values
    
        setDataList(updatedItems);
    };

    // const handleDecrease = (k) => {
    //     const updatedItems = dataList.map(item => {

    //         if(item.key === k){

    //             if(item.quantity - 1 < 1){
    //                 console.log(item.key)
    //                 // deleteCart(item.key)
                
    //             }
    //             return { ...item, quantity: item.quantity - 1 }
            
                
    //         }
    //         return item;
    //     }
    //         // item.key === k  ? { ...item, quantity: item.quantity - 1 } : item
    //     );


    //     setDataList(updatedItems);
    // };

    function handleIncrease(k) {
        const updatedItems = dataList.map(item => {
            if(item.key === k){
                return { ...item, quantity: item.quantity + 1 }
            }
            return item;
        })
    
        setDataList(updatedItems);
    };


    useEffect(()=> {
        localStorage.setItem('myCartProds',JSON.stringify(dataList))
        console.log("inside useEffect")
        console.log(dataList)
    },[dataList])


    function deleteCart(key){
        // console.log("before delete")
        // console.log(dataList)
        setDataList(dataList.filter((obj,i) => key !== obj.key))
        // console.log("after Delete")
        console.log(dataList)
    }

    return (
        <div className="bg-gray-100 h-screen py-8">
            <div className="container mx-auto px-4">
                <h1 className="text-2xl font-semibold mb-4">Shopping Cart</h1>
                <div className="flex flex-col md:flex-row gap-4">
                    <div className="md:w-3/4">
                        <div className="bg-white rounded-lg shadow-md p-6 mb-4">
                            <table className="w-full">
                                <thead>
                                    <tr>
                                        <th className="text-left font-semibold">Product</th>
                                        <th className="text-left font-semibold">Price</th>
                                        <th className="text-left font-semibold">Quantity</th>
                                        <th className="text-left font-semibold">Total</th>
                                        <th className="text-left font-semibold"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                {
                                    dataList.map((obj,index)=>(
                                        <tr>
                                            <td className="py-4">
                                                <div className="flex items-center">
                                                    <img className="h-16 w-16 mr-4" src={obj["image-url"]} alt="Product image" />
                                                    <span className="font-semibold">{obj.title}</span>
                                                </div>
                                            </td>
                                            <td className="py-4">&#8377; {obj.price.toFixed(2)}</td>
                                            <td className="py-4">
                                                <div className="flex items-center">
                                                    <button className="border rounded-md py-2 px-4 mr-2" onClick={()=>handleDecrease(obj.key)}>-</button>
                                                    <span className="text-center w-8">{obj.quantity}</span>
                                                    <button className="border rounded-md py-2 px-4 ml-2" onClick={()=>handleIncrease(obj.key)}>+</button>
                                                </div>
                                            </td>

                                            <td className="py-4">&#8377; {(obj.price * obj.quantity).toFixed(2)}</td>
                                            <td >

                                                <svg style={{"cursor":"pointer"}}  onClick={()=> deleteCart(obj.key)} xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
    <path strokeLinecap="round" strokeLinejoin="round" d="m14.74 9-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 0 1-2.244 2.077H8.084a2.25 2.25 0 0 1-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 0 0-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 0 1 3.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 0 0-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 0 0-7.5 0" />
    </svg>
                                            </td>
                                        </tr>
                                    ))
                                }   
                                    
                            
                                
                        
                                    
                                    
                                   
                                    {/* <tr>
                                        <td className="py-4">
                                            <div className="flex items-center">
                                                <img className="h-16 w-16 mr-4" src="https://componentland.com/images/neZnfwBHi0f-4TivjA6BS.png" alt="Product image" />
                                                <span className="font-semibold">Product name</span>
                                            </div>
                                        </td>
                                        <td className="py-4">&#8377; {productPrice.toFixed(2)}</td>
                                        <td className="py-4">
                                            <div className="flex items-center">
                                                <button className="border rounded-md py-2 px-4 mr-2" onClick={handleDecrease}>-</button>
                                                <span className="text-center w-8">{quantity}</span>
                                                <button className="border rounded-md py-2 px-4 ml-2" onClick={handleIncrease}>+</button>
                                            </div>
                                        </td>
                                        <td className="py-4">&#8377; {(productPrice * quantity).toFixed(2)}</td>
                                    </tr> */}
                                    {/* More product rows */}
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div className="md:w-1/4">
                        <div className="bg-white rounded-lg shadow-md p-6">
                            <h2 className="text-lg font-semibold mb-4">Summary</h2>
                            <div className="flex justify-between mb-2">
                                <span>Subtotal</span>
                                <span>&#8377; {(productPrice * quantity).toFixed(2)}</span>
                            </div>
                            <div className="flex justify-between mb-2">
                                <span>Taxes</span>
                                <span>&#8377; {taxes.toFixed(2)}</span>
                            </div>
                            <div className="flex justify-between mb-2">
                                <span>Shipping</span>
                                <span>&#8377; {shipping.toFixed(2)}</span>
                            </div>
                            <hr className="my-2" />
                            <div className="flex justify-between mb-2">
                                <span className="font-semibold">Total</span>
                                <span className="font-semibold">&#8377; {(productPrice * quantity + taxes + shipping).toFixed(2)}</span>
                            </div>
                            <button className="bg-blue-500 text-white py-2 px-4 rounded-lg mt-4 w-full">Checkout</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Cart;
