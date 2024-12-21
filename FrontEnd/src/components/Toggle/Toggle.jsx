import styles from './Toggle.module.css';

export default function Toggle({ pressed, onPressedChange, children }) {
    return (
        <div className={`${styles.container} ${pressed ? styles.bold : ''}`}
            onClick={onPressedChange}>
            {children}
        </div>
    );
}