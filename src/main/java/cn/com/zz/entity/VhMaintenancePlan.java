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
 * 维护计划
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VhMaintenancePlan对象", description="维护计划")
public class VhMaintenancePlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "车牌号码")
    @TableField("plateNo")
    private String plateno;

    @ApiModelProperty(value = "车牌颜色")
    @TableField("plateColor")
    private String platecolor;

    @ApiModelProperty(value = "单位全名")
    private String unitname;

    @ApiModelProperty(value = "车辆类型")
    private String type;

    @ApiModelProperty(value = "周期")
    private String period;

    @ApiModelProperty(value = "频次")
    private String hz;

    @ApiModelProperty(value = "开始时间")
    @TableField("startTime")
    private String starttime;

    @ApiModelProperty(value = "备注")
    private String memo;

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
