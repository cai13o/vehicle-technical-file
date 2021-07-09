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
 * 经营业户
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VsBusinessOwner对象", description="经营业户")
public class VsBusinessOwner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "经营业户名称")
    private String ownername;

    @ApiModelProperty(value = "业户地")
    private String address;

    @ApiModelProperty(value = "经营业户所在地机构")
    private String organization;

    @ApiModelProperty(value = "经营业户负责人姓名")
    private String principal;

    @ApiModelProperty(value = "经营状态")
    private String status;

    @ApiModelProperty(value = "经营范围")
    private String scope;

    @ApiModelProperty(value = "经营许可证号")
    private String business;

    @ApiModelProperty(value = "有效期起")
    @TableField("notBefore")
    private String notbefore;

    @ApiModelProperty(value = "有效期止")
    @TableField("notAfter")
    private String notafter;

    @ApiModelProperty(value = "发证机构名称")
    private String issuingname;

    @ApiModelProperty(value = "核发日期")
    @TableField("issueDate")
    private String issuedate;

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


}
