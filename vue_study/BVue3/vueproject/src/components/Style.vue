<template>
<h2>13.Style绑定</h2>
<!-- 对象绑定 "{}" -->
<!-- return值不加"" style标签里的对象加""-->
<!-- 带 — 的属性写成对象的写法后要加''，或写成驼峰命名法 -->
  <p :style="{color:activecolor,fontSize:fontsize+'px'}">对象绑定</p>
<!-- 一次绑定多个值 -->
  <p :style="manystyle">一次绑定多个值</p>
<!-- 绑定数组不建议用-->
<!-- 建议绑定class -->

</template>

<script>
export default {
  data(){
    return{
      activecolor:"red",
      fontsize: 30,
      manystyle:{
        color:"red",
        fontSize:"40px"
      }
    }
  }
}
</script>

<style scoped>

</style>