import request from '@/utils/request'

// 查询车间数据列表
export function listWorkshop(query) {
  return request({
    url: '/system/workshop/list',
    method: 'get',
    params: query
  })
}

// 查询车间数据详细
export function getWorkshop(manageWorkshopId) {
  return request({
    url: '/system/workshop/' + manageWorkshopId,
    method: 'get'
  })
}

// 新增车间数据
export function addWorkshop(data) {
  return request({
    url: '/system/workshop',
    method: 'post',
    data: data
  })
}

// 修改车间数据
export function updateWorkshop(data) {
  return request({
    url: '/system/workshop',
    method: 'put',
    data: data
  })
}

// 删除车间数据
export function delWorkshop(manageWorkshopId) {
  return request({
    url: '/system/workshop/' + manageWorkshopId,
    method: 'delete'
  })
}

// 导出车间数据
export function exportWorkshop(query) {
  return request({
    url: '/system/workshop/export',
    method: 'get',
    params: query
  })
}