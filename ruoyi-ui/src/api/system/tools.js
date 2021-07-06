import request from '@/utils/request'

// 查询刀具数据列表
export function listTools(query) {
  return request({
    url: '/system/tools/list',
    method: 'get',
    params: query
  })
}

// 查询刀具数据详细
export function getTools(manageToolsId) {
  return request({
    url: '/system/tools/' + manageToolsId,
    method: 'get'
  })
}

// 新增刀具数据
export function addTools(data) {
  return request({
    url: '/system/tools',
    method: 'post',
    data: data
  })
}

// 修改刀具数据
export function updateTools(data) {
  return request({
    url: '/system/tools',
    method: 'put',
    data: data
  })
}

// 删除刀具数据
export function delTools(manageToolsId) {
  return request({
    url: '/system/tools/' + manageToolsId,
    method: 'delete'
  })
}

// 导出刀具数据
export function exportTools(query) {
  return request({
    url: '/system/tools/export',
    method: 'get',
    params: query
  })
}