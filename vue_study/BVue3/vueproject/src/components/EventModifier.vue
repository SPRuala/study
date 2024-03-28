<template>
<h2>9.事件修饰符</h2>
  阻止默认事件
<!-- 在点击链接的时候不跳转并打印控制台 -->
<!-- 在方法中阻止（使用event对象） -->
  <p @click="StopEventAndPrint"><a href="https://cn.vuejs.org/guide/essentials/event-handling.html#event-modifiers">事件修饰符官网</a></p>
<!--使用事件修饰符阻止-->
  <p @click.prevent="StopEventAndPrint2"><a href="https://cn.vuejs.org/guide/essentials/event-handling.html#event-modifiers">事件修饰符官网</a></p>

  事件冒泡
<!-- 事件冒泡：触发子元素事件的同时，也触发了父元素事件 -->
  <div @click="divEvent">
    <p @click="pEvent">
      测试事件冒泡
    </p>
  </div>
<!-- 阻止事件冒泡 （阻止p冒到div） -->
  <div @click="divEvent">
    <p @click.stop="pEvent">
      阻止事件冒泡
    </p>
  </div>
</template>

<script>
export default {
  data(){
    return{

    }
  },
  methods:{
    StopEventAndPrint(e){
      //阻止默认事件
      e.preventDefault();
      console.log("成功用event对象阻止跳转超链接")
    },
    StopEventAndPrint2(){
      //阻止默认事件
      console.log("成功用修饰符阻止跳转超链接")
    },
    divEvent(){
      console.log("触发div事件");
    },
    pEvent(){
      console.log("触发p事件")
    }
  }

}
</script>

<style scoped>

</style>