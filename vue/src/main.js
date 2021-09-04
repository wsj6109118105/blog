import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import 'mavon-editor/dist/css/index.css'
import mavonEditor from 'mavon-editor'

Vue.config.productionTip = false
//let axios = require('axios')
axios.defaults.baseURL='http://localhost:8088'
Vue.prototype.$ajax = axios
axios.defaults.withCredentials = true
Vue.use(mavonEditor)

router.beforeEach((to, from, next) => {
      if (to.meta.requireAuth) {
        if (store.state.user.username) {
          next()
        } else {
          next({
            path: 'login',
            query: {redirect: to.fullPath}
          })
        }
      } else {
        next()
      }
    }
)
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
