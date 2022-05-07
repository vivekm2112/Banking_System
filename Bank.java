package bankingAutoUnboxing;
import java.util.*;
public class Bank {		
	private String name;
	private ArrayList<Branch> branches = new ArrayList<Branch>();
	
	public Bank(String name) {
		this.name=name;
	}
	public boolean addBranch(String branchName) {
		if(findBranch(branchName)== null) {
			this.branches.add(new Branch(branchName));
			return true;
		}
	return false;
	}
	public boolean addCustomer(String branchName,String customerName, double initalAmount ) {
		Branch branch = findBranch(branchName);
		if(branch != null) {
			return 	branch.newCustomer(customerName, initalAmount);
			
		}
	return false;
	}
	public boolean addCustomerTransaction(String branchName,String customerName, double amount ) {
		Branch branch = findBranch(branchName);
		if(branch != null) {
			return 	branch.addCustomerTransaction(customerName, amount);
			
		}
	return false;
	}
	private Branch findBranch(String branchName) {
		for(int i=0; i<this.branches.size(); i++) {
			Branch checkedBranch = this.branches.get(i);
		if(checkedBranch.getname().equals(branchName)) {
			return checkedBranch ;
		}
		}
		return null;	
	}
	public boolean listCustomers(String branchName, boolean showTransaction) {
		Branch branch = findBranch(branchName);
		if(branch!=null) {
			System.out.println("Customer details for branch "+ branch.getname());
			
			ArrayList<Customer> branchCustomers = branch.getCustomer(); 
		for(int i=0; i<branchCustomers.size(); i++) {
			Customer branchCustomer = branchCustomers.get(i);
			System.out.println("Customer: "+ branchCustomer.getName()+"["+(i+1)+"]");
			if(showTransaction) {
				System.out.println("Transactions");
                ArrayList<Double> transactions = branchCustomer.getTransaction();
                for(int j=0; j<transactions.size(); j++) {
                    System.out.println("[" + (j+1) + "]  Amount "  + transactions.get(j));
                }
			}
		}
		 return true;
		}else {
		return false;
	}
		}
}
