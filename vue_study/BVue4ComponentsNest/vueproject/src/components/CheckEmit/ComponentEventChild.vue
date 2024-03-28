<template>
  <h3>组件事件的子组件</h3>
  <button @click="give">传递数据</button>
</template>

<script>
export default {
  data(){
    return{
      childmessage:"这是return中的子级数据"
    }
  },
  methods:{
    give(){
      console.log("传递了数据")
      //自定义事件
      //写法：this.$emit("子级向父级传递的事件名称","要传递的数据")
      this.$emit("giveEvent","Child数据")
      //传递return中定义的数据
      this.$emit("returnmessage",this.childmessage)

    }
  }
}
</script>

<style scoped>

</style>