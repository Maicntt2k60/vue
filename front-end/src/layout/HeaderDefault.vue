<template>
  <div class="main-header">
    <v-row>
      <v-col cols="3">
        <h2 class="title-header">NAGA FORUM</h2>
      </v-col>

      <v-col cols="6" class="menu-option">

        <v-btn class="btn-header-option"
            depressed
            color="error">
          LOGIN
        </v-btn>
        <v-btn class="btn-header-option"
            depressed
            color="error">
          SIGN UP
        </v-btn>
        <v-btn class="btn-header-option"
               icon
               color="white">
          ?
        </v-btn>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "HeaderDefault",
  data() {
    return {}
  }
}
</script>

<style scoped>
.main-header {
  width: 100% !important;
}

.menu-option {
  /*float: right !important;*/
  margin-left: 25% !important;
}

.title-header {
  color: white;
}
.btn-header-option{
  float: right;
  margin-left: 2%;
  margin-top: 1%;
}
</style>