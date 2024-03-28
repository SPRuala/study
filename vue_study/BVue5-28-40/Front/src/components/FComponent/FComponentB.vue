<template>
<h3>ComponentB</h3>
  {{title}}
  {{onEvent("传递数据")}}
</template>

<script>
export default {
  name: "FComponentB",
  data(){
    return{

    }
  },
  props:{
    //定义类型写法2
    title:String,
    onEvent:Function
  }
}
</script>

<style scoped>

</style>