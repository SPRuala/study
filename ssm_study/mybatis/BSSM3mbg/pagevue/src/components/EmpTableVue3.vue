<template>
  <el-table
      :data="info"
      style="width: 100%">
    <el-table-column
        label="员工号码"
        prop="empno"
        align="center"
        width="180">
    </el-table-column>
  </el-table>

</template>

<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";

const info=ref([]);

axios
    .get("/api/HelloServlet")
    .then(response => {
      info.value = response.data
      console.log(info.value)

    })
    .catch(function (error) {
      console.log(error)
    });

</script>

