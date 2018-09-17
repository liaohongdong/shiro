<template>
  <div class="magic-double-col" draggable="true" @dragstart="dragstart($event)">
    <i class="iconfont icon-duohangchenlie"></i>
    <span class="text">多行列表</span>
  </div>
</template>

<script>
  import randomId from '@/utils/randomId'
  export default {
    name: 'MagicDoubleCol',
    components: {

    },
    data() {
      return {

      }
    },
    computed: {
      getVal: function() {
        return this.$props.props
      }
    },
    watch: {

    },
    methods: {
      dragstart: (e) => {
        e.dataTransfer.setData('text', JSON.stringify({id: randomId(), name: 'double-col'}))
      }
    },
    props: [
      'props'
    ]
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .magic-double-col{
    width: calc(50% - 5px);
    background: #fff;
    height: 100px;
    padding: 10px;
    margin-bottom: 10px;
    display: flex;
    text-align: center;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    i.iconfont{
      font-size: 50px;
    }
    span.text{
      margin-top: 10px;
    }
  }
</style>
