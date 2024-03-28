<template>
  <div class="header">
    <h3 style="color: lime">子传父(组件事件)</h3>
    <ComponentEvent/>
  </div>

</template>

<script>
import ComponentEvent from "../components/CheckEmit/ComponentEvent.vue";

export default {
  components: { ComponentEvent},
  data(){
   return{

   }
 }
}
</script>

<style scoped>
.header{
  width: 100%;
  height: 600px;
  border: 5px solid #999;
  text-align: center;
  line-height: 100px;
  box-sizing: border-box;
}

</style>