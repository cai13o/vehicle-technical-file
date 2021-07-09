package cn.com.zz.entity;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 13o
 * @since 2021-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TSystemAccount对象", description="")
public class TSystemAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户姓名")
    private String addressname;

    @ApiModelProperty(value = "登录账号")
    @TableField("loginID")
    private String loginid;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "用户角色")
    private String role;

    @ApiModelProperty(value = "账号描述")
    private String desc;

    @ApiModelProperty(value = "锁定状态")
    private String status;

    private String cid;

    @ApiModelProperty(value = "监管")
    private String supervise;

    private String areaid;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String district;

    private Integer provinceid;

    private Integer cityid;

    private Integer districtid;


}
