<template>
  <v-container>
    <v-row class="comment-main">
      <v-col cols="1">
        <v-img
            height="45"
            width="45"
            :lazy-src="dataObject.user_avatar"
            :src="dataObject.user_avatar"
            style="border-radius:100%">
        </v-img>
      </v-col>
      <v-col class="user-name" cols="3">
        {{ dataObject.user_name }}
        <v-icon dark small color="pink" v-if="dataObject.user_permission === 2">
          mdi-security
        </v-icon>
        <v-icon dark small color="pink" v-else-if="dataObject.user_permission === 1">
          mdi-shield-account
        </v-icon>
      </v-col>
      <v-col cols="4">
      </v-col>
      <v-col class="info-left" cols="2">
        {{ dataObject.comment_content.comment_content_create }}
      </v-col>
      <v-col cols="1" class="info-left">
        #{{ indexComment }}
      </v-col>
      <v-btn fab dark small v-if="dataObject.owner" color="red" @click="openEditComment">
        <v-icon dark>mdi-square-edit-outline</v-icon>
      </v-btn>
      <v-btn class="btn-delete-comment" fab dark small v-if="dataObject.owner"
             style="margin-left: 1%" color="green" @click="deleteComment">
        <v-icon dark small>mdi-delete</v-icon>
      </v-btn>
    </v-row>
    <v-row>
      <v-col cols="1">
      </v-col>
      <v-col cols="11">
        <div class="comment-content" v-html="dataObject.comment_content.comment_content_main"></div>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="10">
      </v-col>
      <v-col cols="2">
        <v-badge class="badge-comment"
                 color="green"
                 :content="totalLike">
          <v-btn
              fab
              dark
              small
              @click="likeCommentMethod"
              :color="isLike">
            <v-icon dark>
              mdi-heart
            </v-icon>
          </v-btn>
        </v-badge>
        <v-btn
            class="mx-1"
            fab
            dark
            small
            @click="openReplyComment"
            color="primary">
          <v-icon dark>
            mdi-reply
          </v-icon>
        </v-btn>
        <v-bottom-sheet v-model="sheet">
          <v-sheet
              class="text-center"
              height="350px"
          >
            <h3>Reply comment of {{ dataObject.user_name }} #{{ indexComment }}</h3>
            <editor
                api-key="f8yzzwhskk61fuey3qpoo4qppynflk4o9ho7ntfjyxjame97"
                v-model="dataHtml"
                :init="{
         height: 300,
         menubar: false,
         plugins: [
           'advlist autolink lists link image charmap print preview anchor',
           'searchreplace visualblocks code fullscreen',
           'insertdatetime media table paste code help wordcount', 'code'
         ],
         toolbar:
           'undo redo | formatselect | bold italic backcolor | \
           alignleft aligncenter alignright alignjustify | \
           bullist numlist outdent indent | removeformat | help | code'
       }"
            />
          </v-sheet>
          <v-btn
              depressed
              color="primary"
              @click="createReplyComment">
            <v-icon small dark>mdi-upload</v-icon>
            Replay Comment
          </v-btn>
        </v-bottom-sheet>

      </v-col>
    </v-row>
    <v-snackbar v-model="snackbar" timeout="2000">
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
import Editor from '@tinymce/tinymce-vue';
import axios from 'axios';
import api from "@/config/api";

