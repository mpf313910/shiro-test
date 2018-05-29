package com.mr.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ${mfp} on 2018/5/28.
 */
@Controller
@RequestMapping("employee")
public class Employee {

	@RequiresPermissions("emp:list")
	@RequestMapping("list")
	public String list(){
		System.out.println("调用员工的list方法");
		return "emp";
	}
	@RequiresPermissions("emp:add")
	@RequestMapping("save")
	public String save(){
		System.out.println("调用员工的save方法");
		return "emp";
	}
	@RequiresPermissions("emp:delete")
	@RequestMapping("delete")
	public String delete(){
		System.out.println("调用员工的delete方法");
		return "emp";
	}
	@RequiresPermissions("emp:update")
	@RequestMapping("update")
	public String update(){
		System.out.println("调用员工的update方法");
		return "emp";
	}
}
