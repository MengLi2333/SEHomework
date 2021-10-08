package cn.edu.cuit.hdhr.mapper;

import cn.edu.cuit.hdhr.entity.Dept;
import cn.edu.cuit.hdhr.entity.DeptTree;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component  // 为了消除IDEA找不到bean的error
public interface DeptMapper {
    /**
     * 获取以parentID为父组织结构ID的组织结构
     * @param parentID 父组织结构ID
     * @return 以parentID为父组织结构ID的组织结构
     */
    List<DeptTree> selectDeptForestByPID(Long parentID);

    /**
     * 获取组织结构详细信息
     * @param deptID 组织结构ID
     * @return 组织结构信息
     */
    Dept selectDeptByDeptID(Long deptID);

    /**
     * 添加组织结构
     * @param dept 组织结构信息
     * @return SQL影响的行数
     */
    Integer insertDept(Dept dept);

    /**
     * 更新组织结构, 值为null的属性不被更新
     * @param dept 组织结构信息
     * @return SQL影响的行数
     */
    Integer updateDeptIgnoreNull(Dept dept);

    /**
     * 更新组织结构
     * @param dept 组织结构信息
     * @return SQL影响的行数
     */
    Integer updateDept(Dept dept);

    /**
     * 删除组织机构
     * @param deptID 组织机构ID
     * @return SQL影响的行数
     */
    Integer deleteDept(Long deptID);
}
