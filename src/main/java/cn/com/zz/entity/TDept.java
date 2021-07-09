package cn.com.zz.entity;

import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
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
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TDept对象", description="")
public class TDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "部门描述")
    private String introduction;

    @ApiModelProperty(value = "操作状态")
    private String opflag;

    @ApiModelProperty(value = "操作时间")
    private LocalDateTime opdate;

    private String cid;


}
