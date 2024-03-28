<template>
<h2>11.计算属性</h2>
<!--  把模板语句中的复杂表达式提到计算属性中-->
<!--  返回结果直接在模板进行显示-->
  <p>{{people.name}}</p><!--拿出people对象的name属性-->
<!-- 使用模板语法做复杂逻辑 -->
  模板语法结果:
  <p>{{people.otherinfo.length>0?'Yes':'No'}}</p><!--判断otherinfo属性长度是否为0，如果是就在页面输出yes 否则no-->
<!-- 使用计算属性 -->
<!-- 如果计算属性内表达式不变 多次调用只计算1次 -->
  计算属性结果:
  <p>{{iflength}}</p>
<!-- 使用函数 -->
<!-- 如果函数内表达式不变 每次调用都要重新计算 -->
  函数:
  {{iflength2()}}

</template>

<script>
export default {
  data() {
    return {
      people: {
        name: "朱素葆",
        otherinfo: ["女", "20211756"]
      }
    }
  },
  //计算属性
  computed:{
    iflength(){
      return this.people.otherinfo.length>0?'Yes':'No'
    }
  },
  methods:{
    iflength2(){
      return this.people.otherinfo.length>0?'Yes':'No'
    }
  }
}
</script>

<style scoped>

</style>