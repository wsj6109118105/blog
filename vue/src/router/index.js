import Vue from 'vue'
import VueRouter from 'vue-router'
import AppIndex from "../components/home/AppIndex";
import Login from "../components/Login";
import Home from "../components/Home";
import LibraryIndex from "../components/Library/LibraryIndex";
import Jotter from '../components/Article/ArticleEditor'
import Articles from "../components/Article/Articles";
import ArticleDetails from "../components/Article/ArticleDetails";
Vue.use(VueRouter)

const routes = [
  {
    path: '/home',
    name: 'Home',
    component: Home,
    // home页面并不需要被访问
    redirect: '/index',
    children: [
      {
        path: '/index',
        name: 'AppIndex',
        component: AppIndex,
        meta: {
          requireAuth: true
        }
      },
      {
        path: '/library',
        name: 'Library',
        component: LibraryIndex,
        meta: {
          requireAuth: true
        }
      },
      {
        path: '/jotter',
        name: 'Jotter',
        component: Jotter,
      },
      {
        path: '/article',
        name: 'Articles',
        component: Articles
      },
      {
        path: '/articledetails',
        name: 'ArticleDetails',
        component: ArticleDetails
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  }
]

const router = new VueRouter({
  mode:'history',
  routes
})

export default router
