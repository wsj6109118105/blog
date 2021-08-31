<template>
  <div style="margin-top: 40px">
    <!--<el-button @click="addArticle()">添加文章</el-button>-->
    <div class="articles-area">
      <el-card style="text-align: left">
        <div v-for="article in articles" :key="article.id">
          <div style="float:left;width:85%;height: 150px;">
            <router-link class="article-link" :to="{path:'/articledetails',query:{id: article.id}}"><span style="font-size: 20px"><strong>{{article.articleTitle}}</strong></span></router-link>
            <router-link class="article-link" :to="{path:'/articledetails',query:{id: article.id}}"><p>{{article.articleAbstract}}</p></router-link>
          </div>
          <el-image
              style="margin:18px 0 0 30px;width:100px;height: 100px"
              :src="article.articleCover"
              fit="cover"></el-image>
          <el-divider></el-divider>
        </div>
      </el-card>
    </div>
    <el-pagination
        background
        layout="total, prev, pager, next, jumper"
        @current-change="PageChange"
        :page-size="pageSize"
        :total="total">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "Articles",
  data(){
    return{
      articles:[],
      pageSize:2,
      total:0
    }
  },
  mounted() {
    this.loadArticles()
  },
  methods:{
    loadArticles(){
      let _this = this
      this.$axios.get('http://localhost:8088/article/'+this.pageSize+'/1').then((resp)=>{
        if (resp&&resp.status===200){
          _this.articles = resp.data.content
          _this.total = resp.data.totalElements
        }
      })
    },
    PageChange(page){
      let _this = this
      this.$axios.get('http://localhost:8088/article/'+this.pageSize+'/'+page).then(resp=>{
        if (resp&&resp.status===200){
          _this.articles = resp.data.content
          _this.article = resp.data.totalElements
        }
      })
    }
  }
}
</script>

<style scoped>
.articles-area {
  width: 990px;
  height: 100%;
  margin-left: auto;
  margin-right: auto;
}

.article-link {
  text-decoration: none;
  color: #606266;
}

.article-link:hover {
  color: #409EFF;
}
</style>
