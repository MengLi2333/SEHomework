package cn.edu.cuit.hdhr.controller;

import cn.edu.cuit.hdhr.common.Result;
import cn.edu.cuit.hdhr.entity.Dept;
import cn.edu.cuit.hdhr.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 组织机构管理控制器, 包含所有组织机构管理所需要的接口
 */
@RestController
@CrossOrigin(allowCredentials = "true", originPatterns = "http://localhost:*")
@RequestMapping("/dept")
public class DeptController {
    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 获取所有组织结构信息
     */
    @RequestMapping("/deptForest")
    @RequiresRoles("HRDeptManager")
    public Result deptForest() {
        return Result.succ(deptService.getDeptForest());
    }

    /**
     * 获取组织机构详细信息
     * @param deptID 组织机构ID
     */
    @RequestMapping("/detail")
    @RequiresRoles("HRDeptManager")
    public Result detail(Long deptID) {
        return Result.succ(deptService.getDeptByDeptID(deptID));
    }

    /**
     * 添加组织机构
     * @param dept 组织机构信息
     */
    @RequestMapping("/addDept")
    @RequiresRoles("HRDeptManager")
    public Result addChild(Dept dept) {
        deptService.addDept(dept);
        return Result.succ(null);
    }

    /**
     * 更新组织机构
     * @param dept 组织机构信息
     */
    @RequestMapping("/updateDept")
    @RequiresRoles("HRDeptManager")
    public Result updateDept(Dept dept) {
        deptService.updateDeptIgnoreNull(dept);
        return Result.succ(null);
    }

    /**
     * 删除组织机构
     * @param deptID 组织机构ID
     */
    @RequestMapping("/deleteDept")
    @RequiresRoles("HRDeptManager")
    public Result deleteDept(Long deptID) {
        deptService.deleteDept(deptID);
        return Result.succ(null);
    }

    /**
     * 移除组织机构
     * @param deptID 组织机构ID
     */
    @RequestMapping("/removeDept")
    @RequiresRoles("HRDeptManager")
    public Result removeDept(Long deptID) {
        deptService.removeDept(deptID);
        return Result.succ(null);
    }

    /**
     * 恢复组织机构
     * @param deptID 组织机构ID
     */
    @RequestMapping("/rejoinDept")
    @RequiresRoles("HRDeptManager")
    public Result rejoinDept(Long deptID) {
        deptService.rejoinDept(deptID);
        return Result.succ(null);
    }

    /**
     * 调整组织机构
     * @param deptID 组织机构ID
     * @param parentID 父组织机构ID
     */
    @RequestMapping("/resetDept")
    @RequiresRoles("HRDeptManager")
    public Result resetDept(Long deptID, Long parentID) {
        deptService.resetDept(deptID, parentID);
        return Result.succ(null);
    }
}
