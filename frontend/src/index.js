import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import Layout from "./Layout";
import Actual from "./Actual";
import Forecast from "./Forecast";
import Login from "./Login";
import Register from "./Register";
import Location from "./Location";
import reportWebVitals from "./reportWebVitals";
import "../node_modules/font-awesome/css/font-awesome.min.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";

export default function App() {
	return (
		<BrowserRouter>
			<Routes>
				<Route exact path="/" element={<Layout />}>
					<Route index element={<Login />} />
					{/* <Route index element={<Login />} /> */}

					<Route path="forecast" element={<Forecast />} />
					<Route path="actual" element={<Actual />} />

					<Route path="location" element={<Location />} />
					<Route path="login" element={<Login />} />
					<Route path="register" element={<Register />} />
					{/* <Route path="*" element={<NoPage />} /> */}
				</Route>
			</Routes>
		</BrowserRouter>
	);
}

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(<App />);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
