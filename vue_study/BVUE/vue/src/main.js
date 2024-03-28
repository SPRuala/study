//vue入口
//从vue中引入createApp 目的是在创建应用实例
import { createApp } from 'vue'
import App from './App.vue'

//创建应用实例
//在一个项目中 有且只有一个vue的实例对象
//App：根组件
const app=createApp(App)
    //必须要执行挂载根容器（挂载应用） 挂载到容器中后才可以在浏览器执行
    //挂载的#app是index.html文件里一个div的id  日后vue所有内容都将放在此div中呈现 浏览器中所有内容都在div id=app的标签内被渲染  index.html是真正的入口
    //浏览器可执行文件：html、css、js、image
    //vue构建工具：vite（进行打包、发布等操作） vue代码都会被编译成main.js
    app.mount('#app')

//assets文件夹：存放公共资源 公共css、图片等
