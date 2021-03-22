<template>
  <div class="item-post-list">
    <v-row>
      <v-col cols="9">
        <a href="#"><h3 class="title-object">{{ dataObject.title }}</h3></a>
      </v-col>
      <v-col cols="1">
        {{ dataObject.replies }}
      </v-col>
      <v-col cols="1" class="view-information">
        {{ dataObject.views }}
      </v-col>
      <v-col cols="1">{{ dataObject.activity }}</v-col>
    </v-row>
    <hr>
  </div>
</template>

<script>
import $ from "jquery";

export default {
  name: "ItemPostList",
  props: {
    dataObject: Object
  },
  created() {

  },
  mounted() {
    $('.view-information').hover(function () {
      $(this).css("color", "red");
    }, function () {
      $(this).css("color", "black");
    });
  }
}
</script>

<style scoped>
.item-post-list {
  text-align: center;
  margin-bottom: 1%;
}

a {
  color: red !important;
  text-decoration-line: none;
}

</style>