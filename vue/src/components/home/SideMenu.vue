<template>
  <el-menu
      class="categories"
      default-active="0"
      @select="handleSelect"
      active-text-color="red">
    <el-menu-item index="0">
      <i class="el-icon-menu"></i>
      <span slot="title">采用技术</span>
    </el-menu-item>
<!--    <el-menu-item index="1">
      <i class="el-icon-menu"></i>
      <span slot="title">文学</span>
    </el-menu-item>
    <el-menu-item index="2">
      <i class="el-icon-menu"></i>
      <span slot="title">流行</span>
    </el-menu-item>-->
  </el-menu>
</template>

<script>
export default {
  name: "SideMenu"
}
</script>

<style scoped>
.categories {
  position: fixed;
  margin-left: 0%;
  left: auto;
  top: 100px;
  width: 150px;
}
</style>
