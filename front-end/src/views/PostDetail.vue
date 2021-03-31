<template>
  <div>
    <post :data-post="dataPost"></post>
  </div>
</template>

<script>
import Status from "@/components/Status";
import Comment from "@/components/Comment";
import Post from "@/components/post/Post";
import axios from "axios";
import api from "@/config/api";

export default {
  name: "PostDetail",
  components: {
    Post,
    Status, Comment
  },
  data() {
    return {
      timeNow: "",
      dataPost: {}
    }
  },
  created() {
    axios.get(api.FULL_URL + "/post/" + this.$route.params.id).then(
        res => {
          this.dataPost = res.data;
        }
    )
  }
}
</script>

<style scoped>

</style>
