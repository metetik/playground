package btkSpring1;

public class MySqlCustomerDal implements ICustomerDal{
	private String connectionString;
	
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	public void add() {
		System.out.println("Connection String : " + this.connectionString);
		System.out.println("MySql veritabına eklendi..");
	}
}