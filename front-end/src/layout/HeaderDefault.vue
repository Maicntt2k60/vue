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
          LOGIN
        </v-btn>
        <Login :open-dialog.sync="loginOption"/>
        <v-btn class="btn-header-option"
               depressed
               @click="openSignUp"
               color="error">
          SIGN UP
        </v-btn>
        <SignUp :open-dialog.sync="signUpOption"/>
        <v-btn class="btn-header-option"
               icon

               color="white">
          ?
        </v-btn>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import SignUp from "@/components/SignUp";
import Login from "@/components/Login";

export default {
  name: "HeaderDefault",
  components: {
    Login,SignUp
  },
  data() {
    return {
      loginOption:{'action':false},
      signUpOption:{'action':false}
    }
  },
  methods:{
    openLogin(){
      this.loginOption.action= true;
    },
    openSignUp(){
      this.signUpOption.action= true;
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