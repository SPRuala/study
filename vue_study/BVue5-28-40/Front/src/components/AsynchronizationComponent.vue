<template>
<h3>异步组件</h3>
<!--  同步组件：每个组件排队一个个执行-->
<!--  异步组件：所有组件一起执行-->
<!--  异步组件优化性能：用到哪个组件加载哪个组件 需要显示哪个加载哪个 使项目打开速度变快-->
<!--  使用defineAsyncComponent-->
<!--  eg将AB切换中的B做成了异步加载的样式-->
</template>

<script>
export default {
  name: "AsynchronizationComponent"
}
</script>

<style scoped>

</style>