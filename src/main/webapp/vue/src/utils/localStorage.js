var lsGet = function(d) {
  return JSON.parse(localStorage.getItem(d))
}

var lsSet = function(n, d) {
  localStorage.setItem(n, JSON.stringify(d))
}

export { lsGet, lsSet}
