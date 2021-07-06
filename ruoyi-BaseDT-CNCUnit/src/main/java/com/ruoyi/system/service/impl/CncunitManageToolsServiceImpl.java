package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CncunitManageToolsMapper;
import com.ruoyi.system.domain.CncunitManageTools;
import com.ruoyi.system.service.ICncunitManageToolsService;

/**
 * 刀具数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
@Service
public class CncunitManageToolsServiceImpl implements ICncunitManageToolsService 
{
    @Autowired
    private CncunitManageToolsMapper cncunitManageToolsMapper;

    /**
     * 查询刀具数据
     * 
     * @param manageToolsId 刀具数据ID
     * @return 刀具数据
     */
    @Override
    public CncunitManageTools selectCncunitManageToolsById(String manageToolsId)
    {
        return cncunitManageToolsMapper.selectCncunitManageToolsById(manageToolsId);
    }

    /**
     * 查询刀具数据列表
     * 
     * @param cncunitManageTools 刀具数据
     * @return 刀具数据
     */
    @Override
    public List<CncunitManageTools> selectCncunitManageToolsList(CncunitManageTools cncunitManageTools)
    {
        return cncunitManageToolsMapper.selectCncunitManageToolsList(cncunitManageTools);
    }

    /**
     * 新增刀具数据
     * 
     * @param cncunitManageTools 刀具数据
     * @return 结果
     */
    @Override
    public int insertCncunitManageTools(CncunitManageTools cncunitManageTools)
    {
        return cncunitManageToolsMapper.insertCncunitManageTools(cncunitManageTools);
    }

    /**
     * 修改刀具数据
     * 
     * @param cncunitManageTools 刀具数据
     * @return 结果
     */
    @Override
    public int updateCncunitManageTools(CncunitManageTools cncunitManageTools)
    {
        return cncunitManageToolsMapper.updateCncunitManageTools(cncunitManageTools);
    }

    /**
     * 批量删除刀具数据
     * 
     * @param manageToolsIds 需要删除的刀具数据ID
     * @return 结果
     */
    @Override
    public int deleteCncunitManageToolsByIds(String[] manageToolsIds)
    {
        return cncunitManageToolsMapper.deleteCncunitManageToolsByIds(manageToolsIds);
    }

    /**
     * 删除刀具数据信息
     * 
     * @param manageToolsId 刀具数据ID
     * @return 结果
     */
    @Override
    public int deleteCncunitManageToolsById(String manageToolsId)
    {
        return cncunitManageToolsMapper.deleteCncunitManageToolsById(manageToolsId);
    }
}
