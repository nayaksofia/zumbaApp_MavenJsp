package com.sofi.bean;

public class Participant {

	//Field declaration
		private int pid;
		private String name;
		private int age;
		private String email;
		
		//Non-parameterized constructor
		public Participant() {
			
		}

	    //Parameterized constructor
		public Participant(int pid, String name, int age, String email) {
			this.pid = pid;
			this.name = name;
			this.age = age;
			this.email = email;
		}
	    
		//Generate getter and setter
		public int getPid() {
			return pid;
		}

		public void setPid(int pid) {
			this.pid = pid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		//Generate toString method

		@Override
		public String toString() {
			return "Participant [pid=" + pid + ", name=" + name + ", age=" + age + ", email=" + email + "]";
		}
		
}
