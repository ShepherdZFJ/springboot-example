package com.shepherd.basedemo.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.shepherd.basedemo.excel.converters.GenderConverter;
import com.shepherd.basedemo.excel.converters.UserNoConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2024/4/9 15:59
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_user")
@ExcelIgnoreUnannotated
public class User {

    @TableId(type = IdType.AUTO)
    @ExcelProperty(index = 0)
    private Long id;
    @ExcelProperty(index = 1, converter = UserNoConverter.class)
    private String userNo;
    @ExcelProperty(value = "性别", index = 3, converter = GenderConverter.class)
    private Integer gender;
    @ExcelProperty(value = "姓名", index = 2)
    private String name;
    @ExcelProperty(index = 4)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthday;
    @ExcelProperty(index = 5, value = {"基本信息", "手机号"})
    private String phone;
    @ExcelProperty(index = 6, value = {"基本信息", "邮箱"})
    private String email;
    @ExcelIgnore
    private Integer isDelete;
    @ExcelProperty(index = 7, value = {"基本信息", "地址"})
    private String address;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    private Date updateTime;
}
