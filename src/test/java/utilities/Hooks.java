package utilities;

import io.cucumber.java.Before;

public class Hooks extends Commons{
	@Before(order=1)
	public void before_1()
	{
		log.info("___________________ Test starting__________________________");
		System.out.println("___________________ Test starting__________________________");
		
	}
	
	@Before(order=2)
	public void before_2()
	{
		log.info("___________________ Before Hook__________________________");
		System.out.println("___________________Before Hook_________________________");
		cofigreport();
	}

}
