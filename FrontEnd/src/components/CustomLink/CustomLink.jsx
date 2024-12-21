import styles from "./CustomLink.module.css";
import { useState } from 'react';

//images
import curve from "../../assets/images/headline-curve.svg";

function CustomLink({href, children}) {
  const [isImageVisible, setImageVisible] = useState(false);
  
  return (
    <div className={styles.container}>
      <a href={href} 
         onMouseEnter={() => setImageVisible(true)}
         onMouseLeave={() => setImageVisible(false)}>
        {children}
      </a>
      {isImageVisible && (
        <img src={curve} alt="curve line" />
      )}
    </div>
  )
}

export default CustomLink
