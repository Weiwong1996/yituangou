package com.dao;

import java.util.List;
import com.entity.Users;

/**
 * 用户接口类
 * @author Administrator
 *
 */
	public interface UsersDao {
	/**
	 * 添加用户
	 * @param users 添加的内容
	 * @return	true 添加成功	false 添加失败
	 */
	public boolean addUsers(Users users);
	/**
	 * 修改用户
	 * @param users 修改的内容
	 * @return	true 修改成功	false 修改失败
	 */
	public boolean editUsers(Users users);
	/**
	 * 删除用户
	 * @param uid 删除的uid号
	 * @return	true 删除成功	false 删除失败
	 */
	public boolean deleteUsers(int uid);
	/**
	 * 查询所有用户
	 * @return 用户的数据
	 */
	public List<Users> getAll();
	/**
	 * 查询某一个用户
	 * @param uid
	 * @return  某uid的内容
	 */
	public Users getUserByUid(int uid);
	/**
	 * 验证是否登入成功
	 * @param name 用户名
	 * @param pwd	密码
	 * @return  true 登入成功	false 登入失败
	 */
	public boolean doLogin(String uname,String upwd);
	/**
	 * 
	 * 
	 * @param uname
	 * @return
	 */
	public Users GetUidByUname(String uname);
}
