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
 * 车辆年度审验登记表
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VAnnualInspection对象", description="车辆年度审验登记表")
public class VAnnualInspection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "车辆检测评定")
    private String assess;

    @ApiModelProperty(value = "车辆定期维护")
    private String maintenance;

    @ApiModelProperty(value = "车辆档案管理")
    private String archive;

    @ApiModelProperty(value = "车辆违法处罚")
    private String punishment;

    @ApiModelProperty(value = "车辆保险/规费")
    private String insure;

    @ApiModelProperty(value = "车辆经营要求")
    private String requirements;

    @ApiModelProperty(value = "审验年度")
    private String annualinspection;

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
