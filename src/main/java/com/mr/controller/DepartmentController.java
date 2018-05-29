package com.mr.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ${mfp} on 2018/5/28.
 */
@Controller
@RequestMapping("department")
public class DepartmentController {

	 @RequiresPermissions("dept:list")
	 @RequestMapping("list")
	 public String list(){
		System.out.println("调用部门的list方法");
			return "dept";
	 }
	@RequiresPermissions("dept:save")
	@RequestMapping("save")
	public String save(){
		System.out.println("调用部门的save方法");
		return "dept";
	}
	@RequiresPermissions("dept:delete")
	@RequestMapping("delete")
	public String delete(){
		System.out.println("调用部门的delete方法");
		return "dept";
	}
	@RequiresPermissions("dept:update")
	@RequestMapping("update")
	public String update(){
		System.out.println("调用部门的update方法");
		return "dept";
	}
}
