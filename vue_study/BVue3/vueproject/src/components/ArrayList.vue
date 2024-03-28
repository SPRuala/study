<template>
<h2>10.数组变化侦听</h2>
<!--如果数组发生变化 ui会自动跟着响应（更新）-->
  <button @click="addList">添加元素</button>
  <ul>
    <li v-for="(item,index) of names" :key="index">
      {{item}}
    </li>
  </ul>
<!-- 使用以下变更方法 数组不会改变 被一个新数组替换 -->
<!--filter-->
<!--concat-->
<!--slice-->
<!--主要看是否对原地址进行操作-->


  <p>练习：</p>
  <p>数组1</p>
  <ul>
    <li v-for="(item,index) of List1" :key="index">{{item}}</li>
  </ul>
  <p>数组2</p>
  <ul>
    <li v-for="(item,index) of List2" :key="index">{{item}}</li>
  </ul>
  <button @click="combine">合并数组</button>
  <p>合并后:</p>
  <ul>
    <li v-for="(item,index) of newList">{{item}}</li>
  </ul>
</template>

<script>
export default {
  data(){
    return{
      names:["元素1","元素2","元素3"],
      List1:[1,2,3],
      List2:[4,5,6],
      newList:[]
    }
  },
  methods:{
    addList(){
      //.push方法可以使ui自动更新
      this.names.push("push新加的元素")
      //不会引起ui自动更新（生成新的数组）
      this.names.concat(["concat新元素"])
      //想使用不造成ui自动更新的方法 又想让ui实时更新
      //将改变好的数组重新赋值给names
      this.names=this.names.concat("让ui更新的concat新元素")
    },
    combine(){
      this.newList=this.newList.concat(this.List1+this.List2)
      this.newList=this.newList.concat(this.List1)
      this.newList=this.newList.concat(this.List2)
    }
  }
}

</script>

<style scoped>

</style>