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
 * 车辆维护与维修登记表
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VMaintainRepair对象", description="车辆维护与维修登记表")
public class VMaintainRepair implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "维修日期")
    private String ffdate;

    @ApiModelProperty(value = "维修类型")
    private String type;

    @ApiModelProperty(value = "维修或维护内容")
    private String context;

    @ApiModelProperty(value = "维修单位")
    private String unit;

    @ApiModelProperty(value = "竣工合格证编号")
    @TableField("completionNo")
    private String completionno;

    @ApiModelProperty(value = "登记人")
    private String registrant;

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

    @ApiModelProperty(value = "车牌号")
    private String plateno;
}
