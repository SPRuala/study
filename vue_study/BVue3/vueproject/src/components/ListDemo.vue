<template>
<!-- 列表渲染 -->

<!-- v-for:渲染数组。里面写item（代表数组中的元素。item可以改成别的名字） in（或of） itme（数组名字） -->
<!-- {{}}里写item代表遍历全部的元素 -->
  <br>下面是遍历的name数组
  <p v-for="item in name">{{item}}</p>
<!-- josn遍历见javaweb -->
<!-- 网上传的列表（复杂列表）遍历见菜鸟教程 -->
<!-- v-for 查看数组元素与下标 （有两个值）（用可选的第二个参数做索引）-->
  <br>下面是遍历的数组-下标
  <p v-for="(item,index) in name">{{item}}-{{index}}</p>
<!-- v-for遍历对象(有三个值)小括号里顺序固定 表达式可以不固定 -->
  <p v-for="itime of userinfo">{{itime}}</p>
  <p v-for="(itime,key,index) of userinfo">{{itime}}-{{key}}-{{index}}</p>
</template>

<script>
export default {
  data(){
    return{
      name:["朱素葆","啊啊啊啊","oooooo"],
      userinfo:{
        name:"菠菜",
        age:20,
        sex:"女"
      }
    }
  }
}
</script>
