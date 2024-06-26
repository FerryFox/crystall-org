import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from "./feature/brew/HomePage.jsx";
import NotFoundPage from "./feature/system/NotFoundPage.jsx";
import CenterHub from './feature/center/CenterHub.jsx';
import { CssBaseline, ThemeProvider} from "@mui/material";
import { lightTheme } from "./assets/themes/theme";
import { darkTheme } from "./assets/themes/theme";
import CaseReport from './feature/cases/CaseReport.jsx';
function App() {

return (

<div className="App">

  <CssBaseline/>
  <ThemeProvider theme={lightTheme} >
  <Router>
    <Routes>
      <Route path="*" element={<NotFoundPage />} />
      <Route path="/" element={<CenterHub />} />
      <Route path="/home" element={<HomePage />} />
      <Route path='/case' element={<CaseReport />} />
    </Routes>
  </Router>
  </ThemeProvider>

</div>
)
}

export default App