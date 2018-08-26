package s_n.People;

//author:Vijeta Tulsiyan
//Student number:s3398979

import s_n.add.AddPerson;
import s_n.method.DataClean;

//Creating Abstract Class Person
public abstract class Person {
	// instance variables to store inputs
	private String fname;
	private String lname;
	private int age;
	private int sex;
	private String status;
	private boolean image;
	public static int max;
	private boolean child = false;
	private boolean father = false;
	private boolean mother = false;

	public boolean isFather() {
		return father;
	}

	public void setFather(boolean father) {
		this.father = father;
	}

	public boolean isMother() {
		return mother;
	}

	public void setMother(boolean mother) {
		this.mother = mother;
	}

	// Constructor
	public Person(String fname, String lname, int sex, int age, String status, boolean image) {
		this.status = status;
		this.fname = fname;
		this.lname = lname;
		this.sex = sex;
		this.age = age;
		this.image = image;
		AddPerson.setList(max, this.fname);
		max++;
		if (age < 16) {
			child = true;
		}
	}

	// Getter and Setter Methods
	public String getFname() {
		return fname;
	}

	public boolean getChild() {
		return child;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isImage() {
		return image;
	}

	public void setImage(boolean image) {
		this.image = image;
	}
}