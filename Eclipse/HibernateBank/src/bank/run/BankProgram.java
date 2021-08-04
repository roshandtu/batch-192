package bank.run;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bank.entity.Account;
import bank.util.GetInput;
import bank.util.HibernateUtil;

public class BankProgram {
	public static void main(String[] args) {
		int an, c;
		float bal;
		String name, mob, email;
		
					
		while(true) {
			c = GetInput.getInt("0:Quit\n1:New Account | 2:Deposit | 3:Withdraw | 4:Update Details | 5:Get Account Details | 6:Display All Accounts \n>");
			
			if(c == 0) {
				break;
			}
			
			else if(c == 1) {
				System.out.println("Create New Account");
				an = GetInput.getInt("Account Number");
				name = GetInput.getString("Name");
				bal = GetInput.getFloat("Initial Deposit");
				mob = GetInput.getString("Mobile Number");
				email = GetInput.getString("Email");
				
				Account acc = new Account(an, bal, name, mob, email);
				
				Session sess = HibernateUtil.getSess();
				Transaction tx = sess.beginTransaction();
				try {
					sess.save(acc);
					tx.commit();
				}
				catch(HibernateException he) {
					tx.rollback();
					System.out.println("Error Creating Account\n" + he);
					he.printStackTrace();
				}
				sess.close();
			}
			
			else if(c == 2) {
				System.out.println("Deposit");
				an = GetInput.getInt("Account Number");
				Session sess = HibernateUtil.getSess();
				sess.beginTransaction();
				Account ac = (Account) sess.get(Account.class, an);
				
				if(ac == null) {
					System.out.println("No account found with the given A/C number");
				}
				else {
					System.out.println("Name: " + ac.getName() + "\nAvailable Balance: " + ac.getBal());
					float amt = GetInput.getFloat("Deposit Amount");
					ac.deposit(amt);
					sess.getTransaction().commit();
				}
				sess.close();
			}
			
			else if(c == 3) {
				System.out.println("Withdraw");
				an = GetInput.getInt("Account Number");
				Session sess = HibernateUtil.getSess();
				sess.beginTransaction();
				Account ac = (Account) sess.get(Account.class, an);
				
				if(ac == null) {
					System.out.println("No account found with the given A/C number");
				}
				else {
					System.out.println("Name: " + ac.getName() + "\nAvailable Balance: " + ac.getBal());
					float amt = GetInput.getFloat("Withdraw Amount");
					ac.withdraw(amt);
					sess.getTransaction().commit();
				}
				sess.close();
			}
			
			else if(c == 4) {
				System.out.println("Update Details");
				an = GetInput.getInt("Account Number");
				Session sess = HibernateUtil.getSess();
				sess.beginTransaction();
				Account ac = (Account) sess.get(Account.class, an);
				
				if(ac == null) {
					System.out.println("No account found with the given A/C number");
				}
				else {
					System.out.println("Name: " + ac.getName() + "\nAvailable Balance: " + ac.getBal());
					name = GetInput.getString("Name (" + ac.getName() + ")");
					mob = GetInput.getString("Mobile (" + ac.getMob() + ")");
					email = GetInput.getString("Email (" + ac.getEmail() + ")");
					
					if(!name.equals("")) {
						ac.setName(name);
					}
					if(!mob.equals("")) {
						ac.setMob(mob);
					}
					if(!email.equals("")) {
						ac.setEmail(email);
					}
					
					sess.getTransaction().commit();
					System.out.println("Updated");
				}
				sess.close();
			}
			
			else if(c == 5) {
				System.out.println("Get Account Details");
				an = GetInput.getInt("Account Number");
				Session sess = HibernateUtil.getSess();
				sess.beginTransaction();
				Account ac = (Account) sess.get(Account.class, an);
				System.out.println(ac.toStr());
				sess.close();
			}
			
			else if(c == 6) {				
				Session sess = HibernateUtil.getSess();
				Account ac = new Account();
				Transaction tx = sess.beginTransaction();
				Query q = sess.createQuery("from Account");
				List stud = q.list();
				Iterator it = stud.iterator();
				System.out.println("All Accounts");
				while(it.hasNext()) {
					ac = (Account) it.next();
					System.out.println(ac.toStr());
					System.out.println("-----------------------------------");
				}
				sess.close();
			}
			
		}
	}
}
