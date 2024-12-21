import styles from './About.module.css';

//images
import group from "../../assets/images/group.png";
import curve from "../../assets/images/headline-curve.svg";

import ArtTrackIcon from '@mui/icons-material/ArtTrack';
import AttachMoneyIcon from '@mui/icons-material/AttachMoney';
import LocalLibraryIcon from '@mui/icons-material/LocalLibrary';
import ContactSupportIcon from '@mui/icons-material/ContactSupport';

//components
import IconTitleCard from '../IconTitleCard/IconTitleCard';

const data = [
  {
    title: 'Facilement accessible',
    description: 'Trouver le contenu dont vous avez besoin est aussi simple qu’un clic.',
    icon: <ArtTrackIcon />,
  },
  {
    title: 'Coût plus abordable',
    description: 'Nous croyons en l’accessibilité de l’éducation pour tous.',
    icon: <AttachMoneyIcon />,
  },
  {
    title: 'Horaires d’étude flexibles',
    description: 'Que vous soyez un lève-tôt ou un oiseau de nuit, nos cours sont disponibles 24h/24 et 7j/7',
    icon: <LocalLibraryIcon />,
  },
  {
    title: 'Consultation avec un professeur',
    description: 'L’apprentissage va au-delà du contenu ; il s’agit également d’orientation et de soutien.',
    icon: <ContactSupportIcon />,
  },
]

function About() {

  return (
    <div id='about' className={styles.container}>
      <div className={styles.image}>
        <img src={group} alt='group studying' />
      </div>
      <div className={styles.info}>
        <div className={styles.title}>
          <h2><span className='blue'>Apprentissage</span> Agréable</h2>
          <img src={curve} alt='curve line' />
        </div>

        <p>Définissez la méthode d'apprentissage selon vos souhaits avec certains des avantages que vous obtenez de nous, afin que vous puissiez profiter des leçons que nous proposons.</p>

        <div className={styles.grid}>
          {data.map((value, index) => (
            <IconTitleCard key={index} icon={value.icon} title={value.title} description={value.description} />
          ))}
        </div>
      </div>
    </div>
  )
}

export default About
