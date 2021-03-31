<template>
  <v-container>
    <v-row>
      <h1 class="topic" style="font-size:1.7511em;line-height:1.2;">
        {{ dataPost.title }}
      </h1>
    </v-row>
    <v-row style="
         border-bottom: groove;
         border-bottom-width: thin;">
      <v-col cols="10" style="display: inline-flex;">
        <v-chip
            :color="dataPost.subjectDTO.color">
          <h5 style="color: white;">{{ dataPost.subjectDTO.tag }}</h5></v-chip>
        <div class="tag-post" style="margin-left: 1%; margin-top: 3px;">
          <v-icon>
            mdi-tag-outline
          </v-icon>
          <p v-for="index in dataPost.hashTag" style="margin-left: 5px; display: inline-flex;"
             :key="index">
            {{ index+ ' |'}}</p>
        </div>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="1">
        <v-avatar color="red">
          <span class="white--text headline">{{dataPost.userCreate.slice(0,2)}}</span>
        </v-avatar>

      </v-col>
      <v-col cols="3" style="font-weight: bold;font-size: 18px;">
        <a>{{ dataPost.userCreate }}</a>
      </v-col>
      <v-col cols="5">
      </v-col>
      <v-col cols="2" style="font-size:15px;color:#999;">
        {{ dataPost.contentPostDTO.dateCreate }}
      </v-col>
      <v-col cols="1" style="font-size:15px;color:#999;">
        #1
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="1">
      </v-col>
      <v-col cols="11" v-html="dataPost.contentPostDTO.content">
      </v-col>
    </v-row>
    <v-snackbar v-model="snackbar" :timeout="timeoutSnackbar">
      {{ textSnackbar }}
      <template v-slot:action="{ attrs }">
        <v-btn color="pink" text v-bind="attrs" @click="snackbar = false">
          Close
        </v-btn>
      </template>
    </v-snackbar>
  </v-container>
</template>
<script>
import axios from 'axios';
import api from "@/config/api";
import Editor from '@tinymce/tinymce-vue';

export default {
  name: 'Post',
  components: {Editor},
  data() {
    return {
      dataComment: [],
      overloadPost: false,
      overloadComment: true,
      sheet: false,
      textSnackbar: '',
      dataHtml: '',
      dataSrcEdit: '',
      snackbar: false,
      timeoutSnackbar: 2000,
      totalLike: '0',
      isLike: '#000000',
      isLikePost: false
    }
  },
  props: {
    titleHeader: String,
    dataPost:Object
  },
  async created() {
  },
  methods: {
    openCreateComment() {
      if (this.$cookie.get('token') !== null) {
        this.sheet = true;
      } else {
        this.textSnackbar = "Vui lòng đăng nhập để viết bình luận";
        this.snackbar = true;
      }
    },
    async createComment() {
      if (this.$cookie.get('token') !== null) {
        await axios({
          method: 'POST',
          url: api.BASE_URL + 'comment/',
          headers: {
            Authorization: `Bearer ` + this.$cookie.get('token')
          },
          data: {post_id: this.$route.params.id, comment_content: this.dataHtml}
        }).then(
            res => {
              if (res.status === 200 && res.data.success === true) {
                this.sheet = false;
                this.textSnackbar = "Viết bình luận thành công!";
                this.snackbar = true;
              } else {
                this.sheet = false;
                this.textSnackbar = "Lỗi khi viết bình luận!";
                this.snackbar = true;
              }
            }
        )
      } else {
        this.textSnackbar = "Vui lòng đăng nhập để tiếp tục";
        this.snackbar = true;
      }
    },
    async likePostMethod() {
      if (this.$cookie.get('token') !== null) {
        const config = {
          headers: {Authorization: `Bearer ` + this.$cookie.get('token')}
        };
        if (this.isLikePost === true) {
          await axios.delete(api.BASE_URL + 'postVote/' + this.$route.params.id, config).then(
              res => {
                if (res.status === 200 && res.data.success === true) {
                  this.textSnackbar = "Hủy yêu thích thành công";
                  this.snackbar = true;
                  this.isLikePost = false;
                  this.isLike = "#000000";
                  let likeTotal = Number.parseInt(this.totalLike) - 1;
                  this.totalLike = likeTotal.toString();
                } else {
                  this.textSnackbar = "Lỗi server";
                  this.snackbar = true;
                }
              }
          );
        } else {
          await axios({
            method: 'POST',
            url: api.BASE_URL + 'postVote/' + this.$route.params.id,
            headers: {
              Authorization: `Bearer ` + this.$cookie.get('token')
            }
          }).then(
              res => {
                if (res.status === 200 && res.data.success === true) {
                  this.textSnackbar = "Yêu thích thành công";
                  this.snackbar = true;
                  this.isLikePost = true;
                  this.isLike = 'pink';
                  let likeTotal = Number.parseInt(this.totalLike) + 1;
                  this.totalLike = likeTotal.toString();
                } else {
                  this.textSnackbar = "Lỗi server";
                  this.snackbar = true;
                }
              }
          );
        }
      } else {
        this.textSnackbar = "Vui lòng đăng nhập để tiếp tục";
        this.snackbar = true;
      }
    },
    async deletePost() {
      if (this.$cookie.get('token') !== null) {
        const config = {
          headers: {Authorization: `Bearer ` + this.$cookie.get('token')}
        };
        this.textSnackbar = "Đang xóa bài viết ...";
        this.snackbar = true;
        await axios.delete(api.POST_URL + '/' + this.$route.params.id, config).then(
            res => {
              if (res.status === 200 && res.data.success === true) {
                this.snackbar = false;
                this.textSnackbar = "Xóa thành công";
                this.snackbar = true;
                setTimeout(() => this.$router.push('/'), 1000);
              } else {
                this.snackbar = false;
                this.textSnackbar = "Lỗi Server";
                this.snackbar = true;
              }
            }
        )
      } else {
        this.textSnackbar = "Vui lòng đăng nhập để tiếp tục";
        this.snackbar = true;
      }
    },
  },
}
</script>
<style scoped>
.col-1-information {
  max-width: 10% !important;
}
</style>
