package btkSpring2;

import org.springframework.beans.factory.annotation.Value;

public class MsSqlCustomerDal implements ICustomerDal{
	@Value("${database.connectionString}")
	private String connectionString;
	
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	public void add() {
		System.out.println("Connection String : " + this.connectionString);
		System.out.println("MsSql veritabına eklendi..");
	}
}
