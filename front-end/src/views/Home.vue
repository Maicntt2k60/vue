<template>
  <div class="home">
    <v-row class="menu-option-main">
      <v-col cols="2">
        <v-btn depressed color="error" @click="changeOptionMenu">
          Menu
        </v-btn>
      </v-col>
      <v-col cols="10">
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
    <hr>
    <v-row>
      <v-col cols="9">
        <h4>Topic</h4>
      </v-col>
      <v-col cols="1">
        <h4>Replies</h4>
      </v-col>
      <v-col cols="1">
        <h4>Views</h4>
      </v-col>
      <v-col cols="1">
        <h4>
          Activity
        </h4>
      </v-col>
    </v-row>
    <hr>
    <v-overlay :value="loading">
      <v-progress-circular
          indeterminate
          size="64"
      ></v-progress-circular>
    </v-overlay>
    <div class="list-item-post">
      <ItemPostList  v-for="data in dataPostList" :key="data.title" :data-object="data"/>
    </div>
  </div>
</template>

<script>
import ItemPostList from "@/components/ItemPostList";
export default {
  name: 'Home',
  components: {
    ItemPostList
  },
  data() {
    return {
      msg: "On create",
      menuGroupChoose: "latest",
      dataPostList:[],
      loading:false
    }
  },
  created() {
    this.dataPostList.push({
      "title":"bai 1",
      "replies":100,
      "views":200,
      "activity":"1h"
    });
    this.dataPostList.push({
      "title":"bai 2",
      "replies":100,
      "views":200,
      "activity":"1h"
    });
    this.dataPostList.push({
      "title":"bai 3",
      "replies":100,
      "views":200,
      "activity":"1h"
    });
  },
  methods: {
    changeOptionMenu() {
      if (this.menuGroupChoose === "top") {
        this.menuGroupChoose = "latest";
      } else {
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

.menu-option-main {
  margin-top: 1%;
}
.list-item-post{
  margin-top: 1%;
}
</style>
