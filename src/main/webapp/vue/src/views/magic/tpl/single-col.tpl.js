var mixin = {
  template: `
    <div class="single-col-box" :id="data.id" @click="check($event)">
      <div class="single-col-img">
        <img :src="data.src">
      </div>
      <div class="single-col-wrap">
        <div class="title">
         {{ data.title }}
        </div>
      </div>
    </div>
  `,
  methods: {
    check: function(e) {
      localStorage.setItem('magic_current_data', JSON.stringify(this.origin_data))
      _Vue.$store.dispatch('main_current_attr_clear')
      _Vue.$store.dispatch('main_current_attr_push', [this.data.id, 'title', 'src'])
    }
  },
  computed: {

  },
  data: function() {
    return {
      data: '',
      origin_data: ''
    }
  },
  beforeMount(){
  },
  mounted() {
    let that = this
    var magic_current_data = JSON.parse(localStorage.getItem('magic_current_data'))
    var d = _Vue.$store.state.magic.main_components
    Object.keys(d).forEach(function(key){
      if(d[key].id == magic_current_data.id){
        that.data = d[key].attr
        that.origin_data = d[key]
      }
    });
    that.data.id = magic_current_data.id
    this.magic_current_data = magic_current_data
  },

}

export { mixin }
