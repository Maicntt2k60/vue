<template>
  <div class="login">
    <v-dialog
        @click:outside="clickOutsite"
        v-model="openDialog.action"
        width="600"
    >
      <v-card>
        <v-card-title>
          <h2>Sign Up</h2>
        </v-card-title>
        <v-card-text>
          <h3>Username</h3>
          <v-text-field v-model="userName" type="text"></v-text-field>
          <h3>Password</h3>
          <v-text-field v-model="password" type="password"></v-text-field>
        </v-card-text>
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn depressed color="error" @click="registerEvent">Sign In</v-btn>
          <v-btn depressed color="error">Cancel</v-btn>
        </v-card-actions>
      </v-card>
      <v-btn depressed color="error" @click="loginEvent">Go to Login</v-btn>
    </v-dialog>
  </div>
</template>

<script>
export default {
  name: "SignUp",
  props: {
    openDialog: Object,
    closeDialog: Object
  },
  data() {
    return {
      userName: '',
      password: ''
    }
  },
  methods: {
    clickOutsite() {
      this.openDialog.action = false;
    },
    registerEvent() {
      console.log(this.userName);
      console.log(this.password);
    },
    loginEvent(){
      this.openDialog.action = false;
      this.closeDialog.action = true;
    }
  }
}
</script>

<style scoped>

</style>