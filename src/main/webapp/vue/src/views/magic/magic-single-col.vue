<template>
  <div class="magic-single-col" draggable="true" @dragstart="dragstart($event)">
    <i class="iconfont icon-danhangchenlie"></i>
    <span class="text">单行列表</span>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import randomId from '@/utils/randomId'

  export default {
    name: 'MagicSingleCol',
    components: {

    },
    data() {
      return {
      }
    },
    computed: {
      ...mapGetters([
      ]),
      getVal: function() {
        // console.log(this.$props.props)
        return this.$props.props
      }
    },
    watch: {
      isDragMain: {
        handler: function(newer, older) {
          // this.$nextTick(function() {
          //   this.hackReset = true
          // })
        }
      }
    },
    methods: {
      dragstart: (e) => {
        e.dataTransfer.setData('text',
          JSON.stringify(
            {
              id: randomId(),
              name: 'single-col',
              attr: {
                title: '默认文本',
                src: '/static/assets/magic/default-img.png',
              }
            }
          )
        )
      },
    },
    props: [
      'props'
    ]
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .magic-single-col{
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
