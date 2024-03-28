<template>
  <h3>子组件</h3>
  {{grandmessage}}
  <br>
  {{datafirstmessage}}
  <p>{{globaldata}}</p>
</template>

<script>
export default {
//使用inject接收爷爷组件传递的数据 写法inject:["数据名字"]
inject:["grandmessage","globaldata"],
  //把inject数据先传给data，data处理后再显示
  data(){
  return{
    datafirstmessage:this.grandmessage
  }

  }
}
</script>

<style scoped>

</style>