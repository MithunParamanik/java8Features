package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
	
	private int id;
	private String firstname;
	private int age;
	private String gender;
	private String dept;
	private String city;
	private int rank;
	private List<String> contactNo;
	

	public Student(int id, String firstname, int age, String gender, String dept, String city, int rank,
			List<String> contactNo) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.age = age;
		this.gender = gender;
		this.dept = dept;
		this.city = city;
		this.rank = rank;
		this.contactNo = contactNo;
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public List<String> getContactNo() {
		return contactNo;
	}
	public void setContactNo(List<String> contactNo) {
		this.contactNo = contactNo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, city, contactNo, dept, firstname, gender, id, rank);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(city, other.city) && Objects.equals(contactNo, other.contactNo)
				&& Objects.equals(dept, other.dept) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(gender, other.gender) && id == other.id && rank == other.rank;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", age=" + age + ", gender=" + gender + ", dept="
				+ dept + ", city=" + city + ", rank=" + rank + ", contactNo=" + contactNo + "]";
	}
	public static void main(String[] args) {
		

		List<Student> studentlist=Stream.of(
				new Student(1001,"pankaj",23,"Male","MCA","MUMBAI",62, Arrays.asList("1234567890","4567891235")),
				new Student(1002,"Samit",20,"Female","CE","DELHI",52, Arrays.asList("1234567833","4567891215")),
				new Student(1003,"Kabita",26,"Female","CE","DELHI",31, Arrays.asList("1234567813","4565891215")),
				new Student(1004,"Amit",50,"Male","BCA","MUMBAI",22, Arrays.asList("1234567850","4569891235")),
				new Student(1005,"BAchhan",50,"Male","BCA","MUMBAI",23, Arrays.asList("1234567850","4569891235")),
				new Student(1006,"Kartick",50,"Male","BCA","MUMBAI",21, Arrays.asList("1234567850","4569891235")),
				new Student(1007,"Suman",50,"Male","BCA","MUMBAI",18, Arrays.asList("1234567850","4569891235")),
				new Student(1008,"Binod",12,"Male","BCA","DELHI",30, Arrays.asList("1234567890","4567891835")),
				new Student(1009,"Chandan",21,"Male","MCA","MUMBAI",85, Arrays.asList("1234567890","4567891835")))
				.collect(Collectors.toList());
		//find the list of student whose rank in between 20 to 50
		
		List<Student> student1 = studentlist.stream().filter(S->S.getRank()>=20 && S.getRank()<=50)
				.collect(Collectors.toList());
		//System.out.println(student1);
		
		//find list of student whose city is MUMBAI and the sort by firstname
		
		List<Student> Student2 = studentlist.stream().filter(s->s.getCity().equals("MUMBAI"))
		                    .sorted(Comparator.comparing(Student::getFirstname)).collect(Collectors.toList());
		
		//System.out.println(Student2);
		
		//find the list of student whose age is greater then 23 and the sorted by gender
		
		List<Student> list2 = studentlist.stream().filter(s->s.getAge()>12)
		.sorted(Comparator.comparing(Student::getDept,Comparator.reverseOrder())).collect(Collectors.toList());
		
		//System.out.println(list2);
		
		
		//find the all department name
		List<String> listdept = studentlist.stream().map(Student::getDept).collect(Collectors.toList());
		//System.out.println(listdept);
		
		//find all the list of phone number
		List<String> listofPhonenumebr = studentlist.stream()
				.flatMap(s->s.getContactNo().stream()).distinct().collect(Collectors.toList());
		
		//System.out.println(listofPhonenumebr);
		
		//find out group by dept
		
		
		Map<String, List<Student>> groupByDept = studentlist.stream().
				collect(Collectors.groupingBy(Student::getDept)); 
		//System.out.println(groupByDept);
		
		//find out how many student are there in each department
		
		Map<String, Long> CountStudent = studentlist.stream()
		.collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));
		
		//System.out.println(CountStudent);
		
		//find out how many student contact number are there in each department
		
		Map<List<String>, Long> collect = studentlist.stream()
		.collect(Collectors.groupingBy(Student::getContactNo,
				Collectors.counting()));
		
		//System.out.println(collect);
		
		//find out the maximum student of whose department
	 Entry<String, Long> entry = studentlist.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting()))
	 .entrySet().stream().max(Map.Entry.comparingByValue()).get();
		
		//System.out.println(entry);
		
		//find the average age of male and female student
		Map<String, Double> AverageAgeByStudent = studentlist.stream().collect(Collectors.groupingBy(Student::getGender,
				Collectors.averagingInt(Student::getAge)));
		//System.out.println(AverageAgeByStudent);
		
		//find out heighest rank of each department
		
		Map<String, Optional<Student>> studentMap = studentlist.stream().collect(Collectors.groupingBy(Student::getDept
				,Collectors.minBy(Comparator.comparing(Student::getRank))));
		
		//System.out.println(studentMap);
		
		
		//find the second heighest rank
		 Student SecondHeighest = studentlist.stream().sorted(Comparator.comparing(Student::getRank))
		.skip(1)
		.findFirst().get();
		//System.out.println(SecondHeighest);
		
		//find the second highest age from the student list
		
		 Student secondHeighestAge = studentlist.stream()
		 .sorted(Comparator.comparing(Student::getAge))
		 .skip(2)
		 .findFirst().get();
		 
		// System.out.println(secondHeighestAge);
		 
		 
		 //
		 /*
		List<Integer> integers=Arrays.asList(1,2,3,4,5,6,6);
		System.out.println(integers.stream().map(x->x*x).collect(Collectors.toList()));
		
		 List<Integer> integers=Arrays.asList(1,2,5,12,20,25);
		 
		 integers.stream()
		 .filter(x->x%5==0)
		 .forEach(System.out::println);*/
		 
		 
		
		
		
		
		
		
      		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
