import React, { useState } from 'react';

const Cart = () => {
    const [quantity, setQuantity] = useState(1);
    const productPrice = 19.99;
    const taxes = 1.99;
    const shipping = 0.00;
    
    const handleDecrease = () => {
        if (quantity > 1) {
            setQuantity(quantity - 1);
        }
    };

    const handleIncrease = () => {
        setQuantity(quantity + 1);
    };

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
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td className="py-4">
                                            <div className="flex items-center">
                                                <img className="h-16 w-16 mr-4" src="https://componentland.com/images/7ObHe1EuFqmsZmri6-ROD.png" alt="Product image" />
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
                                    </tr>

                                    <tr>
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
                                    </tr>
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
