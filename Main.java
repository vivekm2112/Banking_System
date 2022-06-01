package bankingAutoUnboxing;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank("State Bank of India");

        if(bank.addBranch("Jammu")) {
            System.out.println("Jammu branch created");
        }

        bank.addCustomer("Jammu", "Tim", 50.05);
        bank.addCustomer("Jammu", "Mike", 175.34);
        bank.addCustomer("Jammu", "Percy", 220.12);

        bank.addBranch("Himachal");
        bank.addCustomer("Himachal", "Bob", 150.54);

        bank.addCustomerTransaction("Jammu", "Tim", 44.22);
        bank.addCustomerTransaction("Jammu", "Tim", 12.44);
        bank.addCustomerTransaction("Jammu", "Mike", 1.65);

        bank.listCustomers("Jammu", true);
        bank.listCustomers("Jammu", true);

        bank.addBranch("Delhi");

        if(!bank.addCustomer("Delhi", "Brian", 5.53)) {
            System.out.println("Error Delhi branch does not exist");
        }

        if(!bank.addBranch("Jammu")) {
            System.out.println("Jammu branch already exists");
        }

        if(!bank.addCustomerTransaction("Jammu", "Fergus", 52.33)) {
            System.out.println("Customer does not exist at branch");
        }

        if(!bank.addCustomer("Jammu", "Tim", 12.21)) {
            System.out.println("Customer Tim already exists");
        }

	}

}
