<template>
<h2>12.Class绑定</h2>
<!-- class增强 -->
<!-- ：class的数值可以是数组，字符串，对象，表达式(要在""内写) -->
<p :class="myClass">Class绑定</p>
<!-- 对象写法 'styleclass'为字符串 和后面的值绑定 值为true则active字符串被绑定为class（显示active样式） false不绑定-->
<p :class="{'styleclass':classchange}">Class绑定+样式</p>
<!--class里的内容可以绑定两个-->
<p :class="{'fontsize':iffontsize,'fontcolor':iffontcolor}">Class绑定两个值</p>

<!-- 多个对象绑定  -->
  <p :class="manyclass">一次性绑定多个class</p>

<!-- 绑定数组 -->
<p :class="[arr1,arr2]">绑定数组</p>

<!--使用三目运算符绑定 (需写在数组中)-->
  <p :class="[iffontcolor ? 'fontcolor':'']">三目运算符绑定</p>
<!-- 数组嵌套对象 -->
<!-- 数组嵌套对象时必须是 数组在外面对象在里面 [{xxx},xxx]的形式 -->
  <p :class="[iffontsize ? 'fontsize':'',{'fontclolr':iffontcolor} ]">数组嵌套对象</p>
</template>

<script>
export default {
  data(){
    return{
      myClass:"demo",
      classchange:true,
      iffontsize:true,
      iffontcolor:false,
      manyclass:{
        'fontsize':true,
        'fontcolor':true
      },
      arr1:"fontsize",
      arr2:"fontcolor"
    }
  }
}
</script>

<style>
.styleclass{
  color: blueviolet;
  font-size: 30px;
}
.fontsize{
  font-size: 50px;
}
.fontcolor{
  color: cyan;
}
</style>