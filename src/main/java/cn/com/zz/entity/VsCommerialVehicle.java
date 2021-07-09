package cn.com.zz.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 营运车辆
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VsCommerialVehicle对象", description="营运车辆")
public class VsCommerialVehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "业户ID")
    private String oid;

    @ApiModelProperty(value = "车辆（挂车）号牌")
    @TableField("plateNo")
    private String plateno;

    @ApiModelProperty(value = "车牌颜色")
    private String color;

    @ApiModelProperty(value = "车辆厂牌型号")
    private String model;

    @ApiModelProperty(value = "发动机号")
    @TableField("engineNo")
    private String engineno;

    @ApiModelProperty(value = "车辆识别VIN码")
    private String vin;

    @ApiModelProperty(value = "车辆类型")
    private String type;

    @ApiModelProperty(value = "客车类型与等级")
    @TableField("chassisModel")
    private String chassismodel;

    @ApiModelProperty(value = "注册日期")
    @TableField("recordDate")
    private String recorddate;

    @ApiModelProperty(value = "车辆燃料类型")
    @TableField("fuelType")
    private String fueltype;

    @ApiModelProperty(value = "车辆车长")
    private String conductor;

    @ApiModelProperty(value = "车辆车宽")
    private String wide;

    @ApiModelProperty(value = "车辆车高")
    private String high;

    @ApiModelProperty(value = "车辆车轴数")
    private String axles;

    @ApiModelProperty(value = "准牵引总质量")
    @TableField("tractionMass")
    private String tractionmass;

    @ApiModelProperty(value = "核定载客位数")
    private String complements;

    @ApiModelProperty(value = "核定载质量")
    private String loadkg;

    @ApiModelProperty(value = "车辆（挂车）总质量")
    private String kg;

    @ApiModelProperty(value = "车辆营运状态")
    private String status;

    @ApiModelProperty(value = "车籍所在机构")
    private String organization;

    @ApiModelProperty(value = "创建时间")
    @TableField("createDate")
    private String createdate;

    @ApiModelProperty(value = "更新时间")
    private String updated;

    @ApiModelProperty(value = "道路运输证号")
    @TableField("certificateNo")
    private String certificateno;

    @ApiModelProperty(value = "发证机构名称")
    private String issuingname;

    @ApiModelProperty(value = "有效期起")
    @TableField("notBefore")
    private String notbefore;

    @ApiModelProperty(value = "有效期止")
    @TableField("notAfter")
    private String notafter;

    @ApiModelProperty(value = "经营范围文字")
    private String scope;

    @ApiModelProperty(value = "证照介质类型")
    @TableField("licenseType")
    private String licensetype;

    @ApiModelProperty(value = "软删除")
    @TableField("isDel")
    @TableLogic
    private Integer isdel;

    @ApiModelProperty(value = "版本号")
    @Version
    private Integer version;


}
