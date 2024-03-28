
<template>
<!--{{}}}文本值的绑定 -->
<!--v-bind:属性绑定 （方便使用style）。如果绑定为null 该属性会从渲染元素上移除 可以简写为：-->
  <div v-bind:id="dynamicId" v-bind:class="massage">用v-bind把massage和dynamicId内容赋给v-bind的class和dynamicId</div>
  <div v-bind:id="dynamicId">这是只用v-bind绑定id的句子</div>
  <div v-bind:title="dynameTitle">id绑了null的值</div>
  <div :id="massage">v-bind简写为：的写法</div>
<!-- 布尔值disable属性 如果为true按钮不可点击，为false可点击。动态绑定是否可点击 -->
  <button :disabled="isButton">Button</button>
<!-- 一键绑定多个值 -->
  <div v-bind="IdAndClass">一次绑定多个值。id就是v-bind：id，class就是v-bind：class</div>
</template>

<script>
export default {
  data(){
    return{
      massage:"active",
      dynamicId:"idOne",
      dynameTitle:null,
      isButton:true,
      IdAndClass:{id:"idOne",class:"active"}
    }
  }
}
</script>

