package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Basepage;
import pageobject.Homepage;
import pageobject.OrderformPayment;
import pageobject.OrderformShippingmethod;
import pageobject.Orderformdelievery;
import pageobject.Orderforminfo;
import pageobject.Shopcontentpanel;
import pageobject.Shophomepage;
import pageobject.Shoppingcart;
import pageobject.Shopproductpage;
@Listeners(Resources.Listeners.class)
public class Ordercompletetest extends Basepage {
	 public Ordercompletetest() throws IOException {
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
	 public void enedtoendTest() throws InterruptedException {
		 
	 Homepage home=new Homepage(driver);
	 home.getToggle().click();
	 Thread.sleep(2000);
	 //WebDriverWait wait=new WebDriverWait(driver,10);
	 //WebElement TestStoreButton=wait.until(ExpectedConditions.visibilityOfElementLocated());	 
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 //TestStoreButton.click();
	 //Adding product one to cart
	 home.getTestStoreLink().click();
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
     spanel.getCheckoutBtn().click();
     Shoppingcart scart =new Shoppingcart(driver);
     scart.getHavePromo().click();
     scart.getPromoTextbox().sendKeys("20OFF");
     scart.getPromoAddBtn().click();
     Thread.sleep(2000);
     scart.getProceedCheckoutBtn().click();
     //Filling the order form information   
     Orderforminfo pinfo= new  Orderforminfo(driver);
     pinfo.getGenderMrs().click();
     pinfo.getFirstNameField().sendKeys("Anshika");
     pinfo.getLastnameField().sendKeys("Kumari");
     pinfo.getEmailField().sendKeys("anshikakumari@tester.com");
     pinfo.getTermsConditionsCheckbox().click();
     pinfo.getContinueBtn().click();
     //Filling the delivery details like Address and msg in textbox
     Orderformdelievery orderDelivery = new Orderformdelievery(driver);
     orderDelivery.getAddressField().sendKeys("123 Main Street");
     orderDelivery.getCityField().sendKeys("Houston");
     Select state = new Select(orderDelivery.getStateDropdown());
     state.selectByVisibleText("Texas");
     orderDelivery.getPostcodeField().sendKeys("77021");
     orderDelivery.getContinueBtn().click();
     OrderformShippingmethod shipMethod = new OrderformShippingmethod(driver);
     shipMethod.getDeliveryMsgTextbox().sendKeys("If I do not answer the call, please pass the package to our watchman.");
     shipMethod.getContinueBtn().click();
    
     OrderformPayment orderPay = new OrderformPayment(driver);
     orderPay.getPayByCheckRadioBtn().click();
     orderPay.getTermsConditionsCheckbox().click();
     orderPay.getOrderBtn().click();
}
}
