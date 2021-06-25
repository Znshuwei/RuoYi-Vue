import request from '@/utils/request'

// 查询设备数据列表
export function listDevice(query) {
  return request({
    url: '/system/device/list',
    method: 'get',
    params: query
  })
}

// 查询设备数据详细
export function getDevice(manageDeviceId) {
  return request({
    url: '/system/device/' + manageDeviceId,
    method: 'get'
  })
}

// 新增设备数据
export function addDevice(data) {
  return request({
    url: '/system/device',
    method: 'post',
    data: data
  })
}

// 修改设备数据
export function updateDevice(data) {
  return request({
    url: '/system/device',
    method: 'put',
    data: data
  })
}

// 删除设备数据
export function delDevice(manageDeviceId) {
  return request({
    url: '/system/device/' + manageDeviceId,
    method: 'delete'
  })
}

// 导出设备数据
export function exportDevice(query) {
  return request({
    url: '/system/device/export',
    method: 'get',
    params: query
  })
}