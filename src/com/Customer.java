package com;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Customer {
	private String name;
	private int age;
	private int rank;
	private double salary;

	public Customer(String name, int age, int rank, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.rank = rank;
		this.salary = salary;
	}

	public Customer() {
		super();
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, rank, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return age == other.age && Objects.equals(name, other.name) && rank == other.rank
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", rank=" + rank + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {
		
		List<Customer> customer=Stream.of(
				
				new Customer("mithun",30,12,5000),
				new Customer("samit",29,10,9000),
				new Customer("chandan",25,2,6000),
				new Customer("chandan",23,1,3000))
				.collect(Collectors.toList());
		
		
		List<Customer> customerlist1 = customer.stream().sorted(Comparator.comparing(Customer::getAge)
				.thenComparing(Customer::getRank)).collect(Collectors.toList());
		//System.out.println(customerlist1);
		 Comparator<Customer> sortByNmae=(c1,c2)->c1.getName().compareTo(c2.getName());
		 Comparator<Customer>sortByAge=(c1,c2)->Integer.compare(c1.getAge(),c2.getAge());
		 
		  List<Customer> customer2 = customerlist1.stream().sorted(sortByNmae.thenComparing(sortByAge)).collect(Collectors.toList());
		  System.out.println(customer2);
		
				
		

	}

}
