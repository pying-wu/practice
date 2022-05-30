import {
  createRouter,
  createWebHistory
} from 'vue-router';

const routes = [{
    path: '/index',
    name: '首頁',
    meta: {
      title: ''
    },
    component: () => import('../views/Index.vue')
  },
  {
    path: '/login',
    name: '登入',
    meta: {
      title: ''
    },
    component: () => import('../views/login/Login.vue')
  },
  {
    path: '/login/success',
    name: '登入成功',
    meta: {
      title: '登入'
    },
    component: () => import('../views/login/LoginSuccess.vue')
  },
  {
    path: '/register',
    name: '註冊',
    meta: {
      title: '登入'
    },
    component: () => import('../views/register/Register.vue')
  },
  {
    path: '/register/success',
    name: '註冊成功',
    meta: {
      title: '註冊'
    },
    component: () => import('../views/register/RegisterSuccess.vue')
  },
  {
    path: '/login/forgot',
    name: '忘記密碼',
    meta: {
      title: '登入'
    },
    component: () => import('../views/forgot/ForgotPassword.vue')
  },
  {
    path: '/login/forgot/success',
    name: '寄送密碼',
    meta: {
      title: '登入'
    },
    component: () => import('../views/forgot/ForgotSendSuccess.vue')
  },
  {
    path: '/login/forgot/reset',
    name: '重設密碼',
    meta: {
      title: '登入'
    },
    component: () => import('../views/forgot/ResetPassword.vue')
  },
  {
    path: '/login/forgot/reset/success',
    name: '重設密碼成功',
    meta: {
      title: '登入'
    },
    component: () => import('../views/forgot/ResetPasswordSuccess.vue')
  },
  {
    path: '/authorized/1',
    name: '授權一',
    meta: {
      title: '授權項目'
    },
    component: () => import('../views/authorized/Authorized1.vue'),

  },
  {
    path: '/authorized/2',
    name: '授權二',
    meta: {
      title: '授權項目'
    },
    component: () => import('../views/authorized/Authorized2.vue')
  },
  {
    path: '/authorized/3',
    name: '授權三',
    meta: {
      title: '授權項目'
    },
    component: () => import('../views/authorized/Authorized3.vue')
  },
  {
    path: '/role/1',
    name: '角色一',
    meta: {
      title: '角色'
    },
    component: () => import('../views/role/Role1.vue')
  },
  {
    path: '/role/2',
    name: '角色二',
    meta: {
      title: '角色'
    },
    component: () => import('../views/role/Role2.vue')
  },
  {
    path: '/role/3',
    name: '角色三',
    meta: {
      title: '角色'
    },
    component: () => import('../views/role/Role3.vue')
  },
  {
    path: '/user/1',
    name: '使用一',
    meta: {
      title: '使用'
    },
    component: () => import('../views/user/User1.vue')
  },
  {
    path: '/user/2',
    name: '使用二',
    meta: {
      title: '使用'
    },
    component: () => import('../views/user/User2.vue')
  },
  {
    path: '/user/3',
    name: '使用三',
    meta: {
      title: '使用'
    },
    component: () => import('../views/user/User3.vue')
  },
  {
    path: '/activity/1',
    name: '活動一',
    meta: {
      title: '活動紀錄'
    },
    component: () => import('../views/activity/Activity1.vue')
  },
  {
    path: '/activity/2',
    name: '活動二',
    meta: {
      title: '活動紀錄'
    },
    component: () => import('../views/activity/Activity2.vue')
  },
  {
    path: '/activity/3',
    name: '活動三',
    meta: {
      title: '活動紀錄'
    },
    component: () => import('../views/activity/Activity3.vue')
  }
]

// const routes = [
//   {
//       path: '/index',
//       name: '首頁',
//       component: Index
//   },
//   {
//       path: '/login',
//       name: '登入',
//       component: Login,
//       children: [{
//           path: 'register',
//           name: '註冊',
//           component: () => import('../views/register/Register.vue')
//       }]
//   },
//   {
//       path: '/user',
//       name: '使用',
//       children: [{
//               path: '1',
//               name: '使用一',
//               component: () => import('../views/user/user1.vue')
//           },
//           {
//               path: '2',
//               name: '使用二',
//               component: user2
//           },
//           {
//               path: '3',
//               name: '使用三',
//               component: user3
//           }
//       ]
//   },
//   {
//       path: '/authorized',
//       name: '授權項目',
//       children: [{
//               path: '1',
//               name: '授權一',
//               component: authorized1,

//           },
//           {
//               path: '2',
//               name: '授權二',
//               component: authorized2
//           },
//           {
//               path: '3',
//               name: '授權三',
//               component: authorized3
//           },
//       ]
//   },
//   {
//       path: '/role',
//       name: '角色',
//       children: [{
//               path: '1',
//               name: '角色一',
//               component: role1
//           },
//           {
//               path: '2',
//               name: '角色二',
//               component: role2
//           },
//           {
//               path: '3',
//               name: '角色三',
//               component: role3
//           },
//       ]
//   },
//   {
//       path: '/login/success',
//       name: '登入成功',
//       component: LoginSuccess
//   },
//   {
//       path: '/register/success',
//       name: 'registerSuccess',
//       component: RegisterSuccess
//   }
// ];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

// router.beforeEach((to, from, next) => {
//   const isLogin = localStorage.getItem('token');
//   if (isLogin) {
//     next();
//     if (to.path == '/login') {
//       alert('已登入');
//       next('/');
//     } else {
//       if (to.path !== '/login' && to.path !== '/') {
//         next('/login');
//       } else {
//         next();
//       }
//     }
//   }
// })

export default router;