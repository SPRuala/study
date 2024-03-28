<template>
<h3>组件事件</h3>
<!--  将Child里自定义的事件名称作为事件来处理（@+自定义事件名字）-->
<!--在子元素中写一个按钮 触发了自定义事件 在父元素中将自定义事件当成事件类型处理 在事件类型中又触发一个函数  -->
 <ComponentEventChild @giveEvent="getEvent" @returnmessage="getreturnmessage"/>
  <p>子级传来的数据:{{message}}  {{returnmessage}}</p>
</template>

<script>
import ComponentEventChild from "./ComponentEventChild.vue";
export default {
components:{ComponentEventChild},
  data(){
    return{
      //承载子级传来的数据
      message:"",
      returnmessage:""
    }
  },
  methods:{
  //data为子级 自定义事件 设定的要传递的数据
  getEvent(data){
    console.log("触发了",data)
    this.message=data
  },
    getreturnmessage(returnmessage){
    this.returnmessage=returnmessage
    }
  }
}
</script>

<style scoped>

</style>