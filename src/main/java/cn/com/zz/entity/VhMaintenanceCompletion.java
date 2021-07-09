package cn.com.zz.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 机动车维修竣工出厂合格证
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VhMaintenanceCompletion对象", description="机动车维修竣工出厂合格证")
public class VhMaintenanceCompletion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "托修方")
    private String party;

    @ApiModelProperty(value = "车牌号码")
    @TableField("plateNo")
    private String plateno;

    @ApiModelProperty(value = "车型")
    private String type;

    @ApiModelProperty(value = "发动机型号/编号")
    @TableField("engineModel")
    private String enginemodel;

    @ApiModelProperty(value = "地盘（车身）号")
    @TableField("siteNum")
    private String sitenum;

    @ApiModelProperty(value = "维修类型")
    @TableField("maintenanceTypes")
    private String maintenancetypes;

    @ApiModelProperty(value = "维修合同编号")
    @TableField("contractNo")
    private String contractno;

    @ApiModelProperty(value = "出厂里程表示值")
    private String mileage;

    @ApiModelProperty(value = "质量检验员")
    @TableField("IQCTech")
    private String iqctech;

    @ApiModelProperty(value = "承修单位")
    private String unit;

    @ApiModelProperty(value = "进厂日期")
    @TableField("factoryDate")
    private String factorydate;

    @ApiModelProperty(value = "出厂日期")
    @TableField("manufactureDate")
    private String manufacturedate;

    @ApiModelProperty(value = "托修方接车人")
    private String partypo;

    @ApiModelProperty(value = "接车人")
    @TableField("pickOne")
    private String pickone;

    @ApiModelProperty(value = "接车时间")
    @TableField("pickupTime")
    private String pickupTime;

    @ApiModelProperty(value = "图片")
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

    @ApiModelProperty(value = "竣工合格证编号")
    @TableField("completionNo")
    private String completionno;
}
