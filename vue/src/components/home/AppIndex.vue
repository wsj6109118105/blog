<template>
  <div style="margin-top: 40px">
    <side-menu></side-menu>
      <div style="margin-left: 200px">
        <el-card class="box-card">
          <div class="text item">
            前端设计: vue+element-ui
            后端: spring boot
            数据库: Mysql
          </div>
        </el-card>
      </div>
  </div>
</template>

<script>
import SideMenu from "./SideMenu";
export default {
  name: "AppIndex",
  components:{SideMenu}
}
</script>

<style scoped>
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 880px;
}
</style>
