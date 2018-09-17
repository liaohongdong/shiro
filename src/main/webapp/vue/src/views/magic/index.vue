<template>
  <div class="magic-index">
    <magic-component></magic-component>
    <magic-main></magic-main>
    <magic-attr></magic-attr>
  </div>
</template>

<script>
import MagicComponent from './magic-component'
import MagicMain from './magic-main'
import MagicAttr from './magic-attr'

export default {
  name: 'Index',
  components: {
    MagicComponent,
    MagicMain,
    MagicAttr
  },
  data() {
    return {

    }
  },
  computed: {

  },
  watch: {

  },
  methods: {

  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .magic-index{
    display: flex;
    height: 100%;
  }
</style>
