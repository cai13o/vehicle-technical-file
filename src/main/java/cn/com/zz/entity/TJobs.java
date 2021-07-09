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
@ApiModel(value="TJobs对象", description="")
public class TJobs implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "岗位名称")
    private String name;

    @ApiModelProperty(value = "岗位描述")
    private String introduction;

    private String cid;

    @ApiModelProperty(value = "操作状态")
    private String opflag;

    @ApiModelProperty(value = "操作时间")
    private LocalDateTime opdate;

    private String did;


}
