import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue';
import Products from '../components/Products.vue';

Vue.use(VueRouter)
const routes = [
    {
        path: '/',
        name: 'home',
        component: Home
    },
    {
        path: '/4',
        name: 'products',
        component: Products
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  })
  
  export default router