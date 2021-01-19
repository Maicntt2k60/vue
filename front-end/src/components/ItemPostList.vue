<template>
<div class="item-post-list">
  <v-row>
    <v-col cols="8">
      <h2>{{msg}}</h2>
    </v-col>
    <v-col cols="4">Mac dinh</v-col>
  </v-row>
  <hr>
</div>
</template>

<script>
export default {
  name: "ItemPostList",
  props:{
    msg:String
  }
}
</script>

<style scoped>
.item-post-list{
  text-align: center;
}
</style>