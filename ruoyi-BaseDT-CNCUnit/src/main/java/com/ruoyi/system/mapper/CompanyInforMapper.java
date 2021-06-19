package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CompanyInfor;

/**
 * 用户管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-18
 */
public interface CompanyInforMapper 
{
    /**
     * 查询用户管理
     * 
     * @param companyId 用户管理ID
     * @return 用户管理
     */
    public CompanyInfor selectCompanyInforById(Integer companyId);

    /**
     * 查询用户管理列表
     * 
     * @param companyInfor 用户管理
     * @return 用户管理集合
     */
    public List<CompanyInfor> selectCompanyInforList(CompanyInfor companyInfor);

    /**
     * 新增用户管理
     * 
     * @param companyInfor 用户管理
     * @return 结果
     */
    public int insertCompanyInfor(CompanyInfor companyInfor);

    /**
     * 修改用户管理
     * 
     * @param companyInfor 用户管理
     * @return 结果
     */
    public int updateCompanyInfor(CompanyInfor companyInfor);

    /**
     * 删除用户管理
     * 
     * @param companyId 用户管理ID
     * @return 结果
     */
    public int deleteCompanyInforById(Integer companyId);

    /**
     * 批量删除用户管理
     * 
     * @param companyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCompanyInforByIds(Integer[] companyIds);
}
