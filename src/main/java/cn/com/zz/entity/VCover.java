package cn.com.zz.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 陕西省道路运输车辆技术档案
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VCover对象", description="陕西省道路运输车辆技术档案")
public class VCover implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "编号")
    @TableField("controlNo")
    private String controlno;

    @ApiModelProperty(value = "车牌号码")
    @TableField("plateNo")
    private String plateno;

    @ApiModelProperty(value = "车辆类别")
    private String type;

    @ApiModelProperty(value = "建档日期")
    @TableField("filingDate")
    private String filingdate;

    @ApiModelProperty(value = "监管机构")
    private String regulator;

    @ApiModelProperty(value = "软删除")
    @TableField("isDel")
    @TableLogic
    private String isdel;

    @ApiModelProperty(value = "版本号")
    @Version
    private Integer version;

    @ApiModelProperty(value = "vin(或车架)号")
    private String vin;


}
