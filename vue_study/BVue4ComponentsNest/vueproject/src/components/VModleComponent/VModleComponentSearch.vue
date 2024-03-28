<template>
 搜索: <input type="text" v-model="search">
</template>

<script>
export default {
  data(){
    return{
      search:""
    }
  },
  //侦听器 随时侦听search数值的变化
  watch:{
    search(newValue,oldValue){
      this.$emit("SearchChange",newValue)
    }
  }
}
</script>

<style scoped>

</style>