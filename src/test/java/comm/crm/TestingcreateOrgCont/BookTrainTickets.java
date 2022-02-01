package comm.crm.TestingcreateOrgCont;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTrainTickets {
	
	
	
	@Test(dataProvider="ticketdata" )
	public void bookTrainTicket(String src,String des)
	{
		System.out.println("book ticket from "+src+" to "+des);
	}

	@DataProvider
	public  Object[][] ticketdata()
	{
		Object[][] objarr=new Object[3][2];
		
		objarr[0][0]="Bengaluru";
		objarr[0][1]="mysore";
		
		objarr[1][0]="Bengaluru";
		objarr[1][1]="davangere";
		
		objarr[2][0]="Bengaluru";
		objarr[2][1]="matti";
		
	return objarr;
		
		
	}
}
