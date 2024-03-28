<template>
<h3>ComponentB</h3>
  <p>{{title}}</p>
  <p>{{age}}</p>
 <p v-for="(item,index) of names" :key="index">{{item}}</p>
  <p>{{necessary}}</p>
</template>

<script>
export default {
data(){
  return{

  }
},
//  希望数据被接收时有类型验证
//  可以验证 String Number Array Object（对象）类型
//  default：默认值 如果props应该被接收一个值但是父级组件没有传递 默认显示的内容（只能String和Number可以直接default,数组和对象需要工厂函数返回默认值）
props:{
  title:{
    type:String  //使用type进行验证 规定期望为String类型（不是的话会报警告）
  },
  age:{
    type:Number,
    default:0

  },
  //数组/对象类型需要默认值需要用函数的方式
  names:{
    type:Array,
    default(){
      return["空"]
    }
  },
  //要使一个值成为必选项（父组件不传这个值会报警告）
  //required:true
  necessary:{
    type:String,
    required:true
  }
}
}
</script>

<style scoped>

</style>