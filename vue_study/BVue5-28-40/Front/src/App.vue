
<template>
<VModleComponentMain/>
  ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
  <br>
  <FComponentA/>
  ——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
  <br>
<!--  组件与组件之间的内容为一个模板（一个html结构）-->
<!--  在标签之中添加内容-->
<!--  把以下内容传给子组件（需在子组件里加slots标签）-->
  <SlotDemo>
    <h3>插槽标题</h3>
    <p>插槽内容</p>
  </SlotDemo>
  <hr>————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
<!--  如果要使用动态内容需要在父级中写好-->
<!--  插槽内容本身在父模板定义的 只是在子元素中渲染-->
  <SlotDemodrawing>
    <h3>插槽渲染的内容</h3>
    <h3>{{message}}</h3>
<!--   v-slot 具名插槽：为插槽内容添加名字 子级根据名字进行渲染-->
<!--    使用<template v-slot:起名字></template>-->
<!--   使用插槽模板，同一模板中的内容不放在一起时 可以根据每个内容的名字进行布局渲染 -->
<!--    v-slot简写：#-->
    <template v-slot:tryname>
      <p>试试用v-slot给插槽内容起名</p>
    </template>
    <template #tryname2>
      <p>试试用#给插槽内容起名</p>
    </template>
  </SlotDemodrawing>
  <hr>——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
<!--  插槽内同时使用父元素和子元素数据(数据传递)-->
<!--  先让子元素给父元素传递数据-->
<!--  父元素插槽接收到数据在将其放入-->
<!--  再将插槽中父元素和子元素的数据从插槽出口传给子元素-->
<!--  1.在子元素slot中先使用 :属性名 的方式将数据传给父元素-->
<!--  2.在父元素中使用属性 v-slot="起的名字"（“”内一般是slotprops）进行接收。"起的名字"一般包含 :属性名 这个数据-->
<!--  3.在父级插槽中做显示 使用 起的名字.属性名 的写法-->
  <SlotAttr v-slot="slotprops">
    只是父元素数据：
    <h4>{{parentmessage}}</h4>
    子元素数据：
    <h5>{{slotprops.kidmsg}}</h5>
    <!--    具名插槽传递数据 将 起的名字 作为插槽名 顺便传递数据-->
<!-- 具名插槽传递数据时 无法用v-slot从整个插槽传递 -->
<!--
<template #getchildmsg="slotprops">
  {{slotprops.childmsg}}
</template>
-->
  </SlotAttr>
————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
  <br>
<!--  <Life/>-->
  ——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
  <br>
  <LifeUse/>
  _______________________________________________________________________________________________________
  <br>
  <h3>8.动态组件</h3>
 这是组件A <ComponentA/>
  <hr>
  这是组件B<ComponentB/>
  <hr>
  A,B组件的动态切换:
<!--  vue本身承载组件的标签-->
<!--  标签内通过 :is=""的方式呈现标签内容-->
<!--  在组件标签外使用keep-alive标签 使该组件在被切换掉后依然存活-->
<!--  组件依然存活：被切换前的数据不会因切换组件丢失  不会进入销毁的生命周期-->
  <keep-alive>
    <component :is="showComponent"></component>
  </keep-alive>

<button @click="changeComponent">切换组件</button>

  ————————————————————————————————————————————————————————————————————————————————————————
  <br>
<!--  依赖注入：使多层嵌套组件间可以更方便的传递远距离组件数据-->
  <h2>依赖注入</h2>
  <h3>爷爷组件</h3>
  <ComponentGiveDataParent/>

</template>


<script>
import ComponentGiveDataParent from "./components/ComponentGiveData/ComponentGiveDataParent.vue";
import VModleComponentMain from "./components/VModleComponentMain.vue";
import FComponentA from "./components/FComponent/FComponentA.vue";
import SlotDemo from "./components/SlotDemo.vue";
import SlotDemodrawing from "./components/SlotDemodrawing.vue";
import SlotAttr from "./components/SlotAttr.vue";
import Life from "./components/Life.vue";
import LifeUse from "./components/LifeUse.vue";
import ComponentA from "./components/DynamicComponent/ComponentA.vue";
//将组件B换为异步加载
// import ComponentB from "./components/DynamicComponent/ComponentB.vue";

//异步加载后 只有切换到B才会进行加载
import {defineAsyncComponent} from "vue";
const ComponentB=defineAsyncComponent(()=>
    import("./components/DynamicComponent/ComponentB.vue")
)
export default {
  components:{
    ComponentGiveDataParent,
    ComponentB, ComponentA, LifeUse, Life, SlotAttr, VModleComponentMain,FComponentA,SlotDemo,SlotDemodrawing},
  data(){
    return{
      message:"没写死的插槽内容",
      parentmessage:"父级插槽传递来的数据",
    //  默认当前显示哪个组件 有切换需求时应该加""
      showComponent:"ComponentA",
    //  data中的数据也可以直接写入provide
      grandmessagefromdata:"爷爷组件从data中拿到的数据"
    }
  },
  methods:{
    changeComponent(){
      //组件A和B的切换 在赋值时需要是字符串类型（+“”） 并且有切换需求时return里的组件名字也应该是字符串类型
      this.showComponent=this.showComponent=="ComponentA"?"ComponentB" : "ComponentA"
    }
  },
  //利用provide直接向整个嵌套组件链里传数据 可以跳过parent组件直接使child组件拿到数据
 // provide和inject 只能从上到下传递依赖 没有关系不能传递
 // 直接传递数据
 /* provide:{
    grandmessage:"爷爷的数据"
  }*/
  //从data中拿数据
  provide(){
    return{
      grandmessage:this.grandmessagefromdata
    }
  }
}

</script>
<style>

</style>
