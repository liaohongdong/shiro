var randomId = () => {
  function str() {
    return Math.floor((1 + Math.random()) * 0x10000)
      .toString(16)
      .substring(1)
  }
  return str() + str() + '-' + str()
}
export default randomId
