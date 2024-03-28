<template>
<h3>Child</h3>
<!-- 模板语法显示传的数据 -->
<!-- 传递字符串 -->
  <p>{{content}}</p>
  <p>{{othercontent}}</p>
  <p>{{title}}</p>
<!-- 传递数值 -->
  <p>{{age}}</p>
<!-- 传递数组 -->
  <ul>
    <li v-for="(item,index) of names" :key="index">
      {{item}}-{{index}}
  </li>
  </ul>
<!-- 传递对象 -->
<p>{{people.id}}</p>
<p>{{people.name}}</p>
<p>{{people.adress}}</p>
</template>

<script>
export default {
  data(){
    return{

    }
  },
  //使用props接收Parent传来的数据。使用 props:["引用Child组件时要传递的的属性名字"] 的写法
  //如果要传多个数据 需要用,隔开
  //props 只读 不能用任何手段修改从父级传来的数据
  props:["content","othercontent","title","age","names","people"]
}
</script>

<style scoped>

</style>