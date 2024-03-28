<!--key管理状态-->
<!--为防止用户操作后改变List数据顺序导致重新渲染-->
<!--给每个元素绑定唯一的key（v-bind）不再使用就地更新的方法，使用顺序更换-->
<template>
<h2>5.Key属性添加到v-for中</h2>
<!-- 正常情况下index为该数据的id 写法:  ：key="item.id" -->
  <p v-for="item of names" :key="index">{{item}}</p>
</template>

<script>
export default {
  data() {
    return {
      names:["key管理状态1","key管理状态2","key管理状态3"]
    }
  }
}
</script>

