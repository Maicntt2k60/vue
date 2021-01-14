<template>
  <div class="home">
    <h1>Home is component</h1>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <div v-for="index in 4" :key="index">
    <p v-if="index%2 ===0">So chan la:{{index}}</p>
      <p v-else>So le la:{{index}}</p>
    </div>

    <div>{{msg}}</div>
  </div>
</template>

<script>
import HelloWorld from '@/components/HelloWorld.vue';

export default {
  name: 'Home',
  components: {
    HelloWorld,
  },
  data(){
    return{
      msg:"On create"
    }
  },

}
</script>
