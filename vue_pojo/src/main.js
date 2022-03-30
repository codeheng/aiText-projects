import Vue from 'vue'
import App from './App.vue'
import router from './router'
//引入elementUI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
//引入utils
import request from "@/utils/request"
//引入vuex
import store from './store'

//引入自己设置的css
import './assets/global.css'

Vue.config.productionTip = false

Vue.use(ElementUI,{size:"small"}) //使用elementUI
//使用utils中的request
Vue.prototype.request = request  //在home.vue通过this.request进行访问
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
