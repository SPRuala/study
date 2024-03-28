<template>

  <h3>父组件</h3>
  {{globaldata}}
  <ComponentGiveDataChild/>
</template>

<script>
import ComponentGiveDataChild from "./ComponentGiveDataChild.vue";
export default {
  components: {ComponentGiveDataChild},
inject:["globaldata"]
}
</script>

<style scoped>

</style>