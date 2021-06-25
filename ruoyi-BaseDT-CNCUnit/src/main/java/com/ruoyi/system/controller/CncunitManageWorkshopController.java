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
import com.ruoyi.system.domain.CncunitManageWorkshop;
import com.ruoyi.system.service.ICncunitManageWorkshopService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车间数据Controller
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
@RestController
@RequestMapping("/system/workshop")
public class CncunitManageWorkshopController extends BaseController
{
    @Autowired
    private ICncunitManageWorkshopService cncunitManageWorkshopService;

    /**
     * 查询车间数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:workshop:list')")
    @GetMapping("/list")
    public TableDataInfo list(CncunitManageWorkshop cncunitManageWorkshop)
    {
        startPage();
        List<CncunitManageWorkshop> list = cncunitManageWorkshopService.selectCncunitManageWorkshopList(cncunitManageWorkshop);
        return getDataTable(list);
    }

    /**
     * 导出车间数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:workshop:export')")
    @Log(title = "车间数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CncunitManageWorkshop cncunitManageWorkshop)
    {
        List<CncunitManageWorkshop> list = cncunitManageWorkshopService.selectCncunitManageWorkshopList(cncunitManageWorkshop);
        ExcelUtil<CncunitManageWorkshop> util = new ExcelUtil<CncunitManageWorkshop>(CncunitManageWorkshop.class);
        return util.exportExcel(list, "车间数据数据");
    }

    /**
     * 获取车间数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:workshop:query')")
    @GetMapping(value = "/{manageWorkshopId}")
    public AjaxResult getInfo(@PathVariable("manageWorkshopId") String manageWorkshopId)
    {
        return AjaxResult.success(cncunitManageWorkshopService.selectCncunitManageWorkshopById(manageWorkshopId));
    }

    /**
     * 新增车间数据
     */
    @PreAuthorize("@ss.hasPermi('system:workshop:add')")
    @Log(title = "车间数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CncunitManageWorkshop cncunitManageWorkshop)
    {
        return toAjax(cncunitManageWorkshopService.insertCncunitManageWorkshop(cncunitManageWorkshop));
    }

    /**
     * 修改车间数据
     */
    @PreAuthorize("@ss.hasPermi('system:workshop:edit')")
    @Log(title = "车间数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CncunitManageWorkshop cncunitManageWorkshop)
    {
        return toAjax(cncunitManageWorkshopService.updateCncunitManageWorkshop(cncunitManageWorkshop));
    }

    /**
     * 删除车间数据
     */
    @PreAuthorize("@ss.hasPermi('system:workshop:remove')")
    @Log(title = "车间数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{manageWorkshopIds}")
    public AjaxResult remove(@PathVariable String[] manageWorkshopIds)
    {
        return toAjax(cncunitManageWorkshopService.deleteCncunitManageWorkshopByIds(manageWorkshopIds));
    }
}
