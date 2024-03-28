<template>
  <h2>7.方法事件处理器</h2>
  <!-- v-on:click或@click -->
  <!-- 在监听属性里直接放方法函数 （函数需在methods里写出）-->
  <button @click="addcount">点我</button>
  <p>点击次数为：{{count}}</p>
</template>

<script>
export default {
  data(){
    return{
      count:0
    }
  },
  /*methods和data同级，放所有方法*/
  methods:{
    addcount(){
      console.log("点击了"+this.count);//浏览器控制台打印
      //读取到data里面数据的方案 所有data里的数据都能用this获取
      //this.count;
      this.count++;
    }
  }

}
</script>

<style scoped>

</style>