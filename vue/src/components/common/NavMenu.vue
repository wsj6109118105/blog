<template>
  <el-menu
      :default-active="this.$route.path"
      router
      mode="horizontal"
      background-color="white"
      text-color="#222"
      active-text-color="red"
      style="min-width: 100%">
    <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
      {{ item.navItem }}
    </el-menu-item>
<!--    <a href="#nowhere" style="color: #222;float: right;padding: 20px;">更多功能</a>-->
    <el-button type="danger" style="margin-right: -800px" @click="logout">d</el-button>
<!--    <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px"></i>-->

  </el-menu>
</template>

<script>
import router from "../../router";

export default {
  name: 'NavMenu',
  data () {
    return {
      navList: [
        {name: '/index', navItem: '首页'},
        {name: '/jotter', navItem: '笔记本'},
        {name: '/library', navItem: '图书馆'},
        {name: '/article', navItem: '文章'}
      ]
    }
  },
  methods:{
    logout() {
      this.$store.commit('logout')
      router.push('/login')
    }
  }
}
</script>

<style scoped>
a{
  text-decoration: none;
}

span {
  pointer-events: none;
}
</style>
