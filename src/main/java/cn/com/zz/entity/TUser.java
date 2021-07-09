package cn.com.zz.entity;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
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
@ApiModel(value="TUser对象", description="")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "曾用名")
    @TableField("BeforeName")
    private String beforename;

    @ApiModelProperty(value = "身份证")
    @TableField("IDCard")
    private String idcard;

    @ApiModelProperty(value = "性别")
    @TableField("Sex")
    private String sex;

    @ApiModelProperty(value = "出生年月")
    private LocalDate birthdate;

    @ApiModelProperty(value = "年龄")
    private String age;

    @ApiModelProperty(value = "民族")
    private String nation;

    @ApiModelProperty(value = "政治面貌")
    @TableField("Political")
    private String political;

    @ApiModelProperty(value = "入团日期")
    @TableField("leagueTime")
    private LocalDate leaguetime;

    @ApiModelProperty(value = "入党日期")
    @TableField("partyTime")
    private LocalDate partytime;

    @ApiModelProperty(value = "最高学历")
    private String education;

    @ApiModelProperty(value = "最高学位")
    private String degree;

    @ApiModelProperty(value = "婚姻状况")
    private String marriage;

    @ApiModelProperty(value = "健康状况")
    private String healthy;

    @ApiModelProperty(value = "身高(厘米)")
    private String stature;

    @ApiModelProperty(value = "体重(千克)")
    private String weight;

    @ApiModelProperty(value = "现居地")
    @TableField("Present_address")
    private String presentAddress;

    @ApiModelProperty(value = "籍贯")
    private String natives;

    @ApiModelProperty(value = "出生地")
    private String birthplace;

    @ApiModelProperty(value = "户口性质")
    @TableField("Household_type")
    private String householdType;

    @ApiModelProperty(value = "户口所在地")
    @TableField("Household_address")
    private String householdAddress;

    @ApiModelProperty(value = "户口所在派出所")
    @TableField("Household_police")
    private String householdPolice;

    @ApiModelProperty(value = "到本单位日期")
    @TableField("reportTime")
    private LocalDate reporttime;

    @ApiModelProperty(value = "参加工作日期")
    @TableField("JobTime")
    private LocalDate jobtime;

    @ApiModelProperty(value = "工龄")
    private String seniority;

    @ApiModelProperty(value = "本企业工龄")
    @TableField("Firm_seniority")
    private String firmSeniority;

    @ApiModelProperty(value = "附件（简历）")
    private String accessory;

    @ApiModelProperty(value = "操作日期")
    private LocalDateTime opdate;

    @ApiModelProperty(value = "操作表示")
    private String opflag;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "锁定状态")
    private String state;

    @ApiModelProperty(value = "创建人")
    private String operator;

    @ApiModelProperty(value = "激活时间")
    @TableField("startDate")
    private LocalDate startdate;

    @ApiModelProperty(value = "失效时间")
    @TableField("endDate")
    private LocalDate enddate;

    @ApiModelProperty(value = "头像")
    private String img;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    private String cid;

    private String did;

    private String jid;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdate;

    @ApiModelProperty(value = "身份证正面")
    private String frontofid;

    @ApiModelProperty(value = "身份证反面")
    private String reverseofid;


}
