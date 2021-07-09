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
 * 车辆行驶里程与燃油消耗登记表
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VMileageConsumption对象", description="车辆行驶里程与燃油消耗登记表")
public class VMileageConsumption implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "时间")
    private String min;

    @ApiModelProperty(value = "累计行驶里程")
    private String mileage;

    @ApiModelProperty(value = "本月行驶里程")
    @TableField("curMileage")
    private String curmileage;

    @ApiModelProperty(value = "本月燃油消耗")
    @TableField("curUsage")
    private String curusage;

    @ApiModelProperty(value = "百公里实际消耗量")
    @TableField("hundredUsage")
    private String hundredusage;

    @ApiModelProperty(value = "车型燃油消耗定额")
    private String quota;

    @ApiModelProperty(value = "节油/超耗")
    private String economizer;

    @ApiModelProperty(value = "司机姓名")
    private String drivername;

    @ApiModelProperty(value = "记录人")
    private String recorder;

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
