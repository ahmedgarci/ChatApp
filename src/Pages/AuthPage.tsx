import { useState } from "react";

      
      const AuthPage: React.FC = () => {
        const [username, setUsername] = useState<string>("");
      
        const handleLogin = () => {
          if (username.trim()) {
            console.log("c");
          }
        };
      
        return (
          <div className="bg-white p-6 rounded-lg shadow-md w-96">
            <h1 className="text-2xl font-bold text-gray-800 text-center mb-6">
              Welcome to Chat App
            </h1>
            <input
              type="text"
              placeholder="Enter your username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              className="w-full p-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 mb-4"
            />
            <button
              onClick={handleLogin}
              className="w-full bg-blue-500 text-white py-3 rounded-md hover:bg-blue-600 transition"
            >
              Login
            </button>
          </div>
        );
      };
      

      export default AuthPage;

