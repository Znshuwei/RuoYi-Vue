package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 企业管理对象 company_infor
 * 
 * @author ruoyi
 * @date 2021-06-18
 */
public class CompanyInfor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 企业ID */
    private Integer companyId;

    /** 企业编码 */
    @Excel(name = "企业编码")
    private String companyCode;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String companyName;

    /** 省 */
    @Excel(name = "省")
    private String companyProvince;

    /** 市 */
    @Excel(name = "市")
    private String companyCity;

    /** 县 */
    @Excel(name = "县")
    private String companyConty;

    /** 地址 */
    @Excel(name = "地址")
    private String companyAddress;

    /** 联系人 */
    @Excel(name = "联系人")
    private String companyLinkmain;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String companyPhone;

    /** 建立时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "建立时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date companySetuptime;

    /** 企业性质 */
    @Excel(name = "企业性质")
    private String companyNature;

    /** 注册资金（万元） */
    @Excel(name = "注册资金", readConverterExp = "万=元")
    private Long companyRegmoney;

    /** 固定资产（万元） */
    @Excel(name = "固定资产", readConverterExp = "万=元")
    private Long companyFxedassets;

    /** 网址 */
    @Excel(name = "网址")
    private String companyUrl;

    /** 电子邮件地址 */
    @Excel(name = "电子邮件地址")
    private String companyEmail;

    /** 注册人 */
    @Excel(name = "注册人")
    private String companyCreateperson;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date companyCreatedate;

    /** 删除标志 */
    @Excel(name = "删除标志")
    private Integer companyDelflag;

    public void setCompanyId(Integer companyId) 
    {
        this.companyId = companyId;
    }

    public Integer getCompanyId() 
    {
        return companyId;
    }
    public void setCompanyCode(String companyCode) 
    {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() 
    {
        return companyCode;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanyProvince(String companyProvince) 
    {
        this.companyProvince = companyProvince;
    }

    public String getCompanyProvince() 
    {
        return companyProvince;
    }
    public void setCompanyCity(String companyCity) 
    {
        this.companyCity = companyCity;
    }

    public String getCompanyCity() 
    {
        return companyCity;
    }
    public void setCompanyConty(String companyConty) 
    {
        this.companyConty = companyConty;
    }

    public String getCompanyConty() 
    {
        return companyConty;
    }
    public void setCompanyAddress(String companyAddress) 
    {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress() 
    {
        return companyAddress;
    }
    public void setCompanyLinkmain(String companyLinkmain) 
    {
        this.companyLinkmain = companyLinkmain;
    }

    public String getCompanyLinkmain() 
    {
        return companyLinkmain;
    }
    public void setCompanyPhone(String companyPhone) 
    {
        this.companyPhone = companyPhone;
    }

    public String getCompanyPhone() 
    {
        return companyPhone;
    }
    public void setCompanySetuptime(Date companySetuptime) 
    {
        this.companySetuptime = companySetuptime;
    }

    public Date getCompanySetuptime() 
    {
        return companySetuptime;
    }
    public void setCompanyNature(String companyNature) 
    {
        this.companyNature = companyNature;
    }

    public String getCompanyNature() 
    {
        return companyNature;
    }
    public void setCompanyRegmoney(Long companyRegmoney) 
    {
        this.companyRegmoney = companyRegmoney;
    }

    public Long getCompanyRegmoney() 
    {
        return companyRegmoney;
    }
    public void setCompanyFxedassets(Long companyFxedassets) 
    {
        this.companyFxedassets = companyFxedassets;
    }

    public Long getCompanyFxedassets() 
    {
        return companyFxedassets;
    }
    public void setCompanyUrl(String companyUrl) 
    {
        this.companyUrl = companyUrl;
    }

    public String getCompanyUrl() 
    {
        return companyUrl;
    }
    public void setCompanyEmail(String companyEmail) 
    {
        this.companyEmail = companyEmail;
    }

    public String getCompanyEmail() 
    {
        return companyEmail;
    }
    public void setCompanyCreateperson(String companyCreateperson) 
    {
        this.companyCreateperson = companyCreateperson;
    }

    public String getCompanyCreateperson() 
    {
        return companyCreateperson;
    }
    public void setCompanyCreatedate(Date companyCreatedate) 
    {
        this.companyCreatedate = companyCreatedate;
    }

    public Date getCompanyCreatedate() 
    {
        return companyCreatedate;
    }
    public void setCompanyDelflag(Integer companyDelflag) 
    {
        this.companyDelflag = companyDelflag;
    }

    public Integer getCompanyDelflag() 
    {
        return companyDelflag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("companyCode", getCompanyCode())
            .append("companyName", getCompanyName())
            .append("companyProvince", getCompanyProvince())
            .append("companyCity", getCompanyCity())
            .append("companyConty", getCompanyConty())
            .append("companyAddress", getCompanyAddress())
            .append("companyLinkmain", getCompanyLinkmain())
            .append("companyPhone", getCompanyPhone())
            .append("companySetuptime", getCompanySetuptime())
            .append("companyNature", getCompanyNature())
            .append("companyRegmoney", getCompanyRegmoney())
            .append("companyFxedassets", getCompanyFxedassets())
            .append("companyUrl", getCompanyUrl())
            .append("companyEmail", getCompanyEmail())
            .append("companyCreateperson", getCompanyCreateperson())
            .append("companyCreatedate", getCompanyCreatedate())
            .append("companyDelflag", getCompanyDelflag())
            .toString();
    }
}
