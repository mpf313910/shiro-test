package com.mr.realm;

		import com.mr.model.User;
		import com.mr.service.UserService;
		import org.apache.shiro.SecurityUtils;
		import org.apache.shiro.authc.*;
		import org.apache.shiro.authz.AuthorizationInfo;
		import org.apache.shiro.authz.SimpleAuthorizationInfo;
		import org.apache.shiro.realm.AuthorizingRealm;
		import org.apache.shiro.subject.PrincipalCollection;
		import org.apache.shiro.util.ByteSource;
		import org.springframework.beans.factory.annotation.Autowired;
		import java.util.ArrayList;
		import java.util.List;

/**
 * Created by ${mfp} on 2018/5/25.
 */
public class MyRealm extends AuthorizingRealm{

	/**
	 * 获取当前realm的名
	 * @return
	 */
	@Autowired
	private UserService userService;

	public String getName(){
		return "MyRealm";
	}


	//授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
		//获取当前对象
		User user = (User) collection.getPrimaryPrincipal();
		//通过用户获取相对应的权限、角色

		//角色集合
		List<String> roles = new ArrayList<String>();
		roles = userService.selectRolesByUserId(user.getId());

		//定义权限集合  permission权限
		List<String> permission = new ArrayList<String>();
		permission = userService.selectPermissionByUserId(user.getId());

		//创建SimpleAuthorizationInfo对象，
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		//将角色放入info中
		info.addRoles(roles);

		//将权限放入info中
		info.addStringPermissions(permission);
		return info;
	}
	//认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//		UsernamePasswordToken token1 = (UsernamePasswordToken) token;
		//获取用户名
		String username = (String) token.getPrincipal();
		//根据用户名查询用户信息
		User user = userService.getUserByUserName(username);
		//判断是否存在
		if(user==null){
			return null;
		}

		//创建SimpleAuthenticationInfo对象，需要传递三个参数(当前对象，数据库中查询出来的密码，当前realm的名字)
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getUsername()),getName());

		return info;
	}



	//清除缓存，修改角色和权限之后，需要手动清除
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
}
