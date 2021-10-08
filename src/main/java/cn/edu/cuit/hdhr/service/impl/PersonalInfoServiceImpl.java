package cn.edu.cuit.hdhr.service.impl;

import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.entity.Role;
import cn.edu.cuit.hdhr.mapper.PersonalInfoMapper;
import cn.edu.cuit.hdhr.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    private final PersonalInfoMapper personalInfoMapper;

    @Autowired
    public PersonalInfoServiceImpl(PersonalInfoMapper personalInfoMapper) {
        this.personalInfoMapper = personalInfoMapper;
    }

    @Override
    public Emp getEmpByEmpCode(String empCode) {
        return personalInfoMapper.selectEmpByEmpCode(empCode);
    }

    @Override
    public ArrayList<Role> getRolesByEmpCode(String empCode) {
        return personalInfoMapper.selectRolesByEmpCode(empCode);
    }

    @Override
    public Integer updEmpByEmpID(Emp emp) {
        return personalInfoMapper.updEmpByEmpID(emp);
    }

    @Override
    public Emp getEmpByEmpID(Long empID) {
        return personalInfoMapper.selectEmpByEmpID(empID);
    }

    @Override
    public Long getRole(String empCode) {
        return personalInfoMapper.selectRole(empCode);
    }
}
