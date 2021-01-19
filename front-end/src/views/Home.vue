<template>
  <div class="home">
    <h1>Home is component</h1>
    <div v-for="index in 4" :key="index">
    <p v-if="index%2 ===0">So chan la:{{index}}</p>
      <p v-else>So le la:{{index}}</p>
    </div>

    <div>{{msg}}</div>
  </div>
</template>

<script>

export default {
  name: 'Home',
  components: {
    
  },
  data(){
    return{
      msg:"On create"
    }
  },

}
</script>
