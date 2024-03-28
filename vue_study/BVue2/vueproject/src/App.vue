<!--script和template标签顺序无所谓-->
<!--模板语法(文本插值的形式)-->
<template>
  <h3>模板语法</h3>
  <p>{{msg}}</p>
  <p>{{hello}}</p>
  <p>求值：{{number+1}}</p>
  <p>三目运算符：{{ok ? "Yes":"No"}}</p> <!--三目运算符：为真返回Yes，为假返回no-->
  <p>反转字符串：{{reversal.split("").reverse().join("") }}</p>  <!--split（""）根据”“将字符串分割 reverse()将内容反转 join（）存入一个数组-->
  <p v-html="rawhtml"></p><!--指令-->
  <p>错误的html嵌入方法：{{rawhtml}}</p><!--这个不行，会把冒号后面的都打印在网页上-->


</template>


<script>


export default {
  components: {HelloWord},
  data(){
    return{/*return里可以写对象（键值对关系）*/
      msg:"啊啊啊",
      hello:"HELLO",
      number:100,
      ok:true,
      reversal:"这是一个准备反转的字符串",
      rawhtml:"<a href='https://www.runoob.com/'>菜鸟链接</a>"
    }
  }
}

</script>



