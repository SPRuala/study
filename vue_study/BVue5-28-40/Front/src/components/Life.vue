<template>
<h3>6.组件生命周期</h3>
  <p>{{updatemessage}}</p>
  <button @click="update">更新数据</button>
<!--  从组件被创建到销毁-->
<!--  重要节点：组件被创建,数据改变,被销毁   重要节点都对应一个生命周期钩子函数-->
<!--  钩子函数：在不同关键时刻自动执行-->

</template>
<!--生命周期函数：-->
<!--1.创建期：beforeCreate组件即将创建 初始化组件里的信息 ---》created组件已经创建完成 还没有显示在页面上-->
<!--2.挂载期：beforeMount准备渲染 --》mounted组件已经渲染完成 可以在页面上看到-->
<!--当数据改变时-->
<!--3.更新期：beforeUpdate更新之前 开始渲染---》新数据渲染完成后 updated更新之后   此周期可能会多次循环-->
<!--4.销毁期：beforeUnmount销毁之前 开始销毁--》 unmounted销毁之后 组件已经不存在-->
<script>
export default {
  data(){
    return{
      updatemessage:"更新之前"
    }
  },
  methods:{
    update(){
      this.updatemessage="更新之后"
    }
  },
 beforeCreate() {
   console.log("组件创建之前")
 },
  created() {
   console.log("组件创建之后")
  },
  beforeMount() {
   console.log("组件渲染之前")
  },
  mounted() {
   console.log("组件渲染之后")
  },
  beforeUpdate() {
   console.log("组件更新数据之前")
  },
  updated() {
   console.log("组件更新之后")
  },
  beforeUnmount() {
   console.log("组件销毁之前")
  },
  unmounted() {
   console.log("组件销毁之后")
  }


}
</script>

<style scoped>

</style>