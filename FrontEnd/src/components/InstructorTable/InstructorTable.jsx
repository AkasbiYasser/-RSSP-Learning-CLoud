import React from 'react';
import styles from './InstructorTable.module.css';

const InstructorTable = ({ data, onEdit, onDelete }) => {
    return (
        <table className={styles.container}>
            <thead>
                <tr>
                    <th>Nom et Prénom </th>
                    <th>Profession</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{`${item.firstName} ${item.lastName}`}</td>
                        <td>{item.profession}</td>
                        <td className={styles.action}>
                            <button onClick={() => onEdit(item)}>Modifier</button>
                            <button className='btn-warning' onClick={() => onDelete(item.id)}>Supprimer</button>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
};

export default InstructorTable;
