<template>
  <div class="container">{{ message }}</div>
</template>

<script>
export default {
  data(){
    return{
      message:"组件基础组成"
    }
  }
}
</script>
<!--scoped：让当前样式只在当前组件中生效     （不加scoped会使当前样式在全局作用域生效）-->
<style scoped>
.container{
  font-size: 50px;
  color: lime;
}
</style>