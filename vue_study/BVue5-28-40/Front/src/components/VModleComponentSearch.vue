<template>
搜索：<input type="text" v-model="search">
</template>

<script>
export default {
data(){
  return{
    search:""
  }
},
  watch:{
  search(newValue,oldValue){
      this.$emit("Searchthings",this.search)
  }
  }
}
</script>

<style scoped>

</style>