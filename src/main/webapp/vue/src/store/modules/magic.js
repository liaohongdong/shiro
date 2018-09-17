const magic = {
  state: {
    main_components: [], // 预览里面的数据
    main_current_attr: ''
  },
  mutations: {
    MAIN_COMPONENTS_PUSH: (state, list) => {
      state.main_components.push(list)
    },
    MAIN_COMPOMENTD_CHANGE: (state, list) => {
      let d = state.main_components
      Object.keys(d).forEach(function(key){
        if(d[key].id == list.id){
          d[key].attr = list
        }
      });
    },
    MAIN_CURRENT_ATTR_PUSH: (state, list) => {
      state.main_current_attr = list
    },
    MAIN_CURRENT_ATTR_CLEAR: (state, list) => {
      state.main_current_attr = ''
    }
  },
  actions: {
    main_components_push: ({ commit }, list) => {
      commit('MAIN_COMPONENTS_PUSH', list)
    },
    main_components_change: ({ commit }, list) => {
      commit('MAIN_COMPOMENTD_CHANGE', list)
    },
    main_current_attr_push: ({ commit }, list) => {
      commit('MAIN_CURRENT_ATTR_PUSH', list)
    },
    main_current_attr_clear: ({ commit }) => {
      commit('MAIN_CURRENT_ATTR_CLEAR')
    }
  }
}

export default magic
