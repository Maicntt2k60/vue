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
      <item-post-list v-for="data in dataPostList" :key="data.id" :data-item-post="data"/>
    </div>
    <div class="pagination">
      <div class="text-center">
        <v-pagination
            v-model="page"
            :length="2"
            @input="nextPage"
            @previous="nextPage"
            @next="nextPage"
            circle
        ></v-pagination>
      </div>
    </div>
  </div>
</template>

<script>
import ItemPostList from "@/components/post/ItemPostList";
import axios from "axios";
import api from "@/config/api";

export default {
  name: 'Home',
  components: {
    ItemPostList
  },
  data() {
    return {
      msg: "On create",
      menuGroupChoose: "latest",
      dataPostList: [],
      loading: false,
      page: 1
    }
  },
  async created() {
    this.loading = true;
    await axios.get(api.FULL_URL + "post/", {
      headers: {
        "Access-Control-Allow-Origin": "*"
      }
    }).then(
        res => {
          this.dataPostList = res.data;
          this.loading = false;
        }
    )
  },
  methods: {
    changeOptionMenu() {
      if (this.menuGroupChoose === "top") {
        this.menuGroupChoose = "latest";
      } else {
        this.menuGroupChoose = "top";
      }

    },
    async nextPage() {
      this.loading = true;
      await axios.get(api.FULL_URL + "post/", {params: {page: this.page}}).then(
          res => {
            if (res.status === 200) {
              this.dataPostList = res.data;
              this.loading = false;
              // this.page = this.page
            } else {
              this.loading = false;
              this.snackbar = true;
            }
          }
      )
    },
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

.list-item-post {
  margin-top: 1%;
  width: 100%;
}
.pagination{
  margin-top: 1%;
}
</style>
