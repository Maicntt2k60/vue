<template>
  <div id="app">
    <default-layout>
      <router-view/>
    </default-layout>
  </div>
</template>
<script>
import DefaultLayout from "@/layout/DefaultLayout";
export default {
  components: {DefaultLayout}
}
</script>
<style>

</style>