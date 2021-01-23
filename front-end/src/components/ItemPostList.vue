<template>
<div class="item-post-list">
  <v-row>
    <v-col cols="9">
      <a href="#"><h3>{{dataObject.title}}</h3></a>
    </v-col>
    <v-col cols="1">
      {{dataObject.replies}}
    </v-col>
    <v-col cols="1">
      {{dataObject.views}}
    </v-col>
    <v-col cols="1">{{dataObject.activity}}</v-col>
  </v-row>
  <hr>
</div>
</template>

<script>
export default {
  name: "ItemPostList",
  props:{
    dataObject:Object
  }
}
</script>

<style scoped>
.item-post-list{
  text-align: center;
  margin-bottom: 1%;
}
a{
  color: red !important;
  text-decoration-line: none;
}
</style>