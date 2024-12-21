import styles from "./Newsletter.module.css";
import { useState } from "react";

function Newsletter() {
  const [phone, setPhone] = useState("");

  const handleSubmit = ()=>
  {
    alert("saving: "+phone);
  }

  return (
    <div id="newsletter" className={styles.container}>
      <div className={styles.background}>
        <h2>Abonnez-vous à notre newsletter</h2>
        <p>Abonnez-vous à notre newsletter pour obtenir des informations sur nos cours.</p>

        <div className={styles.details}>
          <div className={styles.input}>
            <input type="number" name="phone" placeholder="Entrez votre numéro de téléphone" onChange={(e)=>setPhone(e.target.value)}/>
          </div>
          <button onClick={handleSubmit}>Abonnez-vous</button>
        </div>
      </div>
    </div>
  )
}

export default Newsletter
