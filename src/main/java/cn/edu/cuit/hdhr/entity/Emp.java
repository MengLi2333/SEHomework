package cn.edu.cuit.hdhr.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class Emp implements Serializable {
    private Long empID;
    private Long deptID;
    private Long titleID;
    private Long postID;
    private String empName;
    private String empCode;
    private Integer gender;
    private String idCardCode;
    private Date birthday;
    private String nativePlace;
    private Integer eduLevel;
    private Integer nation;
    private Integer party;
    private Integer health;
    private Integer regType;
    private Integer status;
    private String password;
}
