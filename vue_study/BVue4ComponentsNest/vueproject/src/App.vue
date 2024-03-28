<template>
  <Header/>
  <Main/>
  <Aside/>
  <VModleComponentMain/>
</template>
<script setup>
//Header的注册使用了全局注册方式
// import Header from "./pages/Header.vue";
import Main from "./pages/Main.vue";
import Aside from "./pages/Aside.vue";
import VModleComponentMain from "./components/VModleComponent/VModleComponentMain.vue";
</script>

<style>

</style>