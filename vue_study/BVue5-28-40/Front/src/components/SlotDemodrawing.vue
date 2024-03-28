<template>
<h3>4.插槽渲染</h3>
<!--  如果父组件没有定义插槽内容的话 显示在此定义的插槽默认值-->
  <slot>插槽的默认值</slot>
<!--  在子元素中使用 slot中的name属性进行根据名字渲染对应内容-->
  <slot name="tryname">插槽默认</slot>
  <slot name="tryname2">插槽默认</slot>
</template>

<script>
export default {
  name: "SlotDemodrawing.vue"
}
</script>

<style scoped>

</style>