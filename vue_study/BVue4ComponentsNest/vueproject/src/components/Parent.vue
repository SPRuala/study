<template>
<h3>Parent</h3>
<!-- Parent给Child传数据 可传多个  （使用props传递）（props只能从父级传递到子级）-->
<!-- 传递动态数据时使用v-bind绑定 -->
<!-- age要作为数字类型传递应该先绑定 且值没有双引号-->
  <Child content="Parent的数据" othercontent="这是另一个Parent的数据" :title="dynamicmessage" :age=age :names="names" :people="people"/>
</template>

<script>
import Child from "./Child.vue";
export default {
  components: {Child},
  data(){
    return{
      dynamicmessage:"动态的Parent数据",
      age:20,
      names:["菠菜","朱素葆"],
      people:{
        id:1,
        name:"王蛋蛋",
        adress:"天津南开"
      }
    }
  }
}
</script>

<style scoped>

</style>