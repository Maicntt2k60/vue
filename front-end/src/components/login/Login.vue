<template>
  <div class="login">
    <v-dialog
        @click:outside="clickOutsite"
        v-model="openDialog.action"
        width="600">
      <v-card>
        <v-card-title>
          <h2>Login</h2>
        </v-card-title>
        <v-card-text>
          <h3>Username</h3>
          <v-text-field v-model="userName" type="text"></v-text-field>
          <h3>Password</h3>
          <v-text-field v-model="password" type="password"></v-text-field>
        </v-card-text>
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn depressed color="error" @click="loginEvent">Login</v-btn>
          <v-btn depressed color="error">Cancel</v-btn>
        </v-card-actions>
        <v-overlay :value="loadingToLogin.action">
          <v-progress-circular
              indeterminate
              size="64"
          ></v-progress-circular>
        </v-overlay>
      </v-card>
      <v-btn depressed color="error" @click="registerEvent">Go to Register</v-btn>
      <v-snackbar
          v-model="snackbar"
      >
        {{ msgLogin }}

        <template v-slot:action="{ attrs }">
          <v-btn
              color="pink"
              text
              v-bind="attrs"
              @click="snackbar = false"
          >
            Close
          </v-btn>
        </template>
      </v-snackbar>
    </v-dialog>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Login",
  props: {
    openDialog: Object,
    closeDialog: Object,
    loadingToLogin: Object
  },
  data() {
    return {
      userName: '',
      password: '',
      snackbar: false,
      msgLogin: ''
    }
  },
  methods: {
    clickOutsite() {
      this.openDialog.action = false;
      this.loadingToLogin.action = false;
    },
    async loginEvent() {
      this.loadingToLogin.action = true;
      await axios.post("http://localhost:8080/api/account/?userName="
          + this.userName + "&password=" + this.password, {},
          {
            'Content-Type': 'application/json;charset=UTF-8',
            "Access-Control-Allow-Origin": "*",
          }).then(
          res => {
            if (res.data === true) {
              this.msgLogin = "Login thành công!";
              this.snackbar = true;
              this.loadingToLogin.action = false;
              setTimeout(function(){console.log("")}, 5000);
              this.openDialog.action = false;
              this.$router.push({path: "/post/"});

            } else {
              this.msgLogin = "Sai tên đăng nhập hoặc mật khẩu!";
              this.snackbar = true;
              this.loadingToLogin.action = false;
            }
          }
      )
    },
    registerEvent() {
      this.openDialog.action = false;
      this.closeDialog.action = true;
    },
    setValueLoading(value) {
      this.loadingToLogin.action = value;
    }
  }
}
</script>

<style scoped>

</style>