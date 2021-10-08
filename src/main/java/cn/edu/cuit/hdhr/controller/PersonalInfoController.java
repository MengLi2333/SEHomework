package cn.edu.cuit.hdhr.controller;

import cn.edu.cuit.hdhr.common.BusinessException;
import cn.edu.cuit.hdhr.common.Result;
import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.service.PersonalInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 个人信息管理控制器, 包含所有个人信息管理所需要的接口
 */
@RestController
@CrossOrigin(allowCredentials = "true", originPatterns = "http://localhost:*")
@RequestMapping("/personalInfo")
public class PersonalInfoController {
    private final PersonalInfoService personalInfoService;

    @Autowired
    public PersonalInfoController(PersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    /**
     * 登录接口
     * @param empCode 员工工号
     * @param password 密码
     */
    @RequestMapping("/login")
    public Result login(String empCode, String password) {
        SecurityUtils.getSubject().login(new UsernamePasswordToken(empCode, password));
        Emp emp = personalInfoService.getEmpByEmpCode(empCode);
        if (emp == null) {
            throw new BusinessException("服务器错误");
        }
        emp.setPassword(null);
        return Result.succ(emp);
    }

    /**
     * 注销接口
     */
    @RequestMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }

    /**
     * 更新个人信息
     * @param emp 个人信息
     */
    @RequestMapping("/updInfo")
    @RequiresAuthentication
    public Result updInfo(Emp emp) {
        if (emp.getEmpID() == null) {
            throw new BusinessException("无员工编号");
        }
        personalInfoService.updEmpByEmpID(emp);
        return Result.succ(null);
    }

    /**
     * 获取个人信息
     */
    @RequestMapping("/getInfo")
    @RequiresAuthentication
    public Result getInfo() {
        String empCode = SecurityUtils.getSubject().getPrincipal().toString();
        Emp emp = personalInfoService.getEmpByEmpCode(empCode);
        if (emp == null) {
            throw new BusinessException("服务器错误");
        }
        return Result.succ(emp);
    }

    /**
     * 修改密码
     * @param empID 员工ID
     * @param orgPassword 旧密码
     * @param newPassword 新密码
     */
    @RequestMapping("/chgPwd")
    @RequiresAuthentication
    public Result chgPwd(Long empID, String orgPassword, String newPassword) {
        Emp emp = personalInfoService.getEmpByEmpID(empID);
        if (emp.getPassword().equals(orgPassword)) {
            emp.setPassword(newPassword);
            Emp newEmp = new Emp();
            newEmp.setEmpID(empID);
            newEmp.setPassword(newPassword);
            personalInfoService.updEmpByEmpID(newEmp);
            return Result.succ(null);
        } else {
            throw new BusinessException("原密码不正确");
        }
    }

    /**
     * 获取权限信息
     */
    @RequestMapping("/getRole")
    @RequiresAuthentication
    public Result getRole() {
        String empCode = SecurityUtils.getSubject().getPrincipal().toString();
        return Result.succ(personalInfoService.getRole(empCode));
    }

}
