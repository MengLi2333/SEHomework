package cn.edu.cuit.hdhr.service;

        import cn.edu.cuit.hdhr.entity.Emp;
        import cn.edu.cuit.hdhr.entity.Role;

        import java.util.ArrayList;

public interface PersonalInfoService {
    /**
     * 获取员工信息
     * @param empCode 员工工号
     * @return 员工信息
     */
    Emp getEmpByEmpCode(String empCode);

    /**
     * 获取所有权限信息
     * @param empCode 员工工号
     * @return 所有权限信息
     */
    ArrayList<Role> getRolesByEmpCode(String empCode);

    /**
     * 更新员工信息
     * @param emp 员工信息
     * @return SQL影响的行数
     */
    Integer updEmpByEmpID(Emp emp);

    /**
     * 获取员工信息
     * @param empID ID
     * @return 员工信息
     */
    Emp getEmpByEmpID(Long empID);

    /**
     * 获取权限信息
     * @param empCode 员工工号
     * @return 权限信息
     */
    Long getRole(String empCode);
}
