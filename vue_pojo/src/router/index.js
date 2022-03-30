import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Manage.vue'
import store from "@/store";

Vue.use(VueRouter)

const routes = [
  //  配置路由 <==创建views下的test.vue
  {
    path: '/test',
    name: 'test',
    component: () => import(/* webpackChunkName: "about" */ '../views/Test.vue'),
  },
  {
    path: '/',
    name: 'Manage',
    component: () => import(/* webpackChunkName: "about" */ '../views/Manage.vue'),
    redirect: "/home",
    children: [
      {
        path: 'home',
        name: '主页',
        component: () => import(/* webpackChunkName: "about" */ '../views/Home.vue')
      },
      {
        // 里面路由和外面进行拼接
        path: 'user',
        name: '用户管理',
        component: () => import(/* webpackChunkName: "about" */ '../views/User.vue')
      },
      {
        // 个人信息页面
        path: 'person',
        name: '个人信息',
        component: () => import(/* webpackChunkName: "about" */ '../views/Person.vue')
      }
    ]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
    // 登陆的路由
  {
    path:'/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  // 注册的路由
  {
    path:'/register',
    name: 'Register',
    component: () => import('../views/Register.vue')
  },
  {
    path:'/front',
    name: 'Front',
    component: () => import('../views/front/Front'),
    children: [
      {
        path: 'home',
        name: 'FrontHome',
        component: () => import('../views/front/Home')
      }

    ],
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
// 路由守卫，获得路由信息
router.beforeEach((to, from, next) => {
  localStorage.setItem("currentPathName",to.name)  //设置当前路由的名称,为了在Header组件中使用
  store.commit("setPath") //触发store数据更新
  next() //进行放行，不然页面不加载
})

export default router
