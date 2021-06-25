package com.ruoyi.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CncunitManageDevice;
import com.ruoyi.system.service.ICncunitManageDeviceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备数据Controller
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
@RestController
@RequestMapping("/system/device")
public class CncunitManageDeviceController extends BaseController
{
    @Autowired
    private ICncunitManageDeviceService cncunitManageDeviceService;

    /**
     * 查询设备数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(CncunitManageDevice cncunitManageDevice)
    {
        startPage();
        List<CncunitManageDevice> list = cncunitManageDeviceService.selectCncunitManageDeviceList(cncunitManageDevice);
        return getDataTable(list);
    }

    /**
     * 导出设备数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:device:export')")
    @Log(title = "设备数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CncunitManageDevice cncunitManageDevice)
    {
        List<CncunitManageDevice> list = cncunitManageDeviceService.selectCncunitManageDeviceList(cncunitManageDevice);
        ExcelUtil<CncunitManageDevice> util = new ExcelUtil<CncunitManageDevice>(CncunitManageDevice.class);
        return util.exportExcel(list, "设备数据数据");
    }

    /**
     * 获取设备数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:device:query')")
    @GetMapping(value = "/{manageDeviceId}")
    public AjaxResult getInfo(@PathVariable("manageDeviceId") String manageDeviceId)
    {
        return AjaxResult.success(cncunitManageDeviceService.selectCncunitManageDeviceById(manageDeviceId));
    }

    /**
     * 新增设备数据
     */
    @PreAuthorize("@ss.hasPermi('system:device:add')")
    @Log(title = "设备数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CncunitManageDevice cncunitManageDevice)
    {
        return toAjax(cncunitManageDeviceService.insertCncunitManageDevice(cncunitManageDevice));
    }

    /**
     * 修改设备数据
     */
    @PreAuthorize("@ss.hasPermi('system:device:edit')")
    @Log(title = "设备数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CncunitManageDevice cncunitManageDevice)
    {
        return toAjax(cncunitManageDeviceService.updateCncunitManageDevice(cncunitManageDevice));
    }

    /**
     * 删除设备数据
     */
    @PreAuthorize("@ss.hasPermi('system:device:remove')")
    @Log(title = "设备数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{manageDeviceIds}")
    public AjaxResult remove(@PathVariable String[] manageDeviceIds)
    {
        return toAjax(cncunitManageDeviceService.deleteCncunitManageDeviceByIds(manageDeviceIds));
    }
}
