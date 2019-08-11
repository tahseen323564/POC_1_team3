package TestNg;

import org.testng.annotations.Test;

import WebPageClass.Home_page;
import WebPageClass.ProgrammingPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@SuppressWarnings("unused")
public class NewTest {
	
	WebDriver dr = null;
	int index=0;
	int indexa=0;
	Logger log=Logger.getLogger("devpinoyLogger");
	@BeforeClass
	public void beforeClass() {		
		System.setProperty("webdriver.chrome.driver", "chromedriver_v75.exe");
		dr=new ChromeDriver();
		dr.get("http://examples.codecharge.com/Store/Default.php");
	}

	  @AfterClass
	  public void afterClass() {
		  dr.close();
	  }

	@Test(priority=0)
	public void verify_txt() {
		Home_page hp = new Home_page(dr); 
		String exp_txt="Search Products";
		String act_txt = hp.ver_searchprod();
		if(act_txt.equals(exp_txt))
			hp.create_log("verify_txt",exp_txt , act_txt, "FAIL");
		Assert.assertEquals(act_txt, exp_txt);
		hp.create_log("verify", exp_txt, act_txt, "PASS");
	}

	@Test(priority=1)
	public void verify_txt_1() {
		Home_page hp = new Home_page(dr);
		String exp_txt="Categories";
		String act_txt = hp.verify_categories();
		if(act_txt.equals(exp_txt))
			hp.create_log("verify_txt_1",exp_txt , act_txt, "FAIL");
		Assert.assertEquals(act_txt, exp_txt);
		hp.create_log("verify", exp_txt, act_txt, "PASS");
	}

	@Test(priority=3)
	public void verify_number()
	{
		ProgrammingPage pp = new ProgrammingPage(dr);
		Home_page hp = new Home_page(dr);
//		WebDriverWait wt = new WebDriverWait(dr,10);                              
//		wt.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/table[5]/tbody/tr/td/table[1]/tbody/tr/td/form/table[2]/tbody/tr[3]/td/input")));
		String exp_no = "13";
		String act_no= pp.verify_number();
		if(exp_no.equals(act_no))
			hp.create_log("verify_number", exp_no, act_no, "FAIL");
		Assert.assertEquals(act_no,exp_no);
		hp.create_log("verify_number", exp_no, act_no, "PASS");
	}
	

  
  @Test(priority=4)
  public void f() {

	  Home_page hp = new Home_page(dr);
	  hp.gotoprogpage(dr);  
  }
  
  @Test (priority=5 ,dataProvider = "bookprice")
  public void g(String data)
  {
	  Home_page hp = new Home_page(dr);
	  ProgrammingPage pp = new ProgrammingPage(dr);
	  String aprice = pp.return_book_price(indexa);
	  if(aprice.equals(data))
	  {
		  hp.create_log("verify book price", aprice, data, "PASS");
	  }
	  else
	  {
		  hp.create_log("verify book price", aprice, data, "Fail");
	  }
	  indexa++;
	Assert.assertEquals( aprice, data);  
  }
  //after changing the name of function the testng file is giving error
  @Test (priority=6 ,dataProvider = "bookname")
  public void h(String data)
  {
	  ProgrammingPage pp = new ProgrammingPage(dr);
	  Home_page hp = new Home_page(dr);
	  String aname = pp.return_book_name(index);
	  if(aname.equals(data))
	  {
		  hp.create_log("verify book price", aname, data, "PASS");
	  }
	  else
	  {
		  hp.create_log("verify book price", aname, data, "Fail");
	  }
	  index++;
	  Assert.assertEquals( aname, data);
  }



  @DataProvider
  public Object[][] bookname() {
    return new Object[][] { 
    		{"Programming Perl"},
    		{"Perl and CGI for the World Wide Web"},
    		{"PHP and MySQL Web Development"},
    		{"MySQL & PHP From Scratch"},
    		{"Web Development with PHP 4.0"},
    		{"Black Belt Web Programming Methods"},
    		{"Web Development with JSP"}, 
    		{"Professional JSP J2EE Edition"},
    		{"Mastering ColdFusion 4.5"},
    		{"Teach Yourself ColdFusion in 21 Days"}
    };
  }
  
  @DataProvider
  public Object[][] bookprice(){
	  
  	return new Object[][] {
  			{"$39.96"},
  			{"$15.19"},
  			{"$39.99"},
  			{"$23.99"},
  			{"$36.00"},
  			{"$27.96"},
  			{"$35.96"},
  			{"$47.99"},
  			{"$39.99"},
  			{"$31.99"}
  		};
  	}
}
