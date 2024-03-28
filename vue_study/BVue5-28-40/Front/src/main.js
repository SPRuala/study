

import { createApp } from 'vue'
import App from './App.vue'

const app=createApp(App)

//使用provide提供全局数据，写法：app.provide("起的名字","内容")
//全局数据可以在任何一个组件中被拿到
app.provide("globaldata","这是全局数据")
app.mount('#app')

