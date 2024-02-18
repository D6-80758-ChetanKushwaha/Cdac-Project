import React, { useState } from 'react';

const Carousel = () => {
  const [activeIndex, setActiveIndex] = useState(0);

  const handlePrevClick = () => {
    setActiveIndex((prevIndex) => (prevIndex === 0 ? 2 : prevIndex - 1));
  };

  const handleNextClick = () => {
    setActiveIndex((prevIndex) => (prevIndex === 2 ? 0 : prevIndex + 1));
  };

  return (
    <div
      id="carouselExampleIndicators"
      className="relative"
      data-te-carousel-init
      data-te-ride="carousel"
      style={{width: '75%', height: '50%', alignContent: 'center', marginLeft:"13%"}}
    >


      <div className="relative w-full overflow-hidden after:clear-both after:block after:content-['']">

        <div
          className={`relative float-left ${
            activeIndex === 0 ? '' : '-mr-[100%] hidden'
          } w-full transition-transform duration-[600ms] ease-in-out motion-reduce:transition-none`}
          data-te-carousel-item
          data-te-carousel-active={activeIndex === 0}
        >

          <img
            src="https://food-ubc.b-cdn.net/wp-content/uploads/2020/02/Save-Money-On-Groceries_UBC-Food-Services.jpg"
            className="block w-full"
            alt="Wild Landscape"
          />
        </div>

        <div
          className={`relative float-left ${
            activeIndex === 1 ? '' : '-mr-[100%] hidden'
          } w-full transition-transform duration-[600ms] ease-in-out motion-reduce:transition-none`}
          data-te-carousel-item
          data-te-carousel-active={activeIndex === 1}
        >

          <img
            src="https://assets.aboutamazon.com/dims4/default/d573e3b/2147483647/strip/false/crop/1320x743+0+0/resize/1320x743!/quality/90/?url=https%3A%2F%2Famazon-blogs-brightspot.s3.amazonaws.com%2F92%2F06%2Fbb204a6842a49e7bdc66523a070c%2Fblog2.jpg"
            className="block w-full"
            alt="Camera"
          />
        </div>

        <div
          className={`relative float-left ${
            activeIndex === 2 ? '' : '-mr-[100%] hidden'
          } w-full transition-transform duration-[600ms] ease-in-out motion-reduce:transition-none`}
          data-te-carousel-item
          data-te-carousel-active={activeIndex === 2}
        >
          <img
            src="https://mdbcdn.b-cdn.net/img/new/slides/043.webp"
            className="block w-full"
            alt="Exotic Fruits"
          />
        </div>
      </div>

      <button
        className="absolute bottom-0 left-0 top-0 z-[1] flex w-[15%] items-center justify-center border-0 bg-none p-0 text-center text-white opacity-50 transition-opacity duration-150 ease-[cubic-bezier(0.25,0.1,0.25,1.0)] hover:text-white hover:no-underline hover:opacity-90 hover:outline-none focus:text-white focus:no-underline focus:opacity-90 focus:outline-none motion-reduce:transition-none"
        type="button"
        onClick={handlePrevClick}
      >
      </button>

      <button
        className="absolute bottom-0 right-0 top-0 z-[1] flex w-[15%] items-center justify-center border-0 bg-none p-0 text-center text-white opacity-50 transition-opacity duration-150 ease-[cubic-bezier(0.25,0.1,0.25,1.0)] hover:text-white hover:no-underline hover:opacity-90 hover:outline-none focus:text-white focus:no-underline focus:opacity-90 focus:outline-none motion-reduce:transition-none"
        type="button"
        onClick={handleNextClick}
      >

      </button>
    </div>
  );
};

export default Carousel;
