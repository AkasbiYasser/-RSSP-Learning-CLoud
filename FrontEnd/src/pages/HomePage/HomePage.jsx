import styles from "./HomePage.module.css";

//components
import Home from '../../components/Home/Home';
import Course from '../../components/Course/Course';
import About from '../../components/About/About';
import Newsletter from '../../components/Newsletter/Newsletter';

function HomePage() {
  
  return (
    <>
      <Home />
      <Course />
      <About />
      <Newsletter />
    </>
  )
}

export default HomePage