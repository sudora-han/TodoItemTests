package object.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TODOSHomepage {
	@FindBy(id="todo-input")
	WebElement eleInputfeild;
	
	@FindBy(className="toggle")
	WebElement eleCheckitem;
	
	@FindBy(className="toggle-all")
	WebElement eleCheckall;
	
	@FindBy(className="selected")
	WebElement eleToggleall;
	
	@FindBy(linkText="Active")
	WebElement eleToggleactive;
	
	@FindBy(linkText="Completed")
	WebElement eleTogglecompleted;
	
	@FindBy(className="clear-completed")
	WebElement eleToggleclearcompleted;
	
	
	public void Checkitem() 
	{
		eleInputfeild.sendKeys(Inputfeild);
	}

	public void clickCheckbox() 
	{
		eleCheckitem.click();
	}
	
	public void clickAll() 
	{
		eleToggleall.click();
	}
	
	public void clickActive() 
	{
		eleToggleactive.click();
	}
	
	public void clickCompleted() 
	{
		eleTogglecompleted.click();
	}
	
	public void clickClearcompleted() 
	{
		eleToggleclearcompleted.click();
	}

	public void Inputfeild(String string) {
		
		eleInputfeild.sendKeys(string);
	}
}
