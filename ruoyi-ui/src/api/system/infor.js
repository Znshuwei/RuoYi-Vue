import request from '@/utils/request'

// 查询企业管理列表
export function listInfor(query) {
  return request({
    url: '/system/infor/list',
    method: 'get',
    params: query
  })
}

// 查询企业管理详细
export function getInfor(companyId) {
  return request({
    url: '/system/infor/' + companyId,
    method: 'get'
  })
}

// 新增企业管理
export function addInfor(data) {
  return request({
    url: '/system/infor',
    method: 'post',
    data: data
  })
}

// 修改企业管理
export function updateInfor(data) {
  return request({
    url: '/system/infor',
    method: 'put',
    data: data
  })
}

// 删除企业管理
export function delInfor(companyId) {
  return request({
    url: '/system/infor/' + companyId,
    method: 'delete'
  })
}

// 导出企业管理
export function exportInfor(query) {
  return request({
    url: '/system/infor/export',
    method: 'get',
    params: query
  })
}