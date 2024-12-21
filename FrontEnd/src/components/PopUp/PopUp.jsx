import styles from './PopUp.module.css';

function PopUp({title, description, OK, CANCEL}) {

  return (
    <div className={styles.container}>
      <div className={styles.card}>
        <h2 className={styles.cardTitle}>{title}</h2>
        <p className={styles.cardDescription}>{description}</p>
        <div className={styles.cardButtons}>
          <button className={styles.cardOK} onClick={OK}>{CANCEL ? "Oui" : "OK"}</button>
          {CANCEL &&
          <button className={styles.cardCancel} onClick={CANCEL}>Annuler</button>}
        </div>
      </div>
    </div>
  )
}

export default PopUp
