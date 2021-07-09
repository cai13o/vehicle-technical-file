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
 * 机动车维修合同
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VhMaintenanceContract对象", description="机动车维修合同")
public class VhMaintenanceContract implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "托修方（甲方）")
    @TableField("partyA")
    private String partya;

    @ApiModelProperty(value = "承修方（乙方）")
    @TableField("partyB")
    private String partyb;

    @ApiModelProperty(value = "材料提供方式")
    @TableField("supplyMode")
    private String supplymode;

    @ApiModelProperty(value = "车型")
    private String type;

    @ApiModelProperty(value = "牌照号")
    @TableField("licenseNo")
    private String licenseno;

    @ApiModelProperty(value = "底盘号")
    @TableField("chassisNum")
    private String chassisnum;

    @ApiModelProperty(value = "发动机号")
    @TableField("engineNo")
    private String engineno;

    @ApiModelProperty(value = "送修日期")
    @TableField("sendDate")
    private String senddate;

    @ApiModelProperty(value = "接车日期")
    @TableField("pickupDate")
    private String pickupdate;

    @ApiModelProperty(value = "送修方式")
    @TableField("sendWay")
    private String sendway;

    @ApiModelProperty(value = "接车方式")
    @TableField("pickipWay")
    private String pickipway;

    @ApiModelProperty(value = "维修作业项目")
    private String items;

    @ApiModelProperty(value = "维修类别")
    @TableField("serviceCategory")
    private String servicecategory;

    @ApiModelProperty(value = "天")
    private String tdy;

    @ApiModelProperty(value = "公里")
    private String km;

    @ApiModelProperty(value = "现金")
    private String cash;

    @ApiModelProperty(value = "转账")
    private String transfer;

    @ApiModelProperty(value = "银行汇款")
    private String remittance;

    @ApiModelProperty(value = "期限")
    private String expires;

    @ApiModelProperty(value = "甲方盖章签字")
    @TableField("aSignature")
    private String asignature;

    @ApiModelProperty(value = "乙方盖章签字")
    @TableField("bSignature")
    private String bsignature;

    @ApiModelProperty(value = "甲方代表人")
    private String areferee;

    @ApiModelProperty(value = "乙方代表人")
    private String breferee;

    @ApiModelProperty(value = "甲方日期")
    private String adate;

    @ApiModelProperty(value = "乙方日期")
    private String bdate;

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
