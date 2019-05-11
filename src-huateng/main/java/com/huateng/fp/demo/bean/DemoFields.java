package com.huateng.fp.demo.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.math.RandomUtils;

public class DemoFields {

	public static List<DemoFields> DATA = new Vector<DemoFields>();

	static {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < 60; i++) {
			DemoFields foo = new DemoFields();
			foo.setId(String.valueOf(i));
			foo.setName("demo"+i);
			foo.setAge(20 + RandomUtils.nextInt(20));
			foo.setManagerId(String.valueOf(RandomUtils.nextInt(10)));
			foo.setSalary(RandomUtils.nextDouble());
			foo.setBirthday(new Date());
			foo.setSex(RandomUtils.nextBoolean() ? "male" : "female");
			long seed = System.currentTimeMillis() - 3600 * 1000 * 23 * RandomUtils.nextInt(30);
			foo.setWorkStartTime(Timestamp.valueOf(sdf.format(new Date(seed))));
			foo.setWorkEndTime(sdf.format(new Date(seed + 8 * 3600 * 1000)));
			foo.setPid(String.valueOf(RandomUtils.nextInt(5)));
			foo.setYyyymm("201211");
			DATA.add(foo);
		}
	}
	
	private String id;
	private String pid;
	private String name;
	private Integer age;
	private Date birthday;
	private Timestamp workStartTime;
	private String workEndTime;
	private double salary;
	private String sex;
	private String yyyymm;
	private String managerId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(Timestamp workStartTime) {
		this.workStartTime = workStartTime;
	}

	public String getWorkEndTime() {
		return workEndTime;
	}

	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getYyyymm() {
		return yyyymm;
	}

	public void setYyyymm(String yyyymm) {
		this.yyyymm = yyyymm;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

}
