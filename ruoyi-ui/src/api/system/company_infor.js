import request from '@/utils/request'

// 查询企业管理列表
export function listCompany_infor(query) {
  return request({
    url: '/system/company_infor/list',
    method: 'get',
    params: query
  })
}

// 查询企业管理详细
export function getCompany_infor(companyId) {
  return request({
    url: '/system/company_infor/' + companyId,
    method: 'get'
  })
}

// 新增企业管理
export function addCompany_infor(data) {
  return request({
    url: '/system/company_infor',
    method: 'post',
    data: data
  })
}

// 修改企业管理
export function updateCompany_infor(data) {
  return request({
    url: '/system/company_infor',
    method: 'put',
    data: data
  })
}

// 删除企业管理
export function delCompany_infor(companyId) {
  return request({
    url: '/system/company_infor/' + companyId,
    method: 'delete'
  })
}

// 导出企业管理
export function exportCompany_infor(query) {
  return request({
    url: '/system/company_infor/export',
    method: 'get',
    params: query
  })
}