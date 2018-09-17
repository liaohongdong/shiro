<template>
  <div class="panel">
    <!--{{ main_components | isLeng }}-->
    <div v-if="main_components" v-for="(v,k,i) in main_current_attr">
      <el-input v-if="v == 'title'" placeholder="请输入标题" v-model="data.title">
        <template slot="prepend">标题</template>
      </el-input>
      <el-input v-if="v == 'src'" placeholder="请输入链接" v-model="data.src">
        <template slot="prepend">链接</template>
      </el-input>
      <el-input v-if="v == 'class'" placeholder="请输入链接">
        <template slot="prepend">类名</template>
      </el-input>
    </div>
    <el-button v-if="main_current_attr" type="danger" @click="submit($event)">确认</el-button>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { save } from '@/api/magic'
export default {
  name: 'MagicAttr',
  components: {
  },
  data() {
    return {
      data: '',
    }
  },
  computed: {
    ...mapGetters([
      'main_components',
      'main_current_attr'
    ]),
    setData: function() {

      let that = this
      let d = this.main_components
      let magic_current_data = JSON.parse(localStorage.getItem('magic_current_data'))
      Object.keys(d).forEach(function(key){
        if(d[key].id == magic_current_data.id){
          that.data = d[key].attr
        }
      });
    }
  },
  mounted(){
    // var magic = _Vue.$store.state.magic.main_components
    // this.data = magic.attr
    // console.log(magic)
    // console.log(this.main_components)
  },
  watch: {
    main_current_attr: function(n, o) {
      let that = this
      let d = this.main_components
      Object.keys(d).forEach(function(key){
        if(d[key].id == n[0]){
          that.data = d[key].attr
        }
      });
    }
  },
  methods: {
    showAttr: function(e) {
      console.log(this.main_components, e,  123)
    },
    submit: function(e) {
      let that = this
      let magic_current_data = JSON.parse(localStorage.getItem('magic_current_data'))
      let d = this.main_components
      Object.keys(d).forEach(function(key){
        if(d[key].id == magic_current_data.id){
          that.$store.dispatch('main_components_change', that.data)
        }
      });
      save(that.$store.state.magic.main_components)
        .then(res => {
          console.log(res)
          if(res.code == 20000){
            const h = that.$createElement;
            this.$notify({
              title: '通知',
              message: h('i', { style: 'color: teal'}, '保存成功')
            });
          }
        })
        .catch(error => {
          console.log(error)
        })
    }
  },
  filters: {
    isLeng: function(val) {
      return val.length == 0 ? '' : val
    }
  }


}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .panel{
    width: 20%;
    background: #eee;
    height: 100%;
    height: calc(100vh - 50px);
  }
</style>
