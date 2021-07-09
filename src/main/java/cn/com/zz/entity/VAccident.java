package cn.com.zz.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 车辆交通事故登记表
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VAccident对象", description="车辆交通事故登记表")
public class VAccident implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "事故发生日期")
    @TableField("accidentDate")
    private String accidentdate;

    @ApiModelProperty(value = "事故发生地址")
    private String address;

    @ApiModelProperty(value = "事故性质")
    private String nature;

    @ApiModelProperty(value = "事故责任")
    private String liability;

    @ApiModelProperty(value = "事故种类及车辆损毁情况")
    private String damage;

    @ApiModelProperty(value = "企业直接经济损失")
    @TableField("pecuniaryLoss")
    private String pecuniaryloss;

    @ApiModelProperty(value = "登记人")
    private String registrant;

    @ApiModelProperty(value = "软删除")
    @TableField("isDel")
    @TableLogic
    private String isdel;

    @ApiModelProperty(value = "版本号")
    @Version
    private Integer version;

    @ApiModelProperty(value = "vin(或车架)号")
    private String vin;

    @ApiModelProperty(value = "车牌号")
    private String plateno;
}
