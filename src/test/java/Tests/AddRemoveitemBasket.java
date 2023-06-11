package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Basepage;
import junit.framework.Assert;
import pageobject.Homepage;
import pageobject.Shopcontentpanel;
import pageobject.Shophomepage;
import pageobject.Shoppingcart;
import pageobject.Shopproductpage;

@Listeners(Resources.Listeners.class)
public class AddRemoveitemBasket extends Basepage {
	
	public AddRemoveitemBasket() throws IOException {
		super();		
	}
	 @BeforeTest
	 public void setup() throws IOException {
		 driver=getDriver();
		 driver.get(getUrl());
		 System.out.println(getUrl());	 
	 }
	 @AfterTest
	 public void teardown() {
		 driver.close();
		 driver=null;		 
	 }
    @Test
	public void addremoveitem() throws InterruptedException {
		Homepage home=new Homepage(driver);
		 home.getToggle().click();
		 Thread.sleep(2000);
		 //WebDriverWait wait=new WebDriverWait(driver,10);
		 //WebElement TestStoreButton=wait.until(ExpectedConditions.visibilityOfElementLocated());	 
		 // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //TestStoreButton.click();
		 home.getTestStoreLink().click();
		 //Adding product one to cart
		 Shophomepage shophome=new Shophomepage(driver);
		 shophome.getProdOne().click();
		 Shopproductpage shopproduct= new Shopproductpage(driver);
		 Select option=new Select(shopproduct.getSizeOption());
		 option.selectByVisibleText("M");
		 shopproduct.getQuantIncrease().click();
		 shopproduct.getAddToCartBtn().click();
		 Thread.sleep(2000);
	     Shopcontentpanel spanel=new Shopcontentpanel(driver);
	     Thread.sleep(2000);
	     spanel.getContinueShopBtn().click();
	     //Adding product two to cart
	     shopproduct.getHomepageLink().click();
	     shophome.getProdTwo().click();
	     shopproduct.getAddToCartBtn().click();	   
	     spanel.getCheckoutBtn().click();
	    //Deleting the product two from cart
	     Shoppingcart cart=new Shoppingcart(driver);
	     cart.getDeleteItemTwo().click();
	    //Thread.sleep(2000);
	     WebDriverWait wait =new WebDriverWait(driver, 120);
	     wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));
	     String value=cart.getTotalAmount().getText();
	     System.out.println(value);
         Assert.assertEquals(value, "$45.24");	
         
	}

}
