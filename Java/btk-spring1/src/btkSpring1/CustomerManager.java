package btkSpring1;

public class CustomerManager {
	private ICustomerDal customerDal;
	
	
	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}


	public void add() {
		//İş Kuralları
		customerDal.add();
	}
}
