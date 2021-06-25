package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CncunitManageWorkshop;

/**
 * 车间数据Service接口
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
public interface ICncunitManageWorkshopService 
{
    /**
     * 查询车间数据
     * 
     * @param manageWorkshopId 车间数据ID
     * @return 车间数据
     */
    public CncunitManageWorkshop selectCncunitManageWorkshopById(String manageWorkshopId);

    /**
     * 查询车间数据列表
     * 
     * @param cncunitManageWorkshop 车间数据
     * @return 车间数据集合
     */
    public List<CncunitManageWorkshop> selectCncunitManageWorkshopList(CncunitManageWorkshop cncunitManageWorkshop);

    /**
     * 新增车间数据
     * 
     * @param cncunitManageWorkshop 车间数据
     * @return 结果
     */
    public int insertCncunitManageWorkshop(CncunitManageWorkshop cncunitManageWorkshop);

    /**
     * 修改车间数据
     * 
     * @param cncunitManageWorkshop 车间数据
     * @return 结果
     */
    public int updateCncunitManageWorkshop(CncunitManageWorkshop cncunitManageWorkshop);

    /**
     * 批量删除车间数据
     * 
     * @param manageWorkshopIds 需要删除的车间数据ID
     * @return 结果
     */
    public int deleteCncunitManageWorkshopByIds(String[] manageWorkshopIds);

    /**
     * 删除车间数据信息
     * 
     * @param manageWorkshopId 车间数据ID
     * @return 结果
     */
    public int deleteCncunitManageWorkshopById(String manageWorkshopId);
}
