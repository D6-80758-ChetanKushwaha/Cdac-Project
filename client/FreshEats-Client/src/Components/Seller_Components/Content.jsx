

function Content() {
    return (
        <div>
            Hello
        </div>
        // <div class="w-full overflow-x-hidden border-t flex flex-col">
        //     <main class="w-full flex-grow p-6">
        //         <h1 class="text-3xl text-black pb-6">Dashboard</h1>
    
        //         <div class="flex flex-wrap mt-6">
        //             <div class="w-full lg:w-1/2 pr-0 lg:pr-2">
        //                 <p class="text-xl pb-3 flex items-center">
        //                     <svg class="svg-inline--fa fa-plus fa-w-14 mr-3" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="plus" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" data-fa-i2svg=""><path fill="currentColor" d="M416 208H272V64c0-17.67-14.33-32-32-32h-32c-17.67 0-32 14.33-32 32v144H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h144v144c0 17.67 14.33 32 32 32h32c17.67 0 32-14.33 32-32V304h144c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z"></path></svg>
        //                     {/* <!-- <i class="fas fa-plus mr-3"></i> --> Monthly Reports */}
        //                 </p>
        //                 <div class="p-6 bg-white"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
        //                     <canvas id="chartOne" width="523" height="261" class="chartjs-render-monitor" style="display: block; width: 523px; height: 261px;"></canvas>
        //                 </div>
        //             </div>
        //             <div class="w-full lg:w-1/2 pl-0 lg:pl-2 mt-12 lg:mt-0">
        //                 <p class="text-xl pb-3 flex items-center">
        //                     <svg class="svg-inline--fa fa-check fa-w-16 mr-3" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="check" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg=""><path fill="currentColor" d="M173.898 439.404l-166.4-166.4c-9.997-9.997-9.997-26.206 0-36.204l36.203-36.204c9.997-9.998 26.207-9.998 36.204 0L192 312.69 432.095 72.596c9.997-9.997 26.207-9.997 36.204 0l36.203 36.204c9.997 9.997 9.997 26.206 0 36.204l-294.4 294.401c-9.998 9.997-26.207 9.997-36.204-.001z"></path></svg>
        //                     {/* <!-- <i class="fas fa-check mr-3"></i> --> Resolved Reports */}
        //                 </p>
        //                 <div class="p-6 bg-white"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
        //                     <canvas id="chartTwo" width="523" height="261" class="chartjs-render-monitor" style="display: block; width: 523px; height: 261px;"></canvas>
        //                 </div>
        //             </div>
        //         </div>
    
        //         <div class="w-full mt-12">
        //             <p class="text-xl pb-3 flex items-center">
        //                 <svg class="svg-inline--fa fa-list fa-w-16 mr-3" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="list" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg=""><path fill="currentColor" d="M80 368H16a16 16 0 0 0-16 16v64a16 16 0 0 0 16 16h64a16 16 0 0 0 16-16v-64a16 16 0 0 0-16-16zm0-320H16A16 16 0 0 0 0 64v64a16 16 0 0 0 16 16h64a16 16 0 0 0 16-16V64a16 16 0 0 0-16-16zm0 160H16a16 16 0 0 0-16 16v64a16 16 0 0 0 16 16h64a16 16 0 0 0 16-16v-64a16 16 0 0 0-16-16zm416 176H176a16 16 0 0 0-16 16v32a16 16 0 0 0 16 16h320a16 16 0 0 0 16-16v-32a16 16 0 0 0-16-16zm0-320H176a16 16 0 0 0-16 16v32a16 16 0 0 0 16 16h320a16 16 0 0 0 16-16V80a16 16 0 0 0-16-16zm0 160H176a16 16 0 0 0-16 16v32a16 16 0 0 0 16 16h320a16 16 0 0 0 16-16v-32a16 16 0 0 0-16-16z"></path></svg>
        //                 {/* <!-- <i class="fas fa-list mr-3"></i> --> Latest Reports */}
        //             </p>
        //             <div class="bg-white overflow-auto">
        //                 <table class="min-w-full bg-white">
        //                     <thead class="bg-gray-800 text-white">
        //                         <tr>
        //                             <th class="w-1/3 text-left py-3 px-4 uppercase font-semibold text-sm">Name</th>
        //                             <th class="w-1/3 text-left py-3 px-4 uppercase font-semibold text-sm">Last name</th>
        //                             <th class="text-left py-3 px-4 uppercase font-semibold text-sm">Phone</th>
        //                             <th class="text-left py-3 px-4 uppercase font-semibold text-sm">Email</th>
        //                         </tr>
        //                     </thead>
        //                     <tbody class="text-gray-700">
        //                         <tr>
        //                             <td class="w-1/3 text-left py-3 px-4">Lian</td>
        //                             <td class="w-1/3 text-left py-3 px-4">Smith</td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="tel:622322662">622322662</a></td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="mailto:jonsmith@mail.com">jonsmith@mail.com</a></td>
        //                         </tr>
        //                         <tr class="bg-gray-200">
        //                             <td class="w-1/3 text-left py-3 px-4">Emma</td>
        //                             <td class="w-1/3 text-left py-3 px-4">Johnson</td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="tel:622322662">622322662</a></td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="mailto:jonsmith@mail.com">jonsmith@mail.com</a></td>
        //                         </tr>
        //                         <tr>
        //                             <td class="w-1/3 text-left py-3 px-4">Oliver</td>
        //                             <td class="w-1/3 text-left py-3 px-4">Williams</td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="tel:622322662">622322662</a></td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="mailto:jonsmith@mail.com">jonsmith@mail.com</a></td>
        //                         </tr>
        //                         <tr class="bg-gray-200">
        //                             <td class="w-1/3 text-left py-3 px-4">Isabella</td>
        //                             <td class="w-1/3 text-left py-3 px-4">Brown</td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="tel:622322662">622322662</a></td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="mailto:jonsmith@mail.com">jonsmith@mail.com</a></td>
        //                         </tr>
        //                         <tr>
        //                             <td class="w-1/3 text-left py-3 px-4">Lian</td>
        //                             <td class="w-1/3 text-left py-3 px-4">Smith</td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="tel:622322662">622322662</a></td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="mailto:jonsmith@mail.com">jonsmith@mail.com</a></td>
        //                         </tr>
        //                         <tr class="bg-gray-200">
        //                             <td class="w-1/3 text-left py-3 px-4">Emma</td>
        //                             <td class="w-1/3 text-left py-3 px-4">Johnson</td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="tel:622322662">622322662</a></td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="mailto:jonsmith@mail.com">jonsmith@mail.com</a></td>
        //                         </tr>
        //                         <tr>
        //                             <td class="w-1/3 text-left py-3 px-4">Oliver</td>
        //                             <td class="w-1/3 text-left py-3 px-4">Williams</td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="tel:622322662">622322662</a></td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="mailto:jonsmith@mail.com">jonsmith@mail.com</a></td>
        //                         </tr>
        //                         <tr class="bg-gray-200">
        //                             <td class="w-1/3 text-left py-3 px-4">Isabella</td>
        //                             <td class="w-1/3 text-left py-3 px-4">Brown</td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="tel:622322662">622322662</a></td>
        //                             <td class="text-left py-3 px-4"><a class="hover:text-blue-500" href="mailto:jonsmith@mail.com">jonsmith@mail.com</a></td>
        //                         </tr>
        //                     </tbody>
        //                 </table>
        //             </div>
        //         </div>
        //     </main>
    
        //     <footer class="w-full bg-white text-right p-4">
        //         Built by <a target="_blank" href="https://davidgrzyb.com" class="underline">David Grzyb</a>.
        //     </footer>
        // </div>
    )
}

export default Content;