export default {
  name: 'Comment',
  data() {
    return {
      sheet: false,
      dataHtml: '',
      isLike: '#000000',
      totalLike: '0',
      textSnackbar: '',
      isLikeComment: false,
      dataSrcEditor: '',
      snackbar: false
    }
  },
  props: {
    dataObject: Object,
    indexComment: Number
  },
  components: {Editor},
  async created() {
    this.dataSrcEditor = this.dataObject.comment_content.comment_content_main;
    if (this.dataObject.user_avatar === null) {
      this.dataObject.user_avatar = 'https://picsum.photos/id/11/500/300';
    }
    // total like
    await axios.get(api.BASE_URL + 'commentVote/' + this.dataObject.comment_id).then(
        res => {
          if (res.status === 200 && res.data.total > 0) {
            this.totalLike = res.data.total;
          }
        }
    );

    if (this.$cookie.get('token') !== null) {
      const config = {
        headers: {Authorization: `Bearer ` + this.$cookie.get('token')}
      };
      await axios.get(api.BASE_URL + 'like/comment/' + this.dataObject.comment_id, config).then(
          res => {
            if (res.status === 200 && res.data.isLike === true) {
              this.isLike = 'pink';
              this.isLikeComment = true;

            } else {
              this.isLike = '#000000';
            }
          }
      );
    }
  },
  methods: {
    openReplyComment() {
      if (this.$cookie.get('token') !== null) {
        this.sheet = true;
      } else {
        this.textSnackbar = "Vui l??ng ????ng nh???p ????? vi???t b??nh lu???n";
        this.snackbar = true;
      }
    },
    createReplyComment() {
      console.log(this.dataHtml);
    },
    async likeCommentMethod() {
      if (this.$cookie.get('token') !== null) {
        const config = {
          headers: {Authorization: `Bearer ` + this.$cookie.get('token')}
        };
        if (this.isLikeComment === true) {
          await axios.delete(api.BASE_URL + 'commentVote/' + this.dataObject.comment_id, config).then(
              res => {
                if (res.status === 200 && res.data.success === true) {
                  this.textSnackbar = "H???y y??u th??ch th??nh c??ng";
                  this.snackbar = true;
                  this.isLikeComment = false;
                  this.isLike = "#000000";
                  let likeTotal = Number.parseInt(this.totalLike) - 1;
                  this.totalLike = likeTotal.toString();
                } else {
                  this.textSnackbar = "L???i server";
                  this.snackbar = true;
                }
              });
        } else {
          await axios({
            method: 'POST',
            url: api.BASE_URL + 'commentVote/' + this.dataObject.comment_id,
            headers: {
              Authorization: `Bearer ` + this.$cookie.get('token')
            }
          }).then(
              res => {
                if (res.status === 200 && res.data.success === true) {
                  this.textSnackbar = "Y??u th??ch th??nh c??ng";
                  this.snackbar = true;
                  this.isLikeComment = false;
                  this.isLike = "pink";
                  let likeTotal = Number.parseInt(this.totalLike) + 1;
                  this.totalLike = likeTotal.toString();
                } else {
                  this.textSnackbar = "L???i server";
                  this.snackbar = true;
                }
              });
        }
      } else {
        this.textSnackbar = "Vui l??ng ????ng nh???p ti???p t???c";
        this.snackbar = true;
      }
    },
    openEditComment() {
      if (this.$cookie.get('token') !== null) {
        this.sheet = true;
      } else {
        this.textSnackbar = "Vui l??ng ????ng nh???p ????? vi???t b??nh lu???n";
        this.snackbar = true;
      }
    },
    createEditComment() {

    },
    async deleteComment() {
      if (this.$cookie.get('token') !== null) {
        const config = {
          headers: {Authorization: `Bearer ` + this.$cookie.get('token')}
        };
        await axios.delete(api.BASE_URL + "comment/" + this.dataObject.comment_id, config).then(
            res => {
              if (res.status === 200 && res.data.success === true) {
                this.textSnackbar = "X??a b??nh lu???n th??nh c??ng";
                this.snackbar = true;
                this.$router.go(0);
              }
            }
        )
      } else {
        this.textSnackbar = "Vui l??ng ????ng nh???p ????? s??? d???ng thao t??c n??y";
        this.snackbar = true;
      }
    }
  }
}
</script>
<style scoped>
.comment-main {
  border-top-style: groove;
}

.comment-main > .user-name {
  position: relative;
  right: 30px;
  font-weight: bold;
  font-size: 18px;
}

.comment-main > .btn-delete-comment {
  margin-left: 1%;
  color: green;
}

.comment-main > .badge-comment {
  margin-right: 5%;
}

.comment-main > .info-left {
  font-size: 15px;
  color: #999;
}
</style>