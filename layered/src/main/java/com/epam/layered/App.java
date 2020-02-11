package com.epam.layered;
// domain object
class CustomerMoney{
	public String Username;
	public Integer money;
	public Integer getMoney() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
}
class Customer{
	public String Username;
	public String password;
	public Integer money;
}
class CustomerEntity{
	public long id;
	public String Username;
	public String password;
	public Integer money;
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getmoney() {
		// TODO Auto-generated method stub
		return null;
	}
}
//Data Layer Jp repository we have to add to datalayer
 interface CustomerRepository extends Jp<CustomerEntity,Long>{
	 CustomerEntity findByUsername(String Username);

	CustomerEntity save(CustomerEntity customerEntity);
 }
 //Application Layer
 class CustomerMapper{
	 public CustomerMoney mapToDto(CustomerEntity custentity){
		 CustomerMoney dt=new CustomerMoney();
		 dt.Username=custentity.getUsername();
		 dt.money=custentity.getmoney();
		 return dt;
	 }
 }
 class CustomerService{
	 private final CustomerRepository customerRepository;
	  private final CustomerMapper customerMapper;
	  
	  public CustomerMoney addFundsToCustomer(
	    CustomerMoney dt) {
	  
	    CustomerEntity customerEntity = customerRepository.findByUsername(dt.getUsername());
	    customerEntity.money += dt.getMoney();
	    return customerMapper.mapToDto(customerRepository.save(customerEntity));
	  }
	  
	}
 //presentation layer
 class CustomerController {
	  
	  private final CustomerService customerService;

	  public CustomerMoney addMoney(CustomerMoney dto) {
	    return customerService.addFundsToCustomer(dto);
	  }
	  
	}
 
 
 