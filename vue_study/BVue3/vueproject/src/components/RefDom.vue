<template>
<h2>16.模板引用</h2>
<!-- 在vue中直接读取DOM 通过对DOM操作获取数据 -->
<!-- 写法：ref="起名" -->
<!-- ref消耗性能 配合$ref进行读取获取dom元素 想获取里面的内容可以使用-->
  <div ref="container" class="container">{{ content }}</div>
  <button @click="getelement">获取元素</button>
  <br>
<!-- 获取input标签里输入框的内容 -->
  <input type="text" ref="inputcontent">
  <button @click="getinput">获取input标签里输入框的内容</button>
</template>
<!--内容改变：{{ }}模板语法-->
<!--属性改变：v-bind：指令-->
<!--事件改变：v-on：click/@click-->

<script>
/*写业务逻辑*/
export default {
  data(){
    return{
      content:"内容"
    }
  },
  methods:{
    getelement(){
      //写法 this.$refs.给ref起的名字
      //此时获取的元素就是div元素本身
      console.log(this.$refs.container)
      //想重新赋值
      //innerHTML原生js属性
      console.log(this.$refs.container.innerHTML="被重新赋值了捏")
    },
    getinput(){
      //不获取整个input（整个input会连标签属性一起获取） 只获取里面的值
      console.log(this.$refs.inputcontent.value)
    }
  }
}
</script>

<style>

</style>