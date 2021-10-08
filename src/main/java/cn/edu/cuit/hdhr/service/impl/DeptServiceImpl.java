package cn.edu.cuit.hdhr.service.impl;

import cn.edu.cuit.hdhr.entity.Dept;
import cn.edu.cuit.hdhr.entity.DeptTree;
import cn.edu.cuit.hdhr.mapper.DeptMapper;
import cn.edu.cuit.hdhr.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    private final DeptMapper deptMapper;

    @Autowired
    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public List<DeptTree> getDeptForest() {
        return deptMapper.selectDeptForestByPID(0L);
    }

    @Override
    public Dept getDeptByDeptID(Long deptID) {
        return deptMapper.selectDeptByDeptID(deptID);
    }

    @Override
    public Integer addDept(Dept dept) {
        return deptMapper.insertDept(dept);
    }

    @Override
    public Integer updateDeptIgnoreNull(Dept dept) {
        return deptMapper.updateDeptIgnoreNull(dept);
    }

    @Override
    public Integer deleteDept(Long deptID) {
        return deptMapper.deleteDept(deptID);
    }

    @Override
    public Integer removeDept(Long deptID) {
        Dept dept = new Dept();
        dept.setDeptID(deptID);
        dept.setIsRemoved(1);
        dept.setRemoveDate(new Date(System.currentTimeMillis()));
        return deptMapper.updateDeptIgnoreNull(dept);
    }

    @Override
    public Integer rejoinDept(Long deptID) {
        Dept dept = deptMapper.selectDeptByDeptID(deptID);
        dept.setIsRemoved(0);
        dept.setRemoveDate(null);
        return deptMapper.updateDept(dept);
    }

    @Override
    public Integer resetDept(Long deptID, Long parentID) {
        Dept dept = new Dept();
        dept.setDeptID(deptID);
        dept.setParentID(parentID);
        return deptMapper.updateDeptIgnoreNull(dept);
    }
}
