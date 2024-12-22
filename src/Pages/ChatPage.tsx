import React, { useState } from "react";


const ChatPage:React.FC = ()=>{
    return(
            <div className="flex h-screen">
  <div className="w-1/4 bg-gray-100 border-r">
    <div className="p-4 border-b">
      <h2 className="text-xl font-bold">ChatApp</h2>
    </div>
    <ul className="mt-4">
      <li className="p-4 hover:bg-gray-200 cursor-pointer">User 1</li>
      <li className="p-4 hover:bg-gray-200 cursor-pointer">User 2</li>
      <li className="p-4 hover:bg-gray-200 cursor-pointer">User 3</li>
    </ul>
  </div>

  <div className="flex-1 flex flex-col">
    <div className="p-4 bg-gray-100 border-b flex items-center justify-between">
      <h3 className="text-lg font-semibold">Chat with User 1</h3>
      <button className="bg-red-500 text-white px-4 py-1 rounded hover:bg-red-600">
        Logout
      </button>
    </div>

    <div className="flex-1 overflow-y-auto p-4 bg-gray-50">
      <div className="mb-4">
        <p className="text-sm text-gray-500">User 1, 10:15 AM</p>
        <div className="bg-blue-500 text-white p-2 rounded w-fit">
          Hi there!
        </div>
      </div>
      <div className="mb-4 text-right">
        <p className="text-sm text-gray-500">You, 10:16 AM</p>
        <div className="bg-gray-200 text-gray-800 p-2 rounded w-fit ml-auto">
          Hello! How are you?
        </div>
      </div>
    </div>

    <div className="p-4 bg-gray-100 border-t flex items-center">
      <input
        type="text"
        placeholder="Type a message..."
        className="flex-1 border p-2 rounded-l focus:outline-none focus:ring-2 focus:ring-blue-500"
      />
      <button className="bg-blue-500 text-white px-4 py-2 rounded-r hover:bg-blue-600">
        Send
      </button>
    </div>
  </div>
</div>

    )
}

export {ChatPage}