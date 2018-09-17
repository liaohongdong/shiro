var switchTpl = function(name) {
  switch (name) {
    case 'single-col':
      return require('@/views/magic/tpl/single-col.tpl')
    // case 'double-col':
    //   return require('@/views/magic/tpl/double-col.tpl')
    default:
      break
  }
}

export default switchTpl
