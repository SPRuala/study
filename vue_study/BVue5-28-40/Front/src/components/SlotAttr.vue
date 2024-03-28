<!--  让子组件渲染的同时将一部分数据提供给插槽-->
<template>
<h3>5.插槽同时使用父元素和子元素内容</h3>

  <slot :kidmsg="childrenmessage"></slot>
<slot name="getchildmsg" :childmsg="namechildrenmessage"></slot>

</template>

<script>
export default {
data(){
  return{
    childrenmessage:"子元素的数据",
    namechildrenmessage:"具名插槽子元素的数据"
  }
}
}
</script>

<style scoped>

</style>