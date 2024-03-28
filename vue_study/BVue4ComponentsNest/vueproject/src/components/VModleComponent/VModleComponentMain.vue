<template>
  <h3>Main</h3>
<VModleComponentSearch @SearchChange="getSearch"/>
  <p>Main中收到的搜索内容：{{searchcontent}}</p>
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
    getSearch(data){
      this.searchcontent=data
    }
  }
}
</script>

<style scoped>

</style>