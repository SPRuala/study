<template>
<h2>14.侦听器</h2>
<!-- 只能侦听具有响应式的数据 （在data中 通过{{}}模板语法绑定的数据） -->
<!--侦听数据变化  -->
  <p>{{massage}}</p>
  <button @click="updatemassage">修改hello</button>
</template>

<script>
export default {
data(){
  return{
    massage:"hello"
  }
},
  methods:{
    updatemassage(){
      this.massage="被修改力"
    }
  },
  //添加对象watch（侦听器）其中定义了 相对应名称方法中属性变化后对应执行的事件
  watch:{
      massage(newValue,oldValue){//watch中定义的该方法的名称和return中属性名称一致
        console.log(newValue+"+"+oldValue)
      }
  }
}
</script>

<style scoped>

</style>