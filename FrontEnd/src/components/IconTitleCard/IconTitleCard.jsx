import styles from "./IconTitleCard.module.css";

function IconTitleCard({icon, title, description}) {

  return ( 
    <div className={styles.container}>
      <div className={styles.icon}>
        {icon}
      </div>
      <div className={styles.info}>
        <h4>{title}</h4>
        <p>{description}</p>
      </div>
    </div>
  )
}

export default IconTitleCard
