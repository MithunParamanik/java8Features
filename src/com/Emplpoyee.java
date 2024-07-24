package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Emplpoyee {

	private int id;
	private String firstname;
	private int age;
	private String gender;
	private String dept;
	private String city;
	private int rank;
	private List<String> contactNo;

	public Emplpoyee(int id, String firstname, int age, String gender, String dept, String city, int rank,
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

	public Emplpoyee() {
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
		Emplpoyee other = (Emplpoyee) obj;
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

		List<Student> studentlist = Stream.of(
				new Student(1001, "pankaj", 23, "Male", "MCA", "karnataka", 62,Arrays.asList("1234567890", "4567891235")),
				new Student(1002, "Samit", 20, "Female", "CE", "DELHI", 52, Arrays.asList("1234567833", "4567891215")),
				new Student(1003, "Kabita", 26, "Female", "CE", "DELHI", 31, Arrays.asList("1234567813", "4565891215")),
				new Student(1004, "Amit", 50, "Male", "BCA", "MUMBAI", 22, Arrays.asList("1234567850", "4569891235")),
				new Student(1005, "BAchhan", 50, "Male", "BCA", "karnataka", 23,Arrays.asList("1234567850", "4569891235")),
				new Student(1006, "Kartick", 50, "Male", "BCA", "MUMBAI", 21,Arrays.asList("1234567850", "4569891235")),
				new Student(1007, "Suman", 50, "Male", "BCA", "karnataka", 18,Arrays.asList("1234567850", "4569891235")),
				new Student(1008, "Binod", 12, "Male", "BCA", "DELHI", 30, Arrays.asList("1234567890", "4567891835")),
				new Student(1009, "Chandan", 21, "Male", "MCA", "karnataka", 85,Arrays.asList("1234567890", "4567891835")))
				.collect(Collectors.toList());
		// find the list of student whose rank in between 20 to 50

		List<Student> list = studentlist.stream().filter(s -> s.getRank() > 50 && s.getRank() < 100)
				.collect(Collectors.toList());
		// System.out.println(list);

		// find out the name of student who stay in karnataka and then sort by name

		List<Student> list2 = studentlist.stream().filter(s -> s.getCity().equals("karnataka"))
				.sorted(Comparator.comparing(Student::getFirstname)).collect(Collectors.toList());

		// System.out.println(list2);

		List<String> list3 = studentlist.stream().map(Student::getDept).distinct().collect(Collectors.toList());
		// System.out.println(list3);

		Set<String> set = studentlist.stream().map(Student::getDept).collect(Collectors.toSet());

		//System.out.println(set);
		
		//find out the contact number
		
		List<List<String>> Contacts = studentlist.stream().map(Student::getContactNo).collect(Collectors.toList());
		//System.out.println(Contacts);
		
		List<String> list4 = studentlist.stream().flatMap(s->s.getContactNo().stream()).collect(Collectors.toList());
		//System.out.println(list4);
		
		
		
		//How many students are in each department get the details of students
		
		Map<String,List<Student>> map = studentlist.stream().collect(Collectors.groupingBy(Student::getDept));
		//System.out.println(map);
		
		//how many students are there in each department and count
		
		Map<String, Long> counts = studentlist.stream().collect(Collectors.groupingBy(Student::getDept,
				Collectors.counting()));
		//System.out.println(counts);
		
		Entry<String, Long> maxNumbers = studentlist.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting()))
		.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		//System.out.println(maxNumbers);
		
		Map<String,Double> avsage=	studentlist.stream().collect(Collectors.groupingBy(Student::getGender,
				Collectors.averagingInt(Student::getAge)));
		//System.out.println(avsage);
		
		//find out the max rank in each department
		
		Map<String, Optional<Student>> maxRank = studentlist.stream().collect(Collectors.groupingBy(Student::getDept,
				Collectors.minBy(Comparator.comparing(Student::getRank))));
		//System.out.println(maxRank);
		
		//find out the student whose has second rank
		
		 Student student1 = studentlist.stream()
				.sorted(Comparator.comparing(Student::getRank))
				.skip(1).findFirst().get();
				
		//System.out.println(student1);
		 
		 
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
