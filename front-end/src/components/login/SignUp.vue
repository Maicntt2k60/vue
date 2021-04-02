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
          <v-btn depressed color="error" @click="registerEvent">Sign UP</v-btn>
          <v-btn depressed color="error">Cancel</v-btn>
        </v-card-actions>
      </v-card>
      <v-row>
        <v-col cols="6" style="width: 100%">
          <v-btn style="width: 100%" depressed color="error" @click="loginEvent">Go to Login</v-btn>
        </v-col>
        <v-col cols="6" style="width: 100%">
          <v-btn style="width: 100%" depressed color="error" @click="openDatePicker">open</v-btn>
        </v-col>
      </v-row>
    </v-dialog>
    <pick-date-birth :action-picker-date.sync="actionDatePicker"/>
  </div>
</template>

<script>
import PickDateBirth from "@/components/login/PickDateBirth";
export default {
  name: "SignUp",
  components: {PickDateBirth},
  props: {
    openDialog: Object,
    closeDialog: Object
  },
  data() {
    return {
      userName: '',
      password: '',
      actionDatePicker:{
        action:false,
        value:""
      }
    }
  },
  methods: {
    clickOutsite() {
      this.openDialog.action = false;
    },
    registerEvent() {
      console.log(this.userName);
      console.log(this.password);
      console.log(this.actionDatePicker.value);
    },
    loginEvent() {
      this.openDialog.action = false;
      this.closeDialog.action = true;
    },
    openDatePicker(){
      this.actionDatePicker.action = true;
    }
  }
}
</script>

<style scoped>

</style>
