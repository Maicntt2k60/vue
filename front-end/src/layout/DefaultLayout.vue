<template>
  <div>
    <v-app>
      <v-app-bar app class="header-menu">
        <header-default></header-default>
      </v-app-bar>
      <v-main class="main-forum">
        <slot/>
      </v-main>
    </v-app>
  </div>
</template>

<script>
import HeaderDefault from "@/layout/HeaderDefault";
import Footer from "@/layout/Footer";
export default {
  name: "DefaultLayout",
  components:{
    HeaderDefault, Footer
  }
}
</script>

<style scoped>
.header-menu{
  background-color: #3A3A3A !important;
}
.main-forum{
  position: center !important;
  width: 90% !important;
  margin-left: 5%;
  margin-right: 5%;
}
</style>