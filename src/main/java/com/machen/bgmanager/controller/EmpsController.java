package com.machen.bgmanager.controller;

import com.machen.bgmanager.dao.DepartmentDao;
import com.machen.bgmanager.dao.EmployeeDao;
import com.machen.bgmanager.entity.Department;
import com.machen.bgmanager.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Demo class
 *
 * @author machen
 * @date 2019-04-01 22:33
 */
@Controller
public class EmpsController {
    private Logger logger = LoggerFactory.getLogger(EmpsController.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 返回员工列表页
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);

        return "emps/list";
    }

    /**
     * 来到添加页面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查询部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";
    }

    /**
     * 添加功能,添加成功后返回员工列表页展示数据
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String add(Employee employee){
        System.out.println(employee);
        //保存员工信息
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 跳转到编辑页面,从路径变量中获取id
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditePage(@PathVariable("id") Integer id, Model model){
        System.out.println(id);
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //查询部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return "emps/edite";
    }

    /**
     * 员工编辑
     * @param employee
     * @param id
     * @return
     */
    @PostMapping("/update")
    public String update(Employee employee,Integer id){
        logger.info("员工id: "+id+" 编辑的员工信息："+employee.toString());
        employee.setId(id);
        employeeDao.save(employee);

        //返回员工列表页
        return "redirect:/emps";
    }

    /**
     * 删除操作
     * @param id
     * @param session
     * @return
     */
    @PostMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id, HttpSession session){
        logger.info("用户【"+session.getAttribute("userId")+"】，删除【"+id+"】员工信息");

        employeeDao.delete(id);
        //返回员工列表页
        return "redirect:/emps";
    }
}
