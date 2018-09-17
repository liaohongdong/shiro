<template>
<div>
  <div class="single-col-box" v-for="(item, index) in data" :key="index" :id="item.attr.id">
    <div class="single-col-img">
      <img :src="item.attr.src">
    </div>
    <div class="single-col-wrap">
      <div class="title">
        {{ item.attr.title }}
      </div>
    </div>
  </div>
</div>
</template>

<script>
import request from '@/utils/request'
export default {
  name: 'Home',
  data () {
    return {
      data: ''
    }
  },
  methods: {

  },
  mounted() {
    request({
      url: '/api/magic/getMagicIndex',
      method: 'get'
    })
    .then(res=>{
      console.log(res)
      this.data = eval("("+res.data.data+")")
      console.log(this.data)
    })
    .catch(e=>{
      console.log(e)
    })
  },
}
</script>

<style lang="less" scoped>
.single-col-box {
  width: 100%;
  padding: 10px;
  border-bottom: 1px solid #ddd;
  display: flex;
  .single-col-img {
    margin-right: 10px;
    img {
      width: 100px;
    }
  }
  .single-col-wrap {
    .title {
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
    }
  }
}
</style>
