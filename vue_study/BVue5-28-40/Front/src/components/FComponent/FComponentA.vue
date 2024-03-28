<template>
  <h2>2.组件数据传递</h2>
<h3>ComponentA</h3>
<!--  props使用函数（事件）达成子传父 -->
<!--父级把函数传给子级 子级调用 父级再把子级值赋给自己-->
  <FComponentB title="标题" :onEvent="dataFn"/>
<!--  这是子元素传给父元素的数据-->
  传递的数据为：{{message}}
</template>

<script>
import FComponentB from "./FComponentB.vue";
export default {
  name: "FComponentA",
  components: {FComponentB},
  data(){
    return{
      message:""
    }
  },
  methods:{
    dataFn(data){
      console.log(data)
      this.message=data
    }
  }
}
</script>

<style scoped>

</style>