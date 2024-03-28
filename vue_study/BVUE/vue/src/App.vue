<!--script和template标签顺序无所谓-->
<!--模板语法(文本插值的形式)-->
<template>
<h3>模板语法</h3>
  <p>{{msg}}</p>
  <p>{{hello}}</p>
</template>
<script >

export default {
  data(){
    return{/*return里可以写对象（键值对关系）*/
      msg:"啊啊啊",
      hello:"HELLO"
    }
  }
}

</script>



