<template>
<h3>7.组件声明周期函数应用</h3>
<!--  1.通过ref获取元素的dom结构-->
<!--  组件还没被渲染之前没有dom结构-->
<!--  获取dom最好的时期在挂载后-->
  <p ref="name">试试生命周期获取dom结构</p>
<!--  2.模拟网络请求渲染数据  即使在不同生命周期进行网络请求 数据始终会渲染一次-->
<!--  用列表进行渲染-->
  <ul>
    <li v-for="(item,index) of banner" :key="index">
    {{item.title}}
      {{item.content}}
  </li>
  </ul>
</template>

<script>
export default {
  data(){
    return{
    //  网络请求数据要先初始化
      banner:[]
    }
  },

  //created时组件还没被渲染（不是最好时机）
  //在创建后马上进行网络请求会使组件先拿到数据再渲染到页面
  created() {
    this.banner=[
        {"title":"标题1",
          "content":"内容1"
        },
      {
        "title":"标题2",
        "content":"内容2"
      },
      {
        "title":"标题3",
        "content":"内容3"
      }
        ]
  },
  //组件创建前模拟网络请求不会显示任何数据
  //组件创建前不会进行初始化数据
  beforeCreate() {
    this.banner=[
      {"title":"标题1",
        "content":"内容1"
      },
      {
        "title":"标题2",
        "content":"内容2"
      },
      {
        "title":"标题3",
        "content":"内容3"
      }
    ]
  },
//  在渲染前获取dom结构  结果为undefined
beforeMount() {
  console.log(this.$refs.name)
},
//  在渲染后获取dom结构 可以获取
//  在渲染后进行网络请求（最佳时机）
mounted() {
  console.log(this.$refs.name)
  this.banner=[
    {"title":"标题1",
      "content":"内容1"
    },
    {
      "title":"标题2",
      "content":"内容2"
    },
    {
      "title":"标题3",
      "content":"内容3"
    }
  ]
}
}
</script>

<style scoped>

</style>