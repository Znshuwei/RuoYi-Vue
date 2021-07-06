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
import com.ruoyi.system.domain.CncunitManageTools;
import com.ruoyi.system.service.ICncunitManageToolsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 刀具数据Controller
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
@RestController
@RequestMapping("/system/tools")
public class CncunitManageToolsController extends BaseController
{
    @Autowired
    private ICncunitManageToolsService cncunitManageToolsService;

    /**
     * 查询刀具数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:tools:list')")
    @GetMapping("/list")
    public TableDataInfo list(CncunitManageTools cncunitManageTools)
    {
        startPage();
        List<CncunitManageTools> list = cncunitManageToolsService.selectCncunitManageToolsList(cncunitManageTools);
        return getDataTable(list);
    }

    /**
     * 导出刀具数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:tools:export')")
    @Log(title = "刀具数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CncunitManageTools cncunitManageTools)
    {
        List<CncunitManageTools> list = cncunitManageToolsService.selectCncunitManageToolsList(cncunitManageTools);
        ExcelUtil<CncunitManageTools> util = new ExcelUtil<CncunitManageTools>(CncunitManageTools.class);
        return util.exportExcel(list, "刀具数据数据");
    }

    /**
     * 获取刀具数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tools:query')")
    @GetMapping(value = "/{manageToolsId}")
    public AjaxResult getInfo(@PathVariable("manageToolsId") String manageToolsId)
    {
        return AjaxResult.success(cncunitManageToolsService.selectCncunitManageToolsById(manageToolsId));
    }

    /**
     * 新增刀具数据
     */
    @PreAuthorize("@ss.hasPermi('system:tools:add')")
    @Log(title = "刀具数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CncunitManageTools cncunitManageTools)
    {
        return toAjax(cncunitManageToolsService.insertCncunitManageTools(cncunitManageTools));
    }

    /**
     * 修改刀具数据
     */
    @PreAuthorize("@ss.hasPermi('system:tools:edit')")
    @Log(title = "刀具数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CncunitManageTools cncunitManageTools)
    {
        return toAjax(cncunitManageToolsService.updateCncunitManageTools(cncunitManageTools));
    }

    /**
     * 删除刀具数据
     */
    @PreAuthorize("@ss.hasPermi('system:tools:remove')")
    @Log(title = "刀具数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{manageToolsIds}")
    public AjaxResult remove(@PathVariable String[] manageToolsIds)
    {
        return toAjax(cncunitManageToolsService.deleteCncunitManageToolsByIds(manageToolsIds));
    }
}
