<!--这是父级-->
<template>
  <h3>ComponentA</h3>
<ComponentB :title="title" :names="names" :necessary="necessary"/>
</template>

<script>
import ComponentB from "./ComponentB.vue";
export default {
  components: {ComponentB},
  data(){
    return{
    title:"标题",
      names:["zsb","wdd"],
      necessary:"必须传这个值"
    }
  }
}
</script>

<style scoped>

</style>