

import java.util.ArrayList;
import java.util.Scanner;

//import org.apache.derby.tools.sysinfo;

import Controller.customerController;
import Controller.policyController;
import Model.Customer;
import Model.Policy;

public class InsuranceMain {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			customerController custcontrol = new customerController();
			policyController policycontrol = new policyController();
			
			int menu1;
			System.out.println("MENU");
			System.out.println("1. Registration");
			System.out.println("2. Login");
			menu1 = sc.nextInt();
			do {
				
				if(menu1 == 1) {
					System.out.print("\nEnter customer id: ");
					int custid = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter customer name: ");
					String custname=sc.nextLine();
					System.out.print("Enter password: ");
					String pass = sc.nextLine();
					System.out.print("Enter email: ");
					String email = sc.nextLine();
					System.out.print("Enter Address: ");
					String address = sc.nextLine();
					System.out.print("Enter contact: ");
					String contact = sc.nextLine();
					System.out.print("Enter Nominee Name: ");
					String nominee = sc.nextLine();
					System.out.print("Enter relation with nominee: ");
					String relation = sc.nextLine();
					
					Customer customer = new Customer(custid,custname,pass,email,address,contact,nominee,relation);
					
					boolean isInserted = custcontrol.insert(customer);
					if(isInserted) {
						System.out.println("Recored Entered successfully");
					}else {
						System.out.println("Some error has occured");
					}
				}
				else if(menu1 == 2){				
					System.out.print("\nEnter customer id: ");
					int custid= sc.nextInt();
					sc.nextLine();
					if(custcontrol.isPresent(custid) == true) {
						System.out.print("Enter password: ");
						String pass = sc.nextLine();
						if(custcontrol.isCorrect(custid, pass) == true) {
							System.out.println("Login Successful\n");
							int menu2;
							System.out.println("MENU");
							System.out.print("1. Choose Policy\n");
							System.out.print("2. View policy\n");
							menu2 = sc.nextInt();
							do {
							
							if(menu2 == 1) {
								int menu2a;
								System.out.println("\nMENU");
								System.out.println("1. Insert policy");
								System.out.println("2. Update policy type");
								System.out.println("3. Update policy title");
								System.out.println("4. Delete policy");
								menu2a = sc.nextInt();
								do {
									
									if(menu2a == 1) {
										
										System.out.print("\nEnter policy number: ");
										int polid = sc.nextInt();
										sc.nextLine();
										System.out.print("Enter policy type: ");
										String type = sc.nextLine();
										System.out.print("Enter policy title: " );
										String title = sc.nextLine();
										System.out.print("Enter start date: ");
										String date = sc.nextLine();
										System.out.print("Enter term: ");
										int term = sc.nextInt();
										System.out.print("Enter premium amount: ");
										Long pre = sc.nextLong();
										System.out.print("Enter sum assured: ");
										Long sum = sc.nextLong();
										
										Policy temp = new Policy(polid,custid,type,title,date, term,pre,sum);
										boolean isdone = policycontrol.insert(temp);
										if(isdone==true) {
											System.out.println("Operation Successful");
										}
										else {
											System.out.println("Operation Failed");
										}
										
									}else if(menu2a == 2) {
										
										System.out.print("\nEnter policy id: ");
										int pid = sc.nextInt();
										sc.nextLine();
										System.out.print("Enter new policy type: ");
										String type = sc.nextLine();
										boolean isupdate = policycontrol.update(policycontrol.getone(pid,custid), pid,type);
										
										if(isupdate==true) {
											System.out.println("Operation Successful");
										}
										else {
											System.out.println("Operation Failed");
										}
					
										
									}else if(menu2a == 3) {
										System.out.print("\nEnter policy id: ");
										int pid = sc.nextInt();
										sc.nextLine();
										System.out.print("Enter new title: ");
										String type = sc.nextLine();
										boolean isupdate = policycontrol.updateTitle(policycontrol.getone(pid,custid), pid,type);
										
										if(isupdate==true) {
											System.out.println("Operation Successful");
										}
										else {
											System.out.println("Operation Failed");
										}
										
									}else if(menu2a ==4) {
										
										System.out.println("\nEnter policy no. to be deleted: ");
										int id = sc.nextInt();
										boolean isdelete = policycontrol.delete(id);
										
										if(isdelete==true) {
											System.out.println("Operation Successful");
										}
										else {
											System.out.println("Operation Failed");
										}
										
									}
									System.out.println("\nMENU");
									System.out.println("1. Insert policy");
									System.out.println("2. Update policy type");
									System.out.println("3. Update policy title");
									System.out.println("4. Delete policy");
									System.out.println("Press 5 to exit");
									//System.out.println("Press any other key to return to the last menu or exit");
									menu2a = sc.nextInt();
								}while(menu2a != 5);
								
							}
							else if(menu2 == 2) {
								int menu2b;
								System.out.println("\nMENU");
								System.out.println("1. View policy for customer id");
								System.out.println("2. View all policies");
								menu2b = sc.nextInt();
								System.out.println("");
								do {
								
								if(menu2b == 1) {
									
									ArrayList<Policy> policy = policycontrol.get(custid);
									for(Policy pol: policy) {
									System.out.println(pol.getcId() + " " + pol.getType() + " " + pol.getTitle()+" "+pol.getStart()+" "+pol.getTerm()+" "+pol.getPremium()+" "+pol.getSum());
									}
									
								}
								else if(menu2b == 2) {
									
									ArrayList<Policy> array = policycontrol.getAll();
									for(Policy policy:array) {
										
										System.out.println(policy.getcId() + " " + policy.getType() + " " + policy.getTitle()+" "+policy.getStart()+" "+policy.getTerm()+" "+policy.getPremium()+" "+policy.getSum());
									}
									
								}
								System.out.println("\nMENU");
								System.out.println("1. View policy for customer id");
								System.out.println("2. View all policies");
								System.out.println("Press 3 to exit");
								//System.out.println("Press any other key to return to the last menu or exit");
								menu2b = sc.nextInt();
								}while(menu2b != 3);
							}
							System.out.println("\n\nMENU");
							System.out.print("1. Choose Policy\n");
							System.out.print("2. View policy\n");
							System.out.println("Press 3 to exit");
							//System.out.println("Press any other key to return to the last menu or exit");
							
							menu2 = sc.nextInt();
							}while(menu2 != 3);
						}else {
							System.out.println("Entered wrong password");
						}
					}
					
				}
				
				//System.out.println("Press any other key to return to the last menu or exit");
				System.out.println("\nMENU");
				System.out.println("1. Registration");
				System.out.println("2. Login");
				System.out.println("Press 3 to exit");
				menu1 = sc.nextInt();
			}while(menu1 != 3);
		}
	}
	
}
