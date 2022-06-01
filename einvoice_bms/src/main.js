import {
    createApp
} from 'vue';
import App from './App.vue';
import router from './router';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";
import VueCookies from 'vue3-cookies';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';

import {library} from '@fortawesome/fontawesome-svg-core';
import {faEye} from '@fortawesome/free-solid-svg-icons';
import {faEyeSlash} from '@fortawesome/free-solid-svg-icons';
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome';

library.add(faEye);
library.add(faEyeSlash);
createApp(App).use(VueCookies).use(router).use(ElementPlus).component('font-awesome-icon', FontAwesomeIcon).mount('#app');

//  Vue.createApp(App).use(VueCookies).use(router).use(ElementPlus).mount('#app');