import request from '@/utils/request'
import qs from 'qs'

export function save(d) {
  return request({
    url: '/api/magic/save',
    method: 'post',
    data: d
  })

}
