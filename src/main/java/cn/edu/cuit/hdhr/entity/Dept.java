package cn.edu.cuit.hdhr.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@Data
public class Dept implements Serializable {
    private Long deptID;
    private String deptCode;
    private String deptName;
    private Integer deptType;
    private Long parentID;
    private String location;
    private String postCode;
    private String telephone;
    private String fax;
    private String mail;
    private Integer isRemoved;
    private Date removeDate;
}
