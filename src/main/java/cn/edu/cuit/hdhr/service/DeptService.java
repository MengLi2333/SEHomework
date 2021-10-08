package cn.edu.cuit.hdhr.service;

import cn.edu.cuit.hdhr.entity.Dept;
import cn.edu.cuit.hdhr.entity.DeptTree;

import java.util.List;

public interface DeptService {
    /**
     * 获取所有组织结构信息
     */
    List<DeptTree> getDeptForest();

    /**
     * 获取组织机构详细信息
     * @param deptID 组织机构ID
     */
    Dept getDeptByDeptID(Long deptID);

    /**
     * 添加组织机构
     * @param dept 组织机构信息
     */
    Integer addDept(Dept dept);

    /**
     * 更新组织结构, 值为null的属性不被更新
     * @param dept 组织结构信息
     * @return SQL影响的行数
     */
    Integer updateDeptIgnoreNull(Dept dept);

    /**
     * 删除组织机构
     * @param deptID 组织机构ID
     * @return SQL影响的行数
     */
    Integer deleteDept(Long deptID);

    /**
     * 移除组织机构
     * @param deptID 组织机构ID
     * @return SQL影响的行数
     */
    Integer removeDept(Long deptID);

    /**
     * 恢复组织机构
     * @param deptID 组织机构ID
     */
    Integer rejoinDept(Long deptID);

    /**
     * 调整组织机构
     * @param deptID 组织机构ID
     * @param parentID 父组织机构ID
     */
    Integer resetDept(Long deptID, Long parentID);
}
