package com.dimit.example1.entity;

import java.awt.Color;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * POJO规则：
 * 
 * <pre>
 * 1、存在无参构造函数
 * </pre>
 * 
 * <pre>
 * 2、提供一个唯一标示主键
 * </pre>
 * 
 * <pre>
 * 3、不是最终类且不含最终方法即类上无final关键字或方法上无final关键字,以便在执行类的延迟加载时方便hibernate进行代理
 * </pre>
 * 
 * <pre>
 * 4、存在geter和setter方法
 * </pre>
 * 
 * <pre>
 * 5、在存在一对多引用时实现equals和hashcode方法
 * </pre>
 *
 */
public class Cat {
	private Long id; // identifier
	private Date birthdate;
	private Color color;
	private char sex;
	private float weight;
	private int litterId;

	private Cat mother;
	private Set<Cat> kittens = new HashSet<Cat>();

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setBirthdate(Date date) {
		birthdate = date;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	void setWeight(float weight) {
		this.weight = weight;
	}

	public float getWeight() {
		return weight;
	}

	public Color getColor() {
		return color;
	}

	void setColor(Color color) {
		this.color = color;
	}

	void setSex(char sex) {
		this.sex = sex;
	}

	public char getSex() {
		return sex;
	}

	public void setLitterId(int id) {
		this.litterId = id;
	}

	public int getLitterId() {
		return litterId;
	}

	public void setMother(Cat mother) {
		this.mother = mother;
	}

	public Cat getMother() {
		return mother;
	}

	void setKittens(Set<Cat> kittens) {
		this.kittens = kittens;
	}

	public Set<Cat> getKittens() {
		return kittens;
	}

	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Cat))
			return false;
		final Cat cat = (Cat) other;
		if (!(cat.getLitterId() == litterId))
			return false;
		if (!cat.getMother().equals(getMother()))
			return false;
		return true;
	}

	public int hashCode() {
		int result;
		result = getMother().hashCode();
		result = 29 * result + getLitterId();
		return result;
	}

	// addKitten not needed by Hibernate
	public void addKitten(Cat kitten) {
		kitten.setMother(this);
		kitten.setLitterId(kittens.size());
		kittens.add(kitten);
	}
}