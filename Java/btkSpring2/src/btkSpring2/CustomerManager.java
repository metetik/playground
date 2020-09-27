package btkSpring2;

public class CustomerManager implements ICustomerService{
	private ICustomerDal customerDal;
	
	// Constructor Injection
	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}
	
	public void add() {
		//İş Kuralları
		customerDal.add();
	}
	/*
	 * Setter Injection
	public void setCustomerDal(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}*/
}
