<template>
  <div class="status-main">
    <v-row>
      <v-col cols="1">
        <v-avatar>
          <img
              src="@/assets/logo.png"
              alt="John">
        </v-avatar>
      </v-col>
      <v-col cols="10" style="float: left">
        <a href="#"><span>Name user</span></a>
        <v-row style="margin-top: 1%;">
          <div class="content-status" v-html="dataStatus"></div>
        </v-row>
      </v-col>
      <v-col cols="1">
        <code>1d #1</code>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "Status",
  data() {
    return {
      dataStatus:'<h1 style="color: red">Noi dung bai viet</h1>'
    }
  }
}
</script>

<style scoped>
.status-main {
  margin-top: 1%;
  margin-bottom: 2%;
}
</style>