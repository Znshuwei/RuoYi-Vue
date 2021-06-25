package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车间数据对象 cncunit_manage_workshop
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
public class CncunitManageWorkshop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车间编号 */
    private String manageWorkshopId;

    /** 车间名称 */
    @Excel(name = "车间名称")
    private String manageWorkshopName;

    /** 车间地区 */
    @Excel(name = "车间地区")
    private String manageWorkshopArea;

    /** 车间地址 */
    @Excel(name = "车间地址")
    private String manageWorkshopAddress;

    /** 车间负责人 */
    @Excel(name = "车间负责人")
    private String manageWorkshopManager;

    /** 负责人联系方式 */
    @Excel(name = "负责人联系方式")
    private String manageWorkshopMngphone;

    /** 车间注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车间注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manageWorkshopCreatetime;

    /** 车间状态flag */
    @Excel(name = "车间状态flag")
    private String manageWorkshopStatusflag;

    /** 删除标志 */
    @Excel(name = "删除标志")
    private Integer manageWorkshopDelflag;

    /** 备注 */
    @Excel(name = "备注")
    private String manageWorkshopRemark;

    public void setManageWorkshopId(String manageWorkshopId) 
    {
        this.manageWorkshopId = manageWorkshopId;
    }

    public String getManageWorkshopId() 
    {
        return manageWorkshopId;
    }
    public void setManageWorkshopName(String manageWorkshopName) 
    {
        this.manageWorkshopName = manageWorkshopName;
    }

    public String getManageWorkshopName() 
    {
        return manageWorkshopName;
    }
    public void setManageWorkshopArea(String manageWorkshopArea) 
    {
        this.manageWorkshopArea = manageWorkshopArea;
    }

    public String getManageWorkshopArea() 
    {
        return manageWorkshopArea;
    }
    public void setManageWorkshopAddress(String manageWorkshopAddress) 
    {
        this.manageWorkshopAddress = manageWorkshopAddress;
    }

    public String getManageWorkshopAddress() 
    {
        return manageWorkshopAddress;
    }
    public void setManageWorkshopManager(String manageWorkshopManager) 
    {
        this.manageWorkshopManager = manageWorkshopManager;
    }

    public String getManageWorkshopManager() 
    {
        return manageWorkshopManager;
    }
    public void setManageWorkshopMngphone(String manageWorkshopMngphone) 
    {
        this.manageWorkshopMngphone = manageWorkshopMngphone;
    }

    public String getManageWorkshopMngphone() 
    {
        return manageWorkshopMngphone;
    }
    public void setManageWorkshopCreatetime(Date manageWorkshopCreatetime) 
    {
        this.manageWorkshopCreatetime = manageWorkshopCreatetime;
    }

    public Date getManageWorkshopCreatetime() 
    {
        return manageWorkshopCreatetime;
    }
    public void setManageWorkshopStatusflag(String manageWorkshopStatusflag) 
    {
        this.manageWorkshopStatusflag = manageWorkshopStatusflag;
    }

    public String getManageWorkshopStatusflag() 
    {
        return manageWorkshopStatusflag;
    }
    public void setManageWorkshopDelflag(Integer manageWorkshopDelflag) 
    {
        this.manageWorkshopDelflag = manageWorkshopDelflag;
    }

    public Integer getManageWorkshopDelflag() 
    {
        return manageWorkshopDelflag;
    }
    public void setManageWorkshopRemark(String manageWorkshopRemark) 
    {
        this.manageWorkshopRemark = manageWorkshopRemark;
    }

    public String getManageWorkshopRemark() 
    {
        return manageWorkshopRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("manageWorkshopId", getManageWorkshopId())
            .append("manageWorkshopName", getManageWorkshopName())
            .append("manageWorkshopArea", getManageWorkshopArea())
            .append("manageWorkshopAddress", getManageWorkshopAddress())
            .append("manageWorkshopManager", getManageWorkshopManager())
            .append("manageWorkshopMngphone", getManageWorkshopMngphone())
            .append("manageWorkshopCreatetime", getManageWorkshopCreatetime())
            .append("manageWorkshopStatusflag", getManageWorkshopStatusflag())
            .append("manageWorkshopDelflag", getManageWorkshopDelflag())
            .append("manageWorkshopRemark", getManageWorkshopRemark())
            .toString();
    }
}
