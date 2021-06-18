package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CompanyInforMapper;
import com.ruoyi.system.domain.CompanyInfor;
import com.ruoyi.system.service.ICompanyInforService;

/**
 * 企业管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-18
 */
@Service
public class CompanyInforServiceImpl implements ICompanyInforService 
{
    @Autowired
    private CompanyInforMapper companyInforMapper;

    /**
     * 查询企业管理
     * 
     * @param companyId 企业管理ID
     * @return 企业管理
     */
    @Override
    public CompanyInfor selectCompanyInforById(Integer companyId)
    {
        return companyInforMapper.selectCompanyInforById(companyId);
    }

    /**
     * 查询企业管理列表
     * 
     * @param companyInfor 企业管理
     * @return 企业管理
     */
    @Override
    public List<CompanyInfor> selectCompanyInforList(CompanyInfor companyInfor)
    {
        return companyInforMapper.selectCompanyInforList(companyInfor);
    }

    /**
     * 新增企业管理
     * 
     * @param companyInfor 企业管理
     * @return 结果
     */
    @Override
    public int insertCompanyInfor(CompanyInfor companyInfor)
    {
        return companyInforMapper.insertCompanyInfor(companyInfor);
    }

    /**
     * 修改企业管理
     * 
     * @param companyInfor 企业管理
     * @return 结果
     */
    @Override
    public int updateCompanyInfor(CompanyInfor companyInfor)
    {
        return companyInforMapper.updateCompanyInfor(companyInfor);
    }

    /**
     * 批量删除企业管理
     * 
     * @param companyIds 需要删除的企业管理ID
     * @return 结果
     */
    @Override
    public int deleteCompanyInforByIds(Integer[] companyIds)
    {
        return companyInforMapper.deleteCompanyInforByIds(companyIds);
    }

    /**
     * 删除企业管理信息
     * 
     * @param companyId 企业管理ID
     * @return 结果
     */
    @Override
    public int deleteCompanyInforById(Integer companyId)
    {
        return companyInforMapper.deleteCompanyInforById(companyId);
    }
}
