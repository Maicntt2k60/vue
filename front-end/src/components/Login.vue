<template>
  <div class="login">
    <v-dialog
        @click:outside="clickOutsite"
        v-model="openDialog"
        width="600"
    >
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
          <v-btn depressed color="error" @click="loginEvent">Sign In</v-btn>
          <v-btn depressed color="error">Cancel</v-btn>
        </v-card-actions>
      </v-card>

    </v-dialog>
  </div>
</template>

<script>
export default {
  name: "Login",
  props: {
    openDialog: Boolean
  },
  data() {
    return {
      dataOpen:true,
      userName:'',
      password:''
    }
  },
  created() {
    this.dataOpen = true;
  },
  destroyed() {
    this.dataOpen=false;
  },
  mounted() {
    this.dataOpen =false;
  },
  methods:{
    clickOutsite(){
      this.dataOpen = false;
    },
    loginEvent(){
      console.log(this.userName);
      console.log(this.password);
    }
  }
}
</script>

<style scoped>

</style>