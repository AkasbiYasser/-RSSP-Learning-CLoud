import styles from './Logo.module.css';
import logoImage from '../../assets/images/RSSPLearning.png';


function Logo() {

  return (
    <div>
      <div className={styles.container}>
        <div className={styles.logo}>
          <a href="/">
            <img src={logoImage} alt="RSSPLearning Logo" className={styles.logoImage} />
          </a>
        </div>
      </div>
    </div>
  )
}

export default Logo
