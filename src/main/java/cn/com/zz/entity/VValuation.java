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
 * 维修企业评价
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="VValuation对象", description="维修企业评价")
public class VValuation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String context;

    @ApiModelProperty(value = "图片1")
    private String photo1;

    @ApiModelProperty(value = "图片2")
    private String photo2;

    @ApiModelProperty(value = "图片3")
    private String photo3;

    @ApiModelProperty(value = "图片4")
    private String photo4;

    @ApiModelProperty(value = "图片5")
    private String photo5;

    @ApiModelProperty(value = "图片6")
    private String photo6;

    @ApiModelProperty(value = "图片7")
    private String photo7;

    @ApiModelProperty(value = "图片8")
    private String photo8;

    @ApiModelProperty(value = "图片9")
    private String photo9;

    @ApiModelProperty(value = "上传人")
    private String creator;

    @ApiModelProperty(value = "公司")
    private String company;

    @ApiModelProperty(value = "答复")
    private String answer;

    @ApiModelProperty(value = "uid")
    private String uid;

    @ApiModelProperty(value = "cid")
    private String cid;

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
