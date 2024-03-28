<template>
  <h2>8.事件传参</h2>

  <button @click="addcount">点我</button>
  <p>点击次数为：{{count}}</p>

  <p>控制台打印hello</p>
<!-- 在点击按钮的时候传递给方法里一个参数hello -->
<!-- 传参写法（''） -->
  <button @click="printhello('你好!')">你好呀</button>
</template>

<script>
export default {
  data(){
    return{
      count:0
    }
  },
  methods:{
    //传入event对象e
    //e是原生js的event对象
    addcount(e){
      e.target.innerHTML="点我"+this.count
      this.count++;
    },
    printhello(massage){
      //接收参数
      console.log(massage);
    }
  }

}
</script>

<style scoped>

</style>