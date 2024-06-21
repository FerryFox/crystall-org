import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from "./feature/brew/HomePage.jsx";
function App() {


  return (
      <Router>
        <Routes>
          <Route path="/" element={<HomePage />} />
        </Routes>
      </Router>
  )
}

export default App