<template>
  <div>
    <component is="style">
      .content > .theme--light.v-icon{
      color: {{ color }};
      }
    </component>
    <v-row style="
         border-bottom: groove;
         border-bottom-width: thin;
          ">
      <v-col cols="9">
        <a :href="/post/+dataItemPost.id">{{ dataItemPost.title }}</a>
        <div class="content">
          <v-chip
              :color="dataItemPost.subjectDTO.color"
          ><h5 style="color: white;">{{ dataItemPost.subjectDTO.tag }}</h5></v-chip>
          <v-icon color="#000000" style="margin-left: 1%;">mdi-tag-outline</v-icon>
          <p v-for="index in dataItemPost.hashTag" style="display: inline-flex; margin-left: 3px;">
            {{ index }}</p>
        </div>
      </v-col>
      <v-col cols="1">
        {{ 1 }}
      </v-col>
      <v-col cols="1">
        {{ 1 }}
      </v-col>
      <v-col cols="1">
        {{ 1 }}h
      </v-col>
    </v-row>
  </div>
</template>
<script>
export default {
  name: 'ItemPostList',
  data() {
    return {
      color: "#00ff00"
    }
  },
  props: {
    dataItemPost: Object
  },
  created() {
    // if (this.dataItemPost.subject_short.subject_color !== null) {
    //   this.color = this.dataItemPost.subject_short.subject_color;
    // }
  },
}
</script>
<style scoped>
a {
  text-decoration: none;
}
</style>
