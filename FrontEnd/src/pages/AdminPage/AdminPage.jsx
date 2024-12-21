import styles from './AdminPage.module.css';
import { useNavigate, Outlet } from "react-router-dom";
import Cookies from "js-cookie";

//images
import logoImage from '../../assets/images/RSSPLearning.png';
import { useEffect } from 'react';

export default function AdminPage() {
  const navigate = useNavigate();

  const handleNavigate = (path) => {
    navigate(path);
  };

  const handleLogout = () => {
    Cookies.remove("user");
    navigate("/login");
  }

  const GetCookie = (key) => {
    const cookieValue = Cookies.get(key);

    try {
      const jsonValue = JSON.parse(cookieValue);
      return jsonValue;
    } catch (e) {
      console.error("Cookie value is not valid JSON", e);
      return false;
    }
  };

  useEffect(() => {
    const user = GetCookie('user');
    if (!user.admin) {
      navigate("/login");
    }
  }, []);

  return (
      <div>
      <div className={styles.container}>
        <div className={styles.navbar}>
          <a href="/admin">
          <img src={logoImage} alt="RSSPLearning Logo" className={styles.logoImage} />
          </a>
          <button className="btn-v2" onClick={handleLogout}>Se déconnecter</button>
        </div>

        <div className={styles.body}>
          <h2>Admin</h2>
          <div className={styles.bodyContainer}>
            <div className={styles.sidebar}>
              <ul>
                <a href="/admin"><li>Dashboard</li></a>
                <a href="/admin/courses"><li>Cours</li></a>
                <a href="/admin/categories"><li>Catégories</li></a>
                <a href="/admin/instructors"><li>Instructeurs</li></a>
              </ul>
            </div>
            {/* outlet */}
            <div className={styles.outlet}>
              <Outlet />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}