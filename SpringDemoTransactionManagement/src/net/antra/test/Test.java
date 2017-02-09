package net.antra.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.service.DepartmentService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/application-context.xml");
		
		DepartmentService ds = (DepartmentService) ac.getBean("departmentServiceImpl");
		
		ds.loadDeptBasicInfo().forEach(e -> System.out.println(e.getName()));
		
		Department d = new Department();
		d.setName("TestDepartment");
		ds.saveDept(d);
		System.out.println("////////////////");
		System.out.println("After Insertion");
		ds.loadDeptBasicInfo().forEach(e -> System.out.println(e.getName()));

	}
}
