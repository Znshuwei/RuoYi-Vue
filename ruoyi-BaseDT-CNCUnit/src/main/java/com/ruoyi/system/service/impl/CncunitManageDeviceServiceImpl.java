package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CncunitManageDeviceMapper;
import com.ruoyi.system.domain.CncunitManageDevice;
import com.ruoyi.system.service.ICncunitManageDeviceService;

/**
 * 设备数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
@Service
public class CncunitManageDeviceServiceImpl implements ICncunitManageDeviceService 
{
    @Autowired
    private CncunitManageDeviceMapper cncunitManageDeviceMapper;

    /**
     * 查询设备数据
     * 
     * @param manageDeviceId 设备数据ID
     * @return 设备数据
     */
    @Override
    public CncunitManageDevice selectCncunitManageDeviceById(String manageDeviceId)
    {
        return cncunitManageDeviceMapper.selectCncunitManageDeviceById(manageDeviceId);
    }

    /**
     * 查询设备数据列表
     * 
     * @param cncunitManageDevice 设备数据
     * @return 设备数据
     */
    @Override
    public List<CncunitManageDevice> selectCncunitManageDeviceList(CncunitManageDevice cncunitManageDevice)
    {
        return cncunitManageDeviceMapper.selectCncunitManageDeviceList(cncunitManageDevice);
    }

    /**
     * 新增设备数据
     * 
     * @param cncunitManageDevice 设备数据
     * @return 结果
     */
    @Override
    public int insertCncunitManageDevice(CncunitManageDevice cncunitManageDevice)
    {
        return cncunitManageDeviceMapper.insertCncunitManageDevice(cncunitManageDevice);
    }

    /**
     * 修改设备数据
     * 
     * @param cncunitManageDevice 设备数据
     * @return 结果
     */
    @Override
    public int updateCncunitManageDevice(CncunitManageDevice cncunitManageDevice)
    {
        return cncunitManageDeviceMapper.updateCncunitManageDevice(cncunitManageDevice);
    }

    /**
     * 批量删除设备数据
     * 
     * @param manageDeviceIds 需要删除的设备数据ID
     * @return 结果
     */
    @Override
    public int deleteCncunitManageDeviceByIds(String[] manageDeviceIds)
    {
        return cncunitManageDeviceMapper.deleteCncunitManageDeviceByIds(manageDeviceIds);
    }

    /**
     * 删除设备数据信息
     * 
     * @param manageDeviceId 设备数据ID
     * @return 结果
     */
    @Override
    public int deleteCncunitManageDeviceById(String manageDeviceId)
    {
        return cncunitManageDeviceMapper.deleteCncunitManageDeviceById(manageDeviceId);
    }
}
