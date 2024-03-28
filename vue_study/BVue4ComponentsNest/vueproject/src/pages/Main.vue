<template>
<div class="main">
  <h3 style="color: lime">Props基本语法</h3>
  <!-- Main中嵌套了Article 组件-->
<!--  <Article/>-->
<!--  <Article/>-->

<!-- _________________________________________________ -->

  <Parent/>
</div>


</template>

<script>
// import Article from "./Article.vue";
import Parent from "../components/Parent.vue";
export default {
  components: {Parent}

  // components: {Article}
}
</script>

<style scoped>
.main{
  float: left;
  width: 70%;
  height: 600px;
  border: 5px solid #999;
  box-sizing: border-box;
}
</style>