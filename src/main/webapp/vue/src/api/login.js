import request from '@/utils/request'
import qs from 'qs'

export function login(username, password) {
  return request({
    // url: '/user/login',
    url: '/api/admin/doLogin?' + qs.stringify({
      username: username,
      password: password
    }),
    method: 'get'
    // data: {
    //   username,
    //   password
    // }
  })
}

export function getInfo(token) {
  return request({
    // url: '/user/info',
    url: '/api/sys/user/getAll',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/admin/logout',
    method: 'get'
  })
}
