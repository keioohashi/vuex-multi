import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'GoodsList',
    component: () => import('../views/GoodsList.vue')
  },
  {
    path: '/regist',
    name: 'RegistGoods',
    component: () => import('../views/RegistGoods.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
