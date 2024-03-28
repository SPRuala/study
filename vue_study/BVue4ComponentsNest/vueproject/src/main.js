

import { createApp } from 'vue'
import App from './App.vue'
import Header from "./pages/Header.vue";

//组件全局注册
const app =createApp(App)
//在这中间写组件的注册
//写法：app.component(为组件起的名 引用时使用,对应的组件)
app.component("Header",Header)

app.mount('#app')

//全局注册缺点：就算没被使用到的组件后续打包程序的时候也会被打包到项目中
//            无法明确子级父级关系
//            不方便传参