package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderformShippingmethod {
public WebDriver driver;
	
	By deliveryMsgTextbox = By.cssSelector("textarea#delivery_message");
	By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");

	public OrderformShippingmethod(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getDeliveryMsgTextbox() {
		return driver.findElement(deliveryMsgTextbox);
	}
	
	public WebElement getContinueBtn() {
		return driver.findElement(continueBtn);
	}
}



