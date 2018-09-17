<template>
  <div class="panel"
       @drop="drop($event)"
       @dragover="dragover($event)"
  >
    <div class="phone-box">
      <div class="phone-context">
        <img class="phone-bar" src="https://cdn.framework7.io/i/status-bar.png">
        <div class="phone-container">
          <div :id="value.id" v-for="(value, index) in components">{{ value.id }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import randomId from '@/utils/randomId'
import mount from '@/utils/mount'
export default {
  name: 'MagicMain',
  components: {

  },
  data() {
    return {
      // hackReset: true,
      // that: this
      components: []
    }
  },
  computed: {
    ...mapGetters([
    ])
  },
  watch: {

  },
  methods: {
    drop: function(e, that) {
      e.preventDefault()
      var data = JSON.parse(e.dataTransfer.getData('text'))
      console.log(data)
      this.components.push(data)
      this.$store.dispatch('main_components_push', data)
      localStorage.setItem('magic_current_data', JSON.stringify(data))
      mount(data)
    },
    dragover: (e) => {
      e.preventDefault()
    },
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .panel{
    width: 60%;
    background: #ddd;
    height: 100%;
    height: calc(100vh - 50px);
    display: flex;
    align-items: center;
    .phone-box{
      position: relative;
      display: flex;
      align-items: center;
      width: 425px;
      /*height: calc(100vh - 100px);*/
      height: 800px;
      background: #fff;
      margin: 0 auto;
      background: #111;
      border-radius: 55px;
      box-shadow: 0px 0px 0px 5px #aaa;
      &:before{
        content: '';
        width: 60px;
        height: 10px;
        border-radius: 10px;
        position: absolute;
        left: 50%;
        margin-left: -30px;
        background: #333;
        top: 50px;
      }
      &:after{
        content: '';
        position: absolute;
        width: 50px;
        height: 50px;
        left: 50%;
        margin-left: -25px;
        bottom: 20px;
        border-radius: 100%;
        box-sizing: border-box;
        border: 3px solid #333;
      }
      .phone-context{
        width: 375px;
        border-radius: 4px;
        margin: 0 auto;
        background: #fff;
        height: calc(100% - 150px);
        img.phone-bar{
          display: block;
          width: 100%;
        }
      }
    }
  }
</style>

<style rel="stylesheet/scss" lang="scss">
  li{
    cursor: copy;
    &.col-one{
      width: 200px;
      height: 200px;
      line-height: 50px;
      text-align: center;
      color: #000;
      border: 1px solid #000;
      box-sizing: border-box;
    }
  }
</style>
