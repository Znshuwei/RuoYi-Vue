package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备数据对象 cncunit_manage_device
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
public class CncunitManageDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备ID */
    private String manageDeviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String manageDeviceName;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String manageDeviceModel;

    /** 设备所属车间ID */
    @Excel(name = "设备所属车间ID")
    private String manageDeviceWkshopid;

    /** 设备运行状态 */
    @Excel(name = "设备运行状态")
    private Integer manageDeviceRunstatus;

    /** 设备开始运行日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "设备开始运行日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manageDeviceRundate;

    /** 设备运行时间 */
    @Excel(name = "设备运行时间")
    private BigDecimal manageDeviceRunhours;

    /** 设备报废标志 */
    @Excel(name = "设备报废标志")
    private Integer manageDeviceScrapflag;

    /** 设备删除标志 */
    @Excel(name = "设备删除标志")
    private Integer manageDeviceDelflag;

    /** 备注 */
    @Excel(name = "备注")
    private String manageDeviceRemark;

    public void setManageDeviceId(String manageDeviceId) 
    {
        this.manageDeviceId = manageDeviceId;
    }

    public String getManageDeviceId() 
    {
        return manageDeviceId;
    }
    public void setManageDeviceName(String manageDeviceName) 
    {
        this.manageDeviceName = manageDeviceName;
    }

    public String getManageDeviceName() 
    {
        return manageDeviceName;
    }
    public void setManageDeviceModel(String manageDeviceModel) 
    {
        this.manageDeviceModel = manageDeviceModel;
    }

    public String getManageDeviceModel() 
    {
        return manageDeviceModel;
    }
    public void setManageDeviceWkshopid(String manageDeviceWkshopid) 
    {
        this.manageDeviceWkshopid = manageDeviceWkshopid;
    }

    public String getManageDeviceWkshopid() 
    {
        return manageDeviceWkshopid;
    }
    public void setManageDeviceRunstatus(Integer manageDeviceRunstatus) 
    {
        this.manageDeviceRunstatus = manageDeviceRunstatus;
    }

    public Integer getManageDeviceRunstatus() 
    {
        return manageDeviceRunstatus;
    }
    public void setManageDeviceRundate(Date manageDeviceRundate) 
    {
        this.manageDeviceRundate = manageDeviceRundate;
    }

    public Date getManageDeviceRundate() 
    {
        return manageDeviceRundate;
    }
    public void setManageDeviceRunhours(BigDecimal manageDeviceRunhours) 
    {
        this.manageDeviceRunhours = manageDeviceRunhours;
    }

    public BigDecimal getManageDeviceRunhours() 
    {
        return manageDeviceRunhours;
    }
    public void setManageDeviceScrapflag(Integer manageDeviceScrapflag) 
    {
        this.manageDeviceScrapflag = manageDeviceScrapflag;
    }

    public Integer getManageDeviceScrapflag() 
    {
        return manageDeviceScrapflag;
    }
    public void setManageDeviceDelflag(Integer manageDeviceDelflag) 
    {
        this.manageDeviceDelflag = manageDeviceDelflag;
    }

    public Integer getManageDeviceDelflag() 
    {
        return manageDeviceDelflag;
    }
    public void setManageDeviceRemark(String manageDeviceRemark) 
    {
        this.manageDeviceRemark = manageDeviceRemark;
    }

    public String getManageDeviceRemark() 
    {
        return manageDeviceRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("manageDeviceId", getManageDeviceId())
            .append("manageDeviceName", getManageDeviceName())
            .append("manageDeviceModel", getManageDeviceModel())
            .append("manageDeviceWkshopid", getManageDeviceWkshopid())
            .append("manageDeviceRunstatus", getManageDeviceRunstatus())
            .append("manageDeviceRundate", getManageDeviceRundate())
            .append("manageDeviceRunhours", getManageDeviceRunhours())
            .append("manageDeviceScrapflag", getManageDeviceScrapflag())
            .append("manageDeviceDelflag", getManageDeviceDelflag())
            .append("manageDeviceRemark", getManageDeviceRemark())
            .toString();
    }
}
