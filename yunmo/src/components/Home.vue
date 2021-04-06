<template>
  <div>
    <!-- 여기서부터 header -->
    <div
      style="
      position: fixed;
      height: 75px;
      padding: 1rem;
      font-weight: bold;
      display: flex;
      justify-content: space-between;
      align-items: center;
      top: 0;
      left: 0;
      right: 0;
      z-index: 5;
    "
    >
      <button
        style="
        height: 75px;
        width: 10vw;
        display: flex;
        justify-content: center;
        align-items: center;
      "
      @click="goTo(0)"
      >
        LOGO
      </button>
      <button
        style="
        height: 75px;
        width: 10vw;
        display: flex;
        justify-content: center;
        align-items: center;
      "
      @click="goTo(1)"
      >
        HOME
      </button>
      <button
        style="
        height: 75px;
        width: 10vw;
        display: flex;
        justify-content: center;
        align-items: center;
      "
      @click="goTo(2)"
      >
        COMPANY
      </button>
      <button
        style="
        height: 75px;
        width: 10vw;
        display: flex;
        justify-content: center;
        align-items: center;
      "
      @click="goTo(3)"
      >
        BUSINESS
      </button>
      <button
        style="
        height: 75px;
        width: 10vw;
        display: flex;
        justify-content: center;
        align-items: center;
      "
      @click="goTo(4)"
      >
        PRODUCTS
      </button>
      <button
        style="
        height: 75px;
        width: 10vw;
        display: flex;
        justify-content: center;
        align-items: center;
      "
      @click="goTo(5)"
      >
        CONTACT US
      </button>
    </div>
    <!-- 여기까지 header -->

    <div
      :style="{ backgroundImage: 'url(' + this.bgImg + ')' }"
      class="container"
    >
    <div v-show="isFlag[4]">
        <Products/>
    </div>
      <div v-show="isHamburger">
        <Slide right width="200">
          <a href="/">
            <span>Home</span>
          </a>
          <a href="/">
            <span>Company</span>
          </a>
          <a href="/">
            <span>Business</span>
          </a>
          <a href="/">
            <span>Product</span>
          </a>
          <a href="/">
            <span>ContactUs</span>
          </a>
        </Slide>
      </div>
      
    </div>
  </div>
</template>

<script>
import { Slide } from "vue-burger-menu";
// import Header from "./Header.vue";
import Products from "./Products.vue";

export default {
  name: "home",
  components: {
    Slide,
    // Header,
    Products,
  },
  data() {
    return {
      bgImg: require(`../assets/images/cruise1.jpg`),
      isFlag: [false, false, false, false, false, false],
      isHamburger: false
    };
  },
  methods: {
    goTo(n){
        this.isFlag = [false,];
        this.isFlag[n] = true;
        this.isHamburger = !this.isFlag[0];
    }
  },
};
</script>

<style>
.bm-overlay {
  background: white;
}
.container {
  width: auto;
  height: 100vh;
  background-size: cover;
  background-position: center;
}
</style>
