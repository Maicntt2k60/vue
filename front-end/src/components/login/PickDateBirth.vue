<template>
  <div>
    <v-row justify="center">
      <v-dialog
          v-model="actionPickerDate.action"
          persistent
          max-width="350"
      >
        <v-card>
          <v-card-title class="headline">
            Choose Birth Date
          </v-card-title>
          <v-card-text>

            <v-date-picker
                v-model="actionPickerDate.value"
                color="green lighten-1"
            ></v-date-picker>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                color="green darken-1"
                text
                @click="actionPickerDate.action = false"
            >
              Disagree
            </v-btn>
            <v-btn
                color="green darken-1"
                text
                @click="actionPickerDate.action = false"
            >
              Agree
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "PickDateBirth",
  props: {
    actionPickerDate: Object
  },
  data() {
    return {
    }
  }
}
</script>

<style scoped>

</style>
