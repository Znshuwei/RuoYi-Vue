package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CncunitManageTools;

/**
 * 刀具数据Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
public interface CncunitManageToolsMapper 
{
    /**
     * 查询刀具数据
     * 
     * @param manageToolsId 刀具数据ID
     * @return 刀具数据
     */
    public CncunitManageTools selectCncunitManageToolsById(String manageToolsId);

    /**
     * 查询刀具数据列表
     * 
     * @param cncunitManageTools 刀具数据
     * @return 刀具数据集合
     */
    public List<CncunitManageTools> selectCncunitManageToolsList(CncunitManageTools cncunitManageTools);

    /**
     * 新增刀具数据
     * 
     * @param cncunitManageTools 刀具数据
     * @return 结果
     */
    public int insertCncunitManageTools(CncunitManageTools cncunitManageTools);

    /**
     * 修改刀具数据
     * 
     * @param cncunitManageTools 刀具数据
     * @return 结果
     */
    public int updateCncunitManageTools(CncunitManageTools cncunitManageTools);

    /**
     * 删除刀具数据
     * 
     * @param manageToolsId 刀具数据ID
     * @return 结果
     */
    public int deleteCncunitManageToolsById(String manageToolsId);

    /**
     * 批量删除刀具数据
     * 
     * @param manageToolsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCncunitManageToolsByIds(String[] manageToolsIds);
}
