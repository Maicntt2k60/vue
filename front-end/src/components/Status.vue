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
      <v-col cols="10">
        <a href="#"><span>Name user</span></a>
      </v-col>
      <v-col cols="1">
        <code>1d #1</code>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "Status"
}
</script>

<style scoped>
.status-main{
  margin-top: 1%;
}
</style>