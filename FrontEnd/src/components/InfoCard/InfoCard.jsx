import styles from "./InfoCard.module.css";

//utils
import {formatNumber} from "../../utils/helpers";

function InfoCard({data}) {

  return ( 
    <div className={styles.container}>
      <div>
        <p>{formatNumber(data[0].value)}+</p>
        <p>{data[0].text}</p>
      </div>
      <div>
      <p>{formatNumber(data[1].value)}+</p>
        <p>{data[1].text}</p>
      </div>
      <div>
      <p>{formatNumber(data[2].value)}+</p>
        <p>{data[2].text}</p>
      </div>
    </div>
  )
}

export default InfoCard
