package com.mr.service.impl;

import com.mr.mapper.UserMapper;
import com.mr.model.User;
import com.mr.model.UserExample;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ${mfp} on 2018/5/25.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {


	@Autowired
	private UserMapper userMapper;


	public User getUserByUserName(String username) {

		UserExample example =new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> userList = userMapper.selectByExample(example);
		//如果userList.size()==0返回null，否则将集合中的第一个对象返回去
		return userList.size()==0?null:userList.get(0);
	}

	/**
	 * 通过用户ID查询角色
	 * @param id
	 * @return
	 */
	public List<String> selectRolesByUserId(Integer id) {
		return userMapper.selectRolesByUserId(id);
	}

	/**
	 * 通过用户ID插叙权限
	 * @param id
	 * @return
	 */
	public List<String> selectPermissionByUserId(Integer id) {
		return userMapper.selectPermissionByUserId(id);
	}
}
