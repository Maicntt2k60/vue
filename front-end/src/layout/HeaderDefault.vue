<template>
  <div class="main-header">
    <v-row>
      <v-col cols="3">
        <h2 class="title-header">NAGA FORUM</h2>
      </v-col>

      <v-col cols="6" class="menu-option">

        <v-btn class="btn-header-option"
               depressed
               @click="openLogin"
               color="error">
          <v-icon dark>
            mdi-tag-outline
          </v-icon>

          LOGIN
        </v-btn>
        <Login :open-dialog.sync="loginOption" :close-dialog="signUpOption" :loading-to-login.sync="loadingToLogin"/>
        <v-btn class="btn-header-option"
               depressed
               @click="openSignUp"
               color="error">
          SIGN UP
        </v-btn>
        <SignUp :open-dialog.sync="signUpOption" :close-dialog="loginOption"/>
        <v-btn class="btn-header-option"
               icon
               @click="jqueryExample"
               color="white">
          ?
        </v-btn>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import SignUp from "@/components/login/SignUp";
import Login from "@/components/login/Login";
import $ from 'jquery';

export default {
  name: "HeaderDefault",
  components: {
    Login, SignUp
  },
  data() {
    return {
      loginOption: {'action': false},
      signUpOption: {'action': false},
      loadingToLogin: {'action': false}
    }
  },
  methods: {
    openLogin() {
      this.loginOption.action = true;
    },
    openSignUp() {
      this.loginOption.action = false;
      this.signUpOption.action = true;
    },
    jqueryExample() {
      console.log($('.item-post-list .title-object').text())
    }
  }
}
</script>

<style scoped>
.main-header {
  width: 100% !important;
}

.menu-option {
  /*float: right !important;*/
  margin-left: 25% !important;
}

.title-header {
  color: white;
}

.btn-header-option {
  float: right;
  margin-left: 2%;
  margin-top: 1%;
}
</style>
