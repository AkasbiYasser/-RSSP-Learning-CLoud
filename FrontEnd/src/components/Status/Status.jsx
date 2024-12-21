import styles from './Status.module.css';

export default function Status({status}) {
    const values = ['au départ', 'à venir', 'conclu']; 
    const colors = ['--alert-green', '--alert-yellow', '--alert-red']; 
    return (
        <div className={styles.container} style={{backgroundColor: `var(${colors[status-1]})`}}>
            {values[status-1]}
        </div>
    );
}