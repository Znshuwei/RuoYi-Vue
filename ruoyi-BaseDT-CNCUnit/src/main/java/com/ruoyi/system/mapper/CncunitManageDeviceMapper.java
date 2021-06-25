package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CncunitManageDevice;

/**
 * 设备数据Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
public interface CncunitManageDeviceMapper 
{
    /**
     * 查询设备数据
     * 
     * @param manageDeviceId 设备数据ID
     * @return 设备数据
     */
    public CncunitManageDevice selectCncunitManageDeviceById(String manageDeviceId);

    /**
     * 查询设备数据列表
     * 
     * @param cncunitManageDevice 设备数据
     * @return 设备数据集合
     */
    public List<CncunitManageDevice> selectCncunitManageDeviceList(CncunitManageDevice cncunitManageDevice);

    /**
     * 新增设备数据
     * 
     * @param cncunitManageDevice 设备数据
     * @return 结果
     */
    public int insertCncunitManageDevice(CncunitManageDevice cncunitManageDevice);

    /**
     * 修改设备数据
     * 
     * @param cncunitManageDevice 设备数据
     * @return 结果
     */
    public int updateCncunitManageDevice(CncunitManageDevice cncunitManageDevice);

    /**
     * 删除设备数据
     * 
     * @param manageDeviceId 设备数据ID
     * @return 结果
     */
    public int deleteCncunitManageDeviceById(String manageDeviceId);

    /**
     * 批量删除设备数据
     * 
     * @param manageDeviceIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCncunitManageDeviceByIds(String[] manageDeviceIds);
}
