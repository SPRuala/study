<template>
<h3>ComponentA</h3>
  <!-- 使用alive 切换后强制使组件仍然存活不被卸载-->
  <p>{{message}}</p>
  <button @click="changemessage">修改数据</button>
</template>

<script>
export default {
  data(){
    return{
      message:"老数据"
    }
  },
  methods:{
    changemessage(){
      this.message="新数据"
    }
  },
  beforeUnmount() {
    console.log("组件要被卸载")
  },
  unmounted() {
    console.log("组件已被卸载")
  }
}
</script>

<style scoped>

</style>