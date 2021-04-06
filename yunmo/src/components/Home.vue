<template>
    <div>
        <img src="../assets/images/background1.jpg" style="height: 500px; width: 100%; object-fit: cover;" >
        <div>
            <Slide right width="200">
                <a id="home" href="/">
                    <span>Home</span>
                </a>
            </Slide>
        </div>
    </div>
</template>

<script>
import { Slide } from 'vue-burger-menu'
export default {
    name: 'home',
    components:{
        Slide
    },
    data(){
        return{

        }
    },
    methods:{

    }
}
</script>

<style>
    .bm-overlay {
      background: white;
    }
</style>