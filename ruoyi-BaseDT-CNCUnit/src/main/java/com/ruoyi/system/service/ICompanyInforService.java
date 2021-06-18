package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CompanyInfor;

/**
 * 企业管理Service接口
 * 
 * @author ruoyi
 * @date 2021-06-18
 */
public interface ICompanyInforService 
{
    /**
     * 查询企业管理
     * 
     * @param companyId 企业管理ID
     * @return 企业管理
     */
    public CompanyInfor selectCompanyInforById(Integer companyId);

    /**
     * 查询企业管理列表
     * 
     * @param companyInfor 企业管理
     * @return 企业管理集合
     */
    public List<CompanyInfor> selectCompanyInforList(CompanyInfor companyInfor);

    /**
     * 新增企业管理
     * 
     * @param companyInfor 企业管理
     * @return 结果
     */
    public int insertCompanyInfor(CompanyInfor companyInfor);

    /**
     * 修改企业管理
     * 
     * @param companyInfor 企业管理
     * @return 结果
     */
    public int updateCompanyInfor(CompanyInfor companyInfor);

    /**
     * 批量删除企业管理
     * 
     * @param companyIds 需要删除的企业管理ID
     * @return 结果
     */
    public int deleteCompanyInforByIds(Integer[] companyIds);

    /**
     * 删除企业管理信息
     * 
     * @param companyId 企业管理ID
     * @return 结果
     */
    public int deleteCompanyInforById(Integer companyId);
}