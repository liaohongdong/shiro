import Vue from 'vue'

import switchTpl from '@/utils/switch_tpl'

//给定模板，和要挂载的元素id，挂载组件
var mount = function(data, _com) {
  // console.log(_Vue)
  return new Promise((res, rej) => {
    setTimeout(function() {
      var dataSource = switchTpl(data.name)
      let vm = new Vue({
        name: data.name,
        el: document.getElementById(data.id),
        template: dataSource.mixin.template,
        data(){
        },
        mounted() {

        },
        method() {
        },
        mixins: [ dataSource.mixin ]
      })
      res(vm)
    }, 1)

  })
}
export default mount
