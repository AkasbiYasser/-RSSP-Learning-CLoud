import styles from "./StateCard.module.css";
import { useState } from "react";

function StateCard({ title, number, logo, color }) {
  return (
    <div className={styles.container} style={{ backgroundColor: color }}>
      <div>
        <p className={styles.number}>{number}</p>
        <p className={styles.title}>{title}</p>
      </div>
      <div className={styles.logo}>{logo}</div>
    </div>
  )
}

export default StateCard
