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
import com.ruoyi.system.domain.CompanyInfor;
import com.ruoyi.system.service.ICompanyInforService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 企业管理Controller
 * 
 * @author ruoyi
 * @date 2021-06-18
 */
@RestController
@RequestMapping("/system/company_infor")
public class CompanyInforController extends BaseController
{
    @Autowired
    private ICompanyInforService companyInforService;

    /**
     * 查询企业管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:company_infor:list')")
    @GetMapping("/list")
    public TableDataInfo list(CompanyInfor companyInfor)
    {
        startPage();
        List<CompanyInfor> list = companyInforService.selectCompanyInforList(companyInfor);
        return getDataTable(list);
    }

    /**
     * 导出企业管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:company_infor:export')")
    @Log(title = "企业管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CompanyInfor companyInfor)
    {
        List<CompanyInfor> list = companyInforService.selectCompanyInforList(companyInfor);
        ExcelUtil<CompanyInfor> util = new ExcelUtil<CompanyInfor>(CompanyInfor.class);
        return util.exportExcel(list, "企业管理数据");
    }

    /**
     * 获取企业管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:company_infor:query')")
    @GetMapping(value = "/{companyId}")
    public AjaxResult getInfo(@PathVariable("companyId") Integer companyId)
    {
        return AjaxResult.success(companyInforService.selectCompanyInforById(companyId));
    }

    /**
     * 新增企业管理
     */
    @PreAuthorize("@ss.hasPermi('system:company_infor:add')")
    @Log(title = "企业管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CompanyInfor companyInfor)
    {
        return toAjax(companyInforService.insertCompanyInfor(companyInfor));
    }

    /**
     * 修改企业管理
     */
    @PreAuthorize("@ss.hasPermi('system:company_infor:edit')")
    @Log(title = "企业管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CompanyInfor companyInfor)
    {
        return toAjax(companyInforService.updateCompanyInfor(companyInfor));
    }

    /**
     * 删除企业管理
     */
    @PreAuthorize("@ss.hasPermi('system:company_infor:remove')")
    @Log(title = "企业管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{companyIds}")
    public AjaxResult remove(@PathVariable Integer[] companyIds)
    {
        return toAjax(companyInforService.deleteCompanyInforByIds(companyIds));
    }
}
