package com.bc.mybatiscrud.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBo {
    @Id
    private String id;
    @NotBlank
    private String name;
    @NotNull
    private Integer age;

    @Min(value = 1,message = "学生的年级最小为1年级")
    @Max(value = 6,message = "学生的年级最大为6年级")
    private Integer grade;//年级定义为1~6
    @Range(min = 1,max = 18,message = "学生所在班级区间为1~18")
    private Integer classroom;//班级定义为1~6
    @Size(min = 2,max = 5,message = "学生的技能最少两个,最多五个")
    private List<String> skill;
    @Length(min = 3,max = 8,message = "学生的英文名长度区间在3~8")
    private String englishName;
    @Email(message = "邮箱格式不正确")
    private String email;
}
