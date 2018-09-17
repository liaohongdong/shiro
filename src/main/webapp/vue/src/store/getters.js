const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  token: state => state.user.token,
  avatar: state => state.user.avatar,
  name: state => state.user.name,
  users: state => state.user.users,
  main_components: state => state.magic.main_components,
  main_current_attr: state => state.magic.main_current_attr
}
export default getters
