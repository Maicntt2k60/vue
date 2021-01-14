<template>
  <div>
    <ItemPostList v-for="index in 10" :key="index" :msg="index.toString()"/>
  </div>
</template>
<script>
import ItemPostList from "@/components/ItemPostList.vue";
export default {
  name:"About",
  components:{
    ItemPostList
  },
  data(){
    return{

    }
  }
}
</script>