import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import { createBrowserRouter, RouterProvider } from "react-router-dom";

//Pages
import LoginPage from './pages/LoginPage/LoginPage.jsx';
import RegisterPage from './pages/RegisterPage/RegisterPage.jsx';
import ProfilePage from './pages/ProfilePage/ProfilePage.jsx';
import CoursesPage from './pages/CoursesPage/CoursesPage.jsx';
import CoursePage from './pages/CoursePage/CoursePage.jsx';
import SessionsPage from './pages/SessionsPage/SessionsPage.jsx';
import SessionPage from './pages/SessionPage/SessionPage.jsx';
import ErrorPage from "./pages/ErrorPage/ErrorPage.jsx";
import AdminPage from "./pages/AdminPage/AdminPage.jsx";
import CoursesAdmin from './components/CoursesAdmin/CoursesAdmin.jsx';
import DashboardAdmin from './components/DashboardAdmin/DashboardAdmin.jsx';
import CategoriesAdmin from './components/CategoriesAdmin/CategoriesAdmin.jsx';
import InstructorsAdmin from './components/InstructorsAdmin/InstructorsAdmin.jsx';

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <ErrorPage />,
  },
  {
    path: "login",
    element: <LoginPage />,
  },
  {
    path: "register",
    element: <RegisterPage />,
  },
  {
    path: "admin",
    element: <AdminPage />,
    children: [
      {
        path: "",
        element: <DashboardAdmin />,
      },
      {
        path: "courses",
        element: <CoursesAdmin />,
      },
      {
        path: "categories",
        element: <CategoriesAdmin />,
      },
      {
        path: "instructors",
        element: <InstructorsAdmin />,
      },
    ]
  },
  {
    path: "profile",
    element: <ProfilePage />,
  },
  {
    path: "courses",
    element: <CoursesPage />,
  },
  {
    path: "courses/:category",
    element: <CoursesPage />,
  },
  {
    path: "courses/:category/:id",
    element: <CoursePage />,
  },
  {
    path: "sessions",
    element: <SessionsPage />,
  },
  {
    path: "session/:id",
    element: <SessionPage />,
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)