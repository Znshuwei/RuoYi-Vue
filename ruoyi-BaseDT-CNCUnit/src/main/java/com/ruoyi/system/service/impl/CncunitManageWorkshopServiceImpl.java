package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CncunitManageWorkshopMapper;
import com.ruoyi.system.domain.CncunitManageWorkshop;
import com.ruoyi.system.service.ICncunitManageWorkshopService;

/**
 * 车间数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
@Service
public class CncunitManageWorkshopServiceImpl implements ICncunitManageWorkshopService 
{
    @Autowired
    private CncunitManageWorkshopMapper cncunitManageWorkshopMapper;

    /**
     * 查询车间数据
     * 
     * @param manageWorkshopId 车间数据ID
     * @return 车间数据
     */
    @Override
    public CncunitManageWorkshop selectCncunitManageWorkshopById(String manageWorkshopId)
    {
        return cncunitManageWorkshopMapper.selectCncunitManageWorkshopById(manageWorkshopId);
    }

    /**
     * 查询车间数据列表
     * 
     * @param cncunitManageWorkshop 车间数据
     * @return 车间数据
     */
    @Override
    public List<CncunitManageWorkshop> selectCncunitManageWorkshopList(CncunitManageWorkshop cncunitManageWorkshop)
    {
        return cncunitManageWorkshopMapper.selectCncunitManageWorkshopList(cncunitManageWorkshop);
    }

    /**
     * 新增车间数据
     * 
     * @param cncunitManageWorkshop 车间数据
     * @return 结果
     */
    @Override
    public int insertCncunitManageWorkshop(CncunitManageWorkshop cncunitManageWorkshop)
    {
        return cncunitManageWorkshopMapper.insertCncunitManageWorkshop(cncunitManageWorkshop);
    }

    /**
     * 修改车间数据
     * 
     * @param cncunitManageWorkshop 车间数据
     * @return 结果
     */
    @Override
    public int updateCncunitManageWorkshop(CncunitManageWorkshop cncunitManageWorkshop)
    {
        return cncunitManageWorkshopMapper.updateCncunitManageWorkshop(cncunitManageWorkshop);
    }

    /**
     * 批量删除车间数据
     * 
     * @param manageWorkshopIds 需要删除的车间数据ID
     * @return 结果
     */
    @Override
    public int deleteCncunitManageWorkshopByIds(String[] manageWorkshopIds)
    {
        return cncunitManageWorkshopMapper.deleteCncunitManageWorkshopByIds(manageWorkshopIds);
    }

    /**
     * 删除车间数据信息
     * 
     * @param manageWorkshopId 车间数据ID
     * @return 结果
     */
    @Override
    public int deleteCncunitManageWorkshopById(String manageWorkshopId)
    {
        return cncunitManageWorkshopMapper.deleteCncunitManageWorkshopById(manageWorkshopId);
    }
}
