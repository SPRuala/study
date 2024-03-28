<template>
<h3>1.组件事件传递</h3>
  <p>Main</p>
<VModleComponentSearch @Searchthings="showSearch"/>
  <br>
  搜索内容：{{searchcontent}}
</template>

<script>
import VModleComponentSearch from "./VModleComponentSearch.vue";
export default {
  components: {VModleComponentSearch},
  data(){
        return{
          searchcontent:""
        }
    },
  methods:{
    showSearch(data){
      this.searchcontent=data
    }
  }
}
</script>

<style scoped>

</style>