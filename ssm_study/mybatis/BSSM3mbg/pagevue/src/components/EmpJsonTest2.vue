<!--vue2-->
<template>
  {{info}}
  <hr>
  <div>
    {{info.empno}}
  </div>

</template>

<script>
import axios from "axios";

export default {
  data(){
    return{
      info:{}
    }
  },
  mounted () {
    axios
        .get('/api/HelloServlet')
        .then(response => (this.info = response.data))
        .catch(function (error) { // 请求失败处理
          console.log(error);
        });
  }
}

</script>

<style scoped>

</style>