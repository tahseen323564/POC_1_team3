package WebPageClass;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_page {
	WebDriver dr;

	public Home_page(WebDriver dr) {
		super();
		this.dr = dr;
	}
	public String ver_searchprod()
	{
		String actual_text;
		actual_text=dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/form/table[1]/tbody/tr/th")).getText();
		return actual_text;
	}
	public String verify_categories()
	{
		String actual_text;
		actual_text=dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[1]/tbody/tr/th")).getText();
		return actual_text;
	}

	public void gotoprogpage(WebDriver dr)
	{
		
		dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[2]/tbody/tr[3]/td/a")).click();
	}
	public void create_log(String meth_name, String enop, String anop, String result) {
		// TODO Auto-generated method stub
		Category log = Logger.getLogger("devpinoyLogger");
		if(result.compareTo("PASS")==0)
		{
			if(enop=="")
				log.info("Method "+ meth_name+" executed \n");
			else
				log.info("Method "+ meth_name+" executed \n"+"Expected Result: "+enop+"\n Actual Result: "+anop+"\n Test Result: "+result);

		}
		else {
			if(enop=="")
				log.info("Method "+ meth_name+"\n");
			else
				log.info("Method "+ meth_name+"\n"+"Expected Result: "+enop+"\nActual Result: "+anop+"\nTest Result: "+result);
		}
		System.out.println("\n \n");
	}
	

}
