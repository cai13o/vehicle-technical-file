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
 * 车辆参数与配置登记表
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VParameterize对象", description="车辆参数与配置登记表")
public class VParameterize implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "车辆类型")
    private String type;

    @ApiModelProperty(value = "厂牌")
    private String brand;

    @ApiModelProperty(value = "型号")
    private String model;

    @ApiModelProperty(value = "出厂日期")
    @TableField("releaseDate")
    private String releasedate;

    @ApiModelProperty(value = "产地")
    private String place;

    @ApiModelProperty(value = "vin(或车架)号")
    private String vin;

    @ApiModelProperty(value = "底盘型号")
    @TableField("chassisModel")
    private String chassismodel;

    @ApiModelProperty(value = "客车类型等级")
    @TableField("typeClass")
    private String typeclass;

    @ApiModelProperty(value = "客车类型等级变更")
    private String chenges;

    @ApiModelProperty(value = "车辆外廓尺寸")
    private String gabarite;

    @ApiModelProperty(value = "总质量")
    private String kg;

    @ApiModelProperty(value = "客车座")
    private String seats;

    @ApiModelProperty(value = "铺位排列")
    private String arranged;

    @ApiModelProperty(value = "核定载质量")
    private String loadkg;

    @ApiModelProperty(value = "乘员数")
    private String complements;

    @ApiModelProperty(value = "牵引总质量")
    @TableField("tractionMass")
    private String tractionmass;

    @ApiModelProperty(value = "驱动形式")
    @TableField("driveFform")
    private String drivefform;

    @ApiModelProperty(value = "发动机型号")
    @TableField("engineModel")
    private String enginemodel;

    @ApiModelProperty(value = "发动机功率")
    @TableField("enginePower")
    private String enginepower;

    @ApiModelProperty(value = "燃料种类")
    @TableField("fuelType")
    private String fueltype;

    @ApiModelProperty(value = "发动机号码")
    @TableField("engineNo")
    private String engineno;

    @ApiModelProperty(value = "发动机排量")
    @TableField("engineCapacity")
    private String enginecapacity;

    @ApiModelProperty(value = "排放标准")
    @TableField("effluentStandard")
    private String effluentstandard;

    @ApiModelProperty(value = "轮胎数")
    @TableField("tiresNo")
    private String tiresno;

    @ApiModelProperty(value = "轮胎种类")
    @TableField("tiresType")
    private String tirestype;

    @ApiModelProperty(value = "前照灯制式")
    @TableField("headlightSystem")
    private String headlightsystem;

    @ApiModelProperty(value = "变速器形式")
    @TableField("transmissionForm")
    private String transmissionform;

    @ApiModelProperty(value = "空调器")
    @TableField("AC")
    private String ac;

    @ApiModelProperty(value = "转向器")
    private String diverter;

    @ApiModelProperty(value = "行车制动形式")
    @TableField("serviceBrake")
    private String servicebrake;

    @ApiModelProperty(value = "悬挂形式前轮")
    private String bsuspension;

    @ApiModelProperty(value = "前气囊")
    private String bgasbag;

    @ApiModelProperty(value = "前板簧数")
    @TableField("bspringNum")
    private String bspringnum;

    @ApiModelProperty(value = "悬挂形式后轮")
    private String asuspension;

    @ApiModelProperty(value = "后气囊")
    private String agasbag;

    @ApiModelProperty(value = "后板簧数")
    @TableField("aspringNum")
    private String aspringnum;

    @ApiModelProperty(value = "其他配置")
    private String misc;

    @ApiModelProperty(value = "内部尺寸")
    @TableField("cargoBody")
    private String cargobody;

    @ApiModelProperty(value = "集装箱种类/数量")
    private String containers;

    @ApiModelProperty(value = "容积")
    private String volume;

    @ApiModelProperty(value = "防护设施")
    private String safeguard;

    @ApiModelProperty(value = "环境保护设施")
    private String facilities;

    @ApiModelProperty(value = "消防设备")
    private String hydrant;

    @ApiModelProperty(value = "罐体质检合格证")
    private String qualification;

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

    @ApiModelProperty(value = "车牌号")
    private String plateno;
}
