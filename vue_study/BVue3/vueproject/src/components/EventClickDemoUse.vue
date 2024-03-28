<template>
  <h2>事件传参场景</h2>

  <p v-for="item of peoples" @click="clickname(item)">{{item}}</p>
  <p>既传递参数又传递event对象------</p>
<!-- 写法（要传的数据,$event） -->
  <p v-for="(item,index) of peoples" :key="index" @click="clickname(item,$event)">{{item}}</p>
</template>

<script>
 export default {
   data() {
     return {
       peoples: ["朱素葆", "水煮菠菜"]
     }
   },
   methods:{
     clickname(name,e){
       console.log(name);
       console.log(e)
     }
   }
 }
</script>

<style scoped>

</style>