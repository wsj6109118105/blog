import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../components/Home";
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    // home页面并不需要被访问
    redirect: '/index',
    children: [
      {
        path: '/index',
        name: 'AppIndex',
        component: () => import('../components/home/AppIndex')
      },
      {
        path: '/library',
        name: 'Library',
        component: () => import('../components/Library/LibraryIndex'),
        meta: {
          requireAuth: true
        }
      },
      {
        path: '/jotter',
        name: 'Jotter',
        component: () => import('../components/Article/ArticleEditor'),
        meta: {
          requireAuth: true
        }
      },
      {
        path: '/article',
        name: 'Articles',
        component: () => import('../components/Article/Articles')
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../components/Login')
  },
  {
    path: '/articledetails',
    name: 'ArticleDetails',
    component: () => import('../components/Article/ArticleDetails')
  }
]

const router = new VueRouter({
  mode:'history',
  routes
})

export default router
