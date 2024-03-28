# vueproject

This template should help get you started developing with Vue 3 in Vite.

## Recommended IDE Setup

[VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur) + [TypeScript Vue Plugin (Volar)](https://marketplace.visualstudio.com/items?itemName=Vue.vscode-typescript-vue-plugin).

## Customize configuration

See [Vite Configuration Reference](https://vitejs.dev/config/).

## Project Setup

```sh
npm install
```

### Compile and Hot-Reload for Development

```sh
npm run dev
```

### Compile and Minify for Production

```sh
npm run build
```
这是一个注释文件。写什么都行

打两行空格才能换行啊。
————————————————————————————————————————————————————

1.
.gitignore：协作用的文件

index.html：入口html文件

package.json：记录了文件名、版本号等信息。

vite.config.js：配置文件。跨域、打包等都在此文件处理。

2.模板语法

双大括号语法
{{}}可以放有值有结果的单一表达式，文本,三目运算符。（只要能合法写进return就可以放）
var a=1 没有返回值，为一条语句，所以不行。
ifelse不是单一表达式（有换行）所以不行。
模板语法中不能写逻辑操作（将逻辑操作写进js，结果写入返回值。）
若想内嵌html：

<p v-html="rawhtml"></p>
return{
rawhtml:"<a href="xxxxxxxxxx">这是个超链接</a>"
}
渲染时表现为p标签嵌套一个p标签

main.js里默认引用了样式，不要样式删除即可
assets文件夹里有被引用的样式们（以后也可以在这里存css等文件）。不要的删除即可。

3.属性绑定




