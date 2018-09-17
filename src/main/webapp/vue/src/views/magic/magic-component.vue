<template>
  <div class="panel">
      <component
        v-for="(view,index) in magicComponents"
        :props="view.props"
        :key="index"
        v-bind:is="view.name"
      ></component>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import MagicSingleCol from './magic-single-col'
// import MagicDoubleCol from './magic-double-col'
export default {
  name: 'MagicComponent',
  components: {
    'magic-single-col': MagicSingleCol,
    // 'magic-double-col': MagicDoubleCol
  },
  data() {
    return {
      magicComponents: [
        { name:'magic-single-col', props:{title: "magic-single-col"}},
        // { name:'magic-double-col', props:{title: "magic-double-col"}}
      ]
    }
  },
  computed: {
    ...mapGetters([
    ]),
  },
  watch: {
    // isDragMain: {
    //   handler: function(newer, older) {
        // this.hackReset = false
        // this.$nextTick(function() {
        //   this.hackReset = true
        // })
      // }
    // }
  },
  methods: {
    // dragstart: (e) => {
    //   e.dataTransfer.setData('text', e.target.id)
    // }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .panel{
    width: 20%;
    background: #eee;
    height: 100%;
    height: calc(100vh - 50px);
    padding: 10px;
    display: flex;
    justify-content: space-between;

  }
</style>
