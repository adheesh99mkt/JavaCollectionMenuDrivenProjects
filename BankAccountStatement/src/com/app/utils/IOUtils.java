package com.app.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.app.statement.Statement;

public interface IOUtils {
	@SuppressWarnings("unchecked")
	static List<Statement> readDetails(String filename,List<Statement>statement) throws FileNotFoundException, IOException {
		try(BufferedReader br=new BufferedReader(new FileReader(filename))){
			
					String line=null;
					
					while((line=br.readLine())!=null) {
						
						String arr[]=line.split(",");
						String date=arr[0];
						String narration=arr[1];
						double withdraw=Double.parseDouble(arr[2]);
						double deposite=Double.parseDouble(arr[3]);
						Statement st=new Statement(date, narration, withdraw, deposite);
						statement.add(st);
					}
					return statement;
		}
	}
	public static double sumOfAllDeposite(List<Statement>statement) {
		double sum=0;
		for(Statement st:statement) {
			sum+=st.getDepositeAmount();
		}
		return sum;
	}
	public static double maxDepositeAmount(List<Statement>statement) {
		double max=0;
		for(Statement st:statement) {
			if(st.getDepositeAmount()>max) {
				max=st.getDepositeAmount();
			}
		}
		return max;
	}
	public static double shoppingExpense(List<Statement>statement) {
		double expense=0;
		for(Statement st:statement) {
			if(st.getNarration().equalsIgnoreCase("shopping")) {
				expense+=st.getWithdrawalAmount();
			}
		}
		return expense;
	}
	public static String maxWithdrawDate(List<Statement>statement) {
		double max=0;
		String date="";
		for(Statement st:statement) {
			if(st.getWithdrawalAmount()>max) {
				max=st.getWithdrawalAmount();
				date=st.getTransactionDate();
			}
		}
		return date;
	}
}
