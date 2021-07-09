package cn.com.zz.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 车辆检测与评审登记表
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VInspectionReview对象", description="车辆检测与评审登记表")
public class VInspectionReview implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "检验/评定日期")
    private String irdate;

    @ApiModelProperty(value = "检验/评定项目")
    private String irproject;

    @ApiModelProperty(value = "车辆技术等级")
    private String grade;

    @ApiModelProperty(value = "客车类型等级")
    @TableField("typeClass")
    private String typeclass;

    @ApiModelProperty(value = "检测编号")
    private String textno;

    @ApiModelProperty(value = "检验/评定单位")
    private String unit;

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
