<template>
  <div class="home">
    <v-row class="menu-option-main">
      <v-col cols="2">
        <v-btn depressed color="error" @click="changeOptionMenu">
          Menu
        </v-btn>
      </v-col>

      <v-col cols="9">
        <v-btn-toggle
            v-model="menuGroupChoose"
            tile
            color="deep-purple accent-3"
            group
        >
          <v-btn value="latest" depressed>
            Latest
          </v-btn>
          <v-btn value="categories" depressed>
            Categories
          </v-btn>

          <v-btn value="top" depressed>
            Top
          </v-btn>

          <v-btn value="faq" depressed>
            FAQ
          </v-btn>
        </v-btn-toggle>
      </v-col>
    </v-row>

  </div>
</template>

<script>

export default {
  name: 'Home',
  components: {},
  data() {
    return {
      msg: "On create",
      menuGroupChoose:"latest"
    }
  },
  methods:{
    changeOptionMenu(){
      if (this.menuGroupChoose === "top"){
        this.menuGroupChoose="latest";
      }
      else{
        this.menuGroupChoose = "top";
      }

    }
  }

}
</script>
<style scoped>
.home {
  /*display: flex;*/
}
</style>
