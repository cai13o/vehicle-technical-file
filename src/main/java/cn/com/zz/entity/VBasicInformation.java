package cn.com.zz.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 车辆基本情况
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VBasicInformation对象", description="车辆基本情况")
public class VBasicInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "车属单位")
    private String unit;

    @ApiModelProperty(value = "车辆来源")
    private String sources;

    @ApiModelProperty(value = "单位变更1")
    @TableField("unitChange1")
    private String unitchange1;

    @ApiModelProperty(value = "单位变更日期1")
    @TableField("UCDate1")
    private String ucdate1;

    @ApiModelProperty(value = "单位变更2")
    @TableField("unitChange2")
    private String unitchange2;

    @ApiModelProperty(value = "单位变更日期2")
    @TableField("UCDate2")
    private String ucdate2;

    @ApiModelProperty(value = "单位变更3")
    @TableField("unitChange3")
    private String unitchange3;

    @ApiModelProperty(value = "单位变更日期3")
    @TableField("UCDate3")
    private String ucdate3;

    @ApiModelProperty(value = "车牌号码")
    @TableField("plateNo")
    private String plateno;

    @ApiModelProperty(value = "注册日期")
    @TableField("recordDate")
    private String recorddate;

    @ApiModelProperty(value = "运输证编号")
    @TableField("certificateNo")
    private String certificateno;

    @ApiModelProperty(value = "发证日期")
    @TableField("licenceIssued")
    private String licenceissued;

    @ApiModelProperty(value = "牌号变更1")
    @TableField("brandChang1")
    private String brandchang1;

    @ApiModelProperty(value = "牌号变更日期1")
    @TableField("BCDate1")
    private String bcdate1;

    @ApiModelProperty(value = "编号变更1")
    @TableField("numChange1")
    private String numchange1;

    @ApiModelProperty(value = "编号变更日期1")
    @TableField("NCDate1")
    private String ncdate1;

    @ApiModelProperty(value = "牌号变更2")
    @TableField("brandChang2")
    private String brandchang2;

    @ApiModelProperty(value = "牌号变更日期2")
    @TableField("BCDate2")
    private String bcdate2;

    @ApiModelProperty(value = "编号变更2")
    @TableField("numChange2")
    private String numchange2;

    @ApiModelProperty(value = "编号变更日期2")
    @TableField("NCDate2")
    private String ncdate2;

    @ApiModelProperty(value = "牌号变更3")
    @TableField("brandChang3")
    private String brandchang3;

    @ApiModelProperty(value = "牌号变更日期3")
    @TableField("BCDate3")
    private String bcdate3;

    @ApiModelProperty(value = "编号变更3")
    @TableField("numChange3")
    private String numchange3;

    @ApiModelProperty(value = "编号变更日期3")
    @TableField("NCDate3")
    private String ncdate3;

    @ApiModelProperty(value = "出租车计价器型号")
    @TableField("tModel")
    private String tmodel;

    @ApiModelProperty(value = "出租车计价器编号")
    @TableField("tNo")
    private String tno;

    @ApiModelProperty(value = "车牌颜色")
    @TableField("plateColor")
    private String platecolor;

    @ApiModelProperty(value = "经营组织方式")
    @TableField("operationModes")
    private String operationmodes;

    @ApiModelProperty(value = "车辆类型")
    private String type;

    @ApiModelProperty(value = "经营范围")
    private String scope;

    @ApiModelProperty(value = "建档时间")
    @TableField("filingTime")
    private String filingtime;

    @ApiModelProperty(value = "照片")
    private String img;

    @ApiModelProperty(value = "软删除")
    @TableField("isDel")
    @TableLogic
    private String isdel;

    @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "版本号")
    @Version
    private Integer version;

    @ApiModelProperty(value = "vin(或车架)号")
    private String vin;


}
