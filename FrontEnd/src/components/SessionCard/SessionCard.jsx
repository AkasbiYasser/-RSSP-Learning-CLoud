import styles from "./SessionCard.module.css";
import { useState } from "react";

//utils
import { checkDateRange } from "../../utils/helpers";

//images
import placeholder from "../../assets/images/placeholder.png";

//components
import Status from "../Status/Status";

function SessionCard({ course, pressed }) {
  const { id, title, mainImagePath, price, categoryName, description, startDate, endDate, rating, url } = course;

  return (
    <div className={styles.container} onClick={pressed}>
      <div className={styles.image}>
        <img src={mainImagePath ? mainImagePath : placeholder} alt="course image" />
      </div>
      <div className={styles.info}>
        <h4>{title}</h4>
        <p className={styles.courseCategory}>{categoryName}</p>
        <div className={styles.status}>
          <Status status={checkDateRange(startDate, endDate)} />
        </div>
      </div>
    </div>
  )
}

export default SessionCard
