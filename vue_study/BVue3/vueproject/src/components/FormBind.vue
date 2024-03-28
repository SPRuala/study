<template>
<h2>15.表单输入绑定(实时获取表单输入内容)</h2>
<!-- v-model 绑定输入框 -->
  <form action="">
   实时获取： <input type="text" v-model="message">
    <p>{{message}}</p>
<!--  绑定复选框  -->
    <input type="checkbox" id="checkbox" v-model="ifchack">
    <label for="checkbox">{{ifchack}}</label> <br>
<!-- 修饰符 写法eg：v-model.lazy="" -->
<!--  lazy:失去焦点后获取  -->
<!--  number:只获取数字  -->
<!-- trim:去掉前后空格-->

   修饰符（延迟获取为例） <input type="text"  v-model.lazy="modifierwork">
    <p>{{modifierwork}}</p>
  </form>



</template>

<script>
export default {
  data(){
    return{
      message:"",
     ifchack:"false",
      modifierwork:""
    }
  }
}
</script>

<style scoped>

</style>