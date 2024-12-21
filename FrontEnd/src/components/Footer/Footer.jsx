import { useState } from 'react';
import styles from "./Footer.module.css";

//images
import instagram from "../../assets/images/icons/instagram.svg";
import github from "../../assets/images/icons/github.svg";
import twitter from "../../assets/images/icons/twitter.svg";
import youtube from "../../assets/images/icons/youtube.svg";

function Footer() {

  return (
    <div className={styles.container}>
      <div className={styles.about}>
        <div className={styles.info}>
        <h2>RSSPLearning</h2>
          <p>RSSPLearning est une plateforme d'apprentissage en ligne qui aide les étudiants à trouver des cours de qualité, adaptés à leurs besoins et à leur rythme, afin de faciliter leur réussite académique.</p>
        </div>
        <div className={styles.social}>
          <ul>
            <li><a href="#"><img src={instagram} alt='instagram'/></a></li>
            <li><a href="#"><img src={github} alt='github'/></a></li>
            <li><a href="#"><img src={twitter} alt='twitter'/></a></li>
            <li><a href="#"><img src={youtube} alt='youtube'/></a></li>
          </ul>
        </div>
      </div>

      <div className={styles.more}>
        <div>
          <h3>Cours</h3>
          <ul>
            <li><a href='/courses/Cloud Computing'>Cloud Computing</a></li>
            <li><a href='/courses/DevOps'>DevOps</a></li>
            <li><a href='/courses/Réseau'>Réseau</a></li>
            <li><a href='/courses/AI & ML'>AI & ML</a></li>
            <li><a href='/courses/Développement web'>Développement web</a></li>
          </ul>
        </div>
        <div>
          <h3>Menu</h3>
          <ul>
            <li><a href='/#home'>Accueil</a></li>
            <li><a href='/#courses'>Cours</a></li>
            <li><a href='/#about'>À propos</a></li>
          </ul>
        </div>
      </div>
    </div>
  )
}

export default Footer
