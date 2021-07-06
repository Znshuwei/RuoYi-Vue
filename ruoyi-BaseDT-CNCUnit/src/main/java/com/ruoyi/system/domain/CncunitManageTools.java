package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 刀具数据对象 cncunit_manage_tools
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
public class CncunitManageTools extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 刀具ID
 */
    private String manageToolsId;

    /** 刀具名称 */
    @Excel(name = "刀具名称")
    private String manageToolsName;

    /** 刀具型号 */
    @Excel(name = "刀具型号")
    private String manageToolsModel;

    /** 刀具材料 */
    @Excel(name = "刀具材料")
    private String manageToolsMaterial;

    /** 刀具刃数 */
    @Excel(name = "刀具刃数")
    private Integer manageToolsBlades;

    /** 单支价格 */
    @Excel(name = "单支价格")
    private BigDecimal manageToolsPrice;

    /** 所属车间 */
    @Excel(name = "所属车间")
    private String manageToolsWkshopid;

    /** 库存量 */
    @Excel(name = "库存量")
    private Integer manageToolsNumber;

    /** 备注 */
    @Excel(name = "备注")
    private String manageToolsRemark;

    public void setManageToolsId(String manageToolsId) 
    {
        this.manageToolsId = manageToolsId;
    }

    public String getManageToolsId() 
    {
        return manageToolsId;
    }
    public void setManageToolsName(String manageToolsName) 
    {
        this.manageToolsName = manageToolsName;
    }

    public String getManageToolsName() 
    {
        return manageToolsName;
    }
    public void setManageToolsModel(String manageToolsModel) 
    {
        this.manageToolsModel = manageToolsModel;
    }

    public String getManageToolsModel() 
    {
        return manageToolsModel;
    }
    public void setManageToolsMaterial(String manageToolsMaterial) 
    {
        this.manageToolsMaterial = manageToolsMaterial;
    }

    public String getManageToolsMaterial() 
    {
        return manageToolsMaterial;
    }
    public void setManageToolsBlades(Integer manageToolsBlades) 
    {
        this.manageToolsBlades = manageToolsBlades;
    }

    public Integer getManageToolsBlades() 
    {
        return manageToolsBlades;
    }
    public void setManageToolsPrice(BigDecimal manageToolsPrice) 
    {
        this.manageToolsPrice = manageToolsPrice;
    }

    public BigDecimal getManageToolsPrice() 
    {
        return manageToolsPrice;
    }
    public void setManageToolsWkshopid(String manageToolsWkshopid) 
    {
        this.manageToolsWkshopid = manageToolsWkshopid;
    }

    public String getManageToolsWkshopid() 
    {
        return manageToolsWkshopid;
    }
    public void setManageToolsNumber(Integer manageToolsNumber) 
    {
        this.manageToolsNumber = manageToolsNumber;
    }

    public Integer getManageToolsNumber() 
    {
        return manageToolsNumber;
    }
    public void setManageToolsRemark(String manageToolsRemark) 
    {
        this.manageToolsRemark = manageToolsRemark;
    }

    public String getManageToolsRemark() 
    {
        return manageToolsRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("manageToolsId", getManageToolsId())
            .append("manageToolsName", getManageToolsName())
            .append("manageToolsModel", getManageToolsModel())
            .append("manageToolsMaterial", getManageToolsMaterial())
            .append("manageToolsBlades", getManageToolsBlades())
            .append("manageToolsPrice", getManageToolsPrice())
            .append("manageToolsWkshopid", getManageToolsWkshopid())
            .append("manageToolsNumber", getManageToolsNumber())
            .append("manageToolsRemark", getManageToolsRemark())
            .toString();
    }
}
