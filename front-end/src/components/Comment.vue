<template>
  <div class="comment-main">
    <v-row>
      <v-col cols="1">
        <v-avatar>
          <img
              src="@/assets/logo.png"
              alt="John">
        </v-avatar>
      </v-col>
      <v-col cols="10">
        <a href="#"><span>Name user comment</span></a>
        <v-row style="margin-top: 1%;">
          <div class="content-status" v-html="dataComment"></div>
        </v-row>
      </v-col>
      <v-col cols="1">
        <code>1d #{{ index }}</code>
      </v-col>
    </v-row>
    <v-divider style="margin-top: 1%"/>
  </div>

</template>

<script>
export default {
  name: "Comment",
  props: {
    index: Number
  },
  data() {
    return {
      dataComment: '<h4>Comment so ' + this.index + '</h4>'
    }
  }
}
</script>

<style scoped>
.comment-main {
  margin-top: 2%;
}
</style>