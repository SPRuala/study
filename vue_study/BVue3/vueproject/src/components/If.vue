<template>
<!-- 条件渲染 -->

<!-- v-if:判断内容能否被渲染。该属性放入的值如果为true就可以被渲染，如果为false就不能渲染 -->
<!-- v-if 惰性 只有在true时才会被渲染 绑定时条件很少改变可以使用-->
  <div v-if="flag">能看见吗？</div>
<!-- v-else：if为false时被显示。v-else不用赋值 -->
  <div v-else>if为false时被显示</div>
<!-- v-else-if 多条件判断 看type写的是什么，就输出什么（类似于switch？）-->
  <div v-if="type==='A'">A</div>
  <div v-else-if="type==='B'">B</div>
  <div v-else-if="type==='C'">C</div>
  <div v-else>not A/B/C</div>
<!-- v-show：和v-if一样，但没有else属性，为false时也不会显示else内容 。只能判断自己本身能否显示-->
<!-- 不管true和false都会被渲染（改变css的display属性）频繁切换时可以使用 -->
  <div v-show="flag">这是show，为true时能被看见</div>
</template>

<script>
export default {
  data(){
    return{
      flag:true,
      type:"D"
    }
  }
}
</script>

