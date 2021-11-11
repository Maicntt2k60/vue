import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify';
import VueCookie from 'vue-cookie';
import VueSocketIO from 'vue-socket.io';

Vue.use(VueCookie);
Vue.config.productionTip = false
Vue.use(new VueSocketIO({
    debug: true,
    connection: 'http://192.168.55.240:8000',
}));
new Vue({
    router,
    vuetify,
    render: h => h(App)
}).$mount('#app')
