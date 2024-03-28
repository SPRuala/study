
<template>
  ——————————————————————————————————————————————————————————<br>
  2.属性动态绑定
 <HelloWorld/>
  ——————————————————————————————————————————————————————————<br>
  3.条件渲染
  <If/>
  ——————————————————————————————————————————————————————————————<br>
  4.列表渲染
  <ListDemo/>
  ——————————————————————————————————————————————————————————————<br>
  <KeyCondition/>
  ______________________________________________________________ <br>
  <ClickDemo/>
  <EventClickDemo2/>
  ____________________________________________________________ <br>
  <EventClickDemo3/>
  ___________________________________________________________________ <br>
  <EventClickUse/>
  _____________________________________________________________ <br>
  <EventModifier/>
  ____________________________________________________________ <br>
  <ArrayList/>
  _________________________________________________________ <br>
  <Compute/>
  ———————————————————————————————————————————————————————————————————— <br>
  <ClassBind/>
  ———————————————————————————————————————————————————————————— <br>
  <Style/>
  —————————————————————————————————————————————————————————————————————————————— <br>
  <Watch/>
  _________________________________________________________________ <br>
  <FormBind/>
  _______________________________________________________________ <br>
  <RefDom/>
  ———————————————————————————————————————————————————————————————————————— <br>
<!-- 3组件显示 -->
  <MyComponent/>

</template>

<script setup>
import HelloWorld from './components/HelloWorld.vue'
import If from './components/If.vue'
import ListDemo from "./components/ListDemo.vue";
import KeyCondition from "./components/KeyCondition.vue";
import ClickDemo from "./components/ClickDemo.vue";
import EventClickDemo2 from "./components/EventClickDemo2.vue";
import EventClickDemo3 from "./components/EventClickDemo3.vue";
import EventClickUse from "./components/EventClickDemoUse.vue";
import EventModifier from "./components/EventModifier.vue";
import ArrayList from "./components/ArrayList.vue";
import Compute from "./components/Compute.vue";
import ClassBind from "./components/ClassBind.vue";
import Style from "./components/Style.vue";
import Watch from "./components/Watch.vue";
import FormBind from "./components/FormBind.vue";
import RefDom from "./components/RefDom.vue";
//1组件引入
//import+ 给组件起的名字 from "在哪个包下的哪个文件"
import MyComponent from "./components/mycomponents/Mycomponent.vue";

/*//现版本有set up就不用写export default
export default {
  //2组件注入
  components:{
    MyComponent
  }
}*/
</script>

<style>

</style>
