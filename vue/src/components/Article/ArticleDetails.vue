<template>
  <div class="articles-area">
    <el-card style="text-align: left;width: 990px;margin: 35px auto 0 auto">
      <div>
        <span style="font-size: 20px"><strong>{{article.articleTitle}}</strong></span>
        <div class="markdown-body">
          <div v-html="article.articleContentHtml"></div>
        </div>
        <el-button type="info" round @click="routerTo" v-if="!(this.$store.state.user.username==='')">修改文章</el-button>
        <el-button type="danger" round @click="deleteArticle" v-if="!(this.$store.state.user.username==='')">删除文章</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
import router from "../../router";

export default {
  name: "ArticleDetails",
  data(){
    return{
      article:[]
    }
  },
  mounted() {
    this.loadArticle()
  },
  methods:{
    loadArticle() {
      let _this = this
      this.$axios.get('/articledetails/'+this.$route.query.id).then(resp=>{
        if (resp&&resp.status===200){
          _this.article = resp.data
        }
      })
    },
    routerTo(){
      let _this = this
      this.$router.push({name:'Jotter',params:{ articles : _this.article }})
    },
    deleteArticle(){
      let _this = this
      this.$confirm("是否删除文章","提示",{
        confirmButtonText:'确定',
        cancelButtonText:'取消',
        type:'warning'
      }).then(()=>{
        this.$axios.post('/articledetail/'+this.article.id).then(resp=>{
          if (resp&&resp.status===200){
            this.$message({
              type: 'info',
              message: '成功删除'
            })
            router.push('/article')
          }
        })
      })
    }
  }
}
</script>

<style scoped>
  @import "../../styles/markdown.css";
</style>
