<template>
<div>
  <h2>Baif vieets so 1</h2>
  <p>Html</p>
  <v-divider/>
  <Status/>
  <v-divider/>
  <div class="list-comment" style="margin-left: 5%">
    <Comment v-for="data in 4" :key="data" :index="data"/>
  </div>
  <code>{{timeNow}}</code>


</div>
</template>

<script>
import Status from "@/components/Status";
import Comment from "@/components/Comment";
export default {
  name: "PostDetail",
  components:{
    Status, Comment
  },
  data(){
    return {
      timeNow:""
    }
  },
  created() {
    // this.$cookie.set("timeSave", "123", "1h");
    this.timeNow = this.$cookie.get("timeSave");
  }
}
</script>

<style scoped>

</style>