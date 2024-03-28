<template>
<div class="aside">
  <h3>组件校验，默认值，必须值</h3>

  <ComponentA/>
<!--  <Item/>-->
<!--  <Item/>-->
<!--  <Item/>-->
</div>

</template>

<script>
// import Item from "./Item.vue";
import ComponentA from "../components/CheckProps/ComponentA.vue";
export default {
  components: {ComponentA}

  // components: {Item}
}
</script>

<style scoped>
h3{
  color: lime;
}
.aside{
  float: right;
  width: 30%;
  height: 600px;
  border: 5px solid #999;
  box-sizing: border-box;
}
</style>