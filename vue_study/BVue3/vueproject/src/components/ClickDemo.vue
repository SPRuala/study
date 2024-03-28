<!--内联处理器-->
<!--可以在属性里直接写可以执行的js-->
<!--应用场景少 写法简洁-->
<template>
<h2>6.内联事件处理器</h2>
<!-- v-on:或@ -->
  <button @click="count++">点我</button>
  <p>点击次数为：{{count}}</p>
</template>

<script>
export default {
  data(){
    return{
      count:0
    }
  }



}
</script>

<style scoped>

</style>