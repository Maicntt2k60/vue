<template>
  <div>
    <v-app>
      <v-app-bar app>
        <header-default></header-default>
      </v-app-bar>
      <v-main>
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

</style>