package cn.edu.cuit.hdhr.config.shiro;

import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.entity.Role;
import cn.edu.cuit.hdhr.service.PersonalInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class HDHRRealm extends AuthorizingRealm {
    private final PersonalInfoService personalInfoService;

    @Autowired
    public HDHRRealm(PersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    @Override
    public String getName() {
        return "HDHRRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String empCode = principalCollection.getPrimaryPrincipal().toString();
        ArrayList<Role> roles = personalInfoService.getRolesByEmpCode(empCode);
        return new SimpleAuthorizationInfo(roles.stream().map(Role::getRoleName).collect(Collectors.toSet()));
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        Emp emp = personalInfoService.getEmpByEmpCode(username);
        if (emp == null) {
            throw new AuthenticationException("用户名或密码错误");
        }
        return new SimpleAuthenticationInfo(username, emp.getPassword(), getName());
    }
}
