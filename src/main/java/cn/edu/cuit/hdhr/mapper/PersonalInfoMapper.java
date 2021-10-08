package cn.edu.cuit.hdhr.mapper;

import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component // 为了消除IDEA找不到bean的error
@Mapper
public interface PersonalInfoMapper {
    /**
     * 获取员工信息
     * @param empCode 员工工号
     * @return 员工信息
     */
    Emp selectEmpByEmpCode(String empCode);

    /**
     * 获取员工信息
     * @param empID ID
     * @return 员工信息
     */
    Emp selectEmpByEmpID(Long empID);

    /**
     * 获取所有权限信息
     * @param empCode 员工工号
     * @return 所有权限信息
     */
    ArrayList<Role> selectRolesByEmpCode(String empCode);

    /**
     * 更新员工信息
     * @param emp 员工信息
     * @return SQL影响的行数
     */
    Integer updEmpByEmpID(Emp emp);

    /**
     * 获取权限信息
     * @param empCode 员工工号
     * @return 权限信息
     */
    Long selectRole(String empCode);
}
