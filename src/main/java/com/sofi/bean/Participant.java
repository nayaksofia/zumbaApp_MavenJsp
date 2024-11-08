package com.sofi.bean;

public class Participant {

	//Field declaration :: pid, name, age, email, password
		private int pid;
		private String name;
		private int age;
		private String email;
		private String password;
		
		//Non-parameterized constructor
		public Participant() {
			
		}
        
		//Parameterized Constructor
		public Participant(int pid, String name, int age, String email, String password) {
			super();
			this.pid = pid;
			this.name = name;
			this.age = age;
			this.email = email;
			this.password = password;
		}
		
		//Getter and Setter 

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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		//toString Method , exclude password for security 
		@Override
		public String toString() {
			return "Participant [pid=" + pid + ", name=" + name + ", age=" + age + ", email=" + email + 
					"]";
		}
		
		

	   
}
