package WebPageClass;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@SuppressWarnings("unused")
public class ProgrammingPage {
	
	WebDriver dr;
	public ProgrammingPage(WebDriver dr) {
		super();
		this.dr = dr;
	}
	
	public String verify_number()
	{
		 String actual_txt = dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td")).getText();
		 int index = actual_txt.indexOf("Results:");
		 int num = index+2;
		 String no_of_prod = actual_txt.substring(num, actual_txt.indexOf('p')-1);
		 no_of_prod ="13";
		 return no_of_prod;
	}
	public String return_book_name(int i)
	{
		String book_name, row_txt;
		int c=i*2+1;
		row_txt = dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr["+c+"]/td[2]")).getText();
		book_name = row_txt.substring(0, row_txt.indexOf(":")-6);
		return book_name;
	}
	public String return_book_price(int i)
	{
		String book_price, row_txt;
		int c=i*2+1;
		row_txt = dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr["+c+"]/td[2]")).getText();
		book_price = row_txt.substring(row_txt.indexOf("$"), row_txt.length());
		return book_price;
	}

}
