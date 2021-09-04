<template>
  <div style="height: 100%">
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <books class="books-area" ref="booksArea"></books>
    </el-main>
  </el-container>
  </div>
</template>

<script>
import SideMenu from "./SideMenu"
import Books from "./Books";
export default {
  name: "LibraryIndex",
  components:{
    SideMenu,
    Books
  },
  methods: {
    listByCategory () {
      var _this = this
      var cid = this.$refs.sideMenu.cid
      var url = '/categories/' + cid + '/books'
      this.$axios.get(url).then(resp => {
        if (resp && resp.status === 200) {
          _this.$refs.booksArea.books = resp.data
        }
      })
    }
  }
}
</script>

<style scoped>
.el-main{
  padding: 0 20px 0;

}
.books-area {
  width: 990px;
  margin-left: auto;
  margin-right: auto;
}
</style>
