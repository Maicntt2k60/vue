<template>
  <div>
    <h1>Paramaster</h1>
  </div>
</template>

<script>
export default {
  name: "Paramaster",
  data() {
    return {}
  },
  created() {
    console.log("day la id:"+this.$route.params.id);
    console.log("day la name:"+this.$route.query.name);
  }
}
</script>

<style scoped>

</style>