package cn.edu.cuit.hdhr.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DeptTree implements Serializable {
    private Long DeptID;
    private String deptName;
    private Long parentID;
    private List<DeptTree> subDepts;
}
