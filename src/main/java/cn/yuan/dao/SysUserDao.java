package cn.yuan.dao;

import cn.yuan.entity.SysUser;

/**
 * 管理员dao
 * @author yuan
 */
public interface SysUserDao {

    /**
     * 通过管理员id查找管理员信息
     * @param userId
     * @return
     */
    public SysUser getSysUserById(String userId);
}
