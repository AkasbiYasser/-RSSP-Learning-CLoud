import styles from './Home.module.css';
import { useState } from 'react';

//images
import pc from "../../assets/images/pc.png";
import curve from "../../assets/images/headline-curve.svg";

//components
import InfoCard from '../InfoCard/InfoCard';

function Home() {

  const data = [
    {
      text: "Étudiants",
      value: 500
    },
    {
      text: "Cours de qualité",
      value: 20
    },
    {
      text: "Professeurs expérimentés",
      value: 10
    }
  ];

  return (
    <div id='home'>
      <div className={styles.container}>
        <div className={styles.info}>
          <div className={styles.title}>
            <h1><span className='blue'>Améliorez</span> vos compétences</h1>
            <img src={curve} alt='curve line' />
          </div>
          <h1>de différentes manières</h1>
          <p>Prenons un cours en ligne pour améliorer vos compétences d’une manière différente. Vous pouvez définir votre propre temps d’étude en fonction de votre rythme d’apprentissage. Ainsi, vous pouvez étudier confortablement et assimiler facilement le matériel.</p>
          <div className={styles.buttons}>
            <a href="/courses">
              <button>Commencer</button>
            </a>
          </div>
        </div>
        <div className={styles.image}>
          <img src={pc} alt='pc' />
        </div>
      </div>

      <div className={styles.infoCard}>
        <InfoCard data={data}/>
      </div>
    </div>
  )
}

export default Home
