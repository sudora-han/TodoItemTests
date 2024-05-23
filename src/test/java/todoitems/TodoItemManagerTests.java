package todoitems;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import object.repository.TODOSHomepage;

public class TodoItemManagerTests {
	
	private WebDriver driver;
	private TODOSHomepage homepg;

	  @BeforeClass
	  public void setUp() {
	      // Set up the WebDriver
	  	 System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chrome-driver\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.get("https://todomvc.com/examples/react/dist/");
	      driver.manage().window().maximize();
	  }
	  
  //@Test
	

  @Test(priority = 1)
  public void addTodoItemTest() {
      // Add a new todo
      WebElement TodoInput = driver.findElement(By.id("todo-input"));
      TodoInput.sendKeys("Understanding Requirements"+"\n");
      TodoInput.sendKeys("Test Planning"+"\n");
      TodoInput.sendKeys("Test Case Design"+"\n");
      TodoInput.sendKeys("Test Environment Setup"+"\n");
      TodoInput.sendKeys("Test Execution"+"\n");
     
      
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      WebDriverWait wait = new WebDriverWait(driver, 100);
      
      WebElement todoLabel = driver.findElement(By.xpath("//label[@data-testid='todo-item-label']"));
    
      Assert.assertTrue(todoLabel.isDisplayed(), "Todo item is not added.");
  }

 
  @Test(priority = 2)
  public void ToDoItemNotCompletedTest(){
      // Complete a todo
      WebElement checkItem = driver.findElement(By.className("toggle"));
      checkItem .click();
    
      Assert.assertTrue(checkItem.isSelected(), "Todo item is not completed .");
  }

  
  @Test(priority = 3)
  public void SetTodItemCompletedtatus()  {
      // Check Complete todos
      WebElement checkItem = driver.findElement(By.linkText("Completed"));
      checkItem .click();
      Assert.assertTrue(checkItem.isDisplayed(), "Completed todo items not displayed .");
  }

  @Test(priority = 4)
  public void FilterActiveTodoItemsTest()  {
      // Check active todos
      WebElement checkItem = driver.findElement(By.linkText("Active"));
      checkItem .click();
      Assert.assertTrue(checkItem.isDisplayed(), "Active todo items not displayed .");
  }

  @Test(priority = 5)
  public void DisplayAllTodoItemsTest()  {
      // Check all todos
      WebElement checkItem = driver.findElement(By.linkText("All"));
      checkItem .click();
      Assert.assertTrue(checkItem.isDisplayed(), "All todo items not dispalyed .");
  } 
  
  @Test(priority = 6)
  public void DeleteToDoItemsWhichAreCompletedTest() {
      // Complete a todo
      WebElement checkItem = driver.findElement(By.className("clear-completed"));
      checkItem .click();
      Assert.assertTrue(checkItem.isDisplayed(), "Todo item is not deleted .");
  }  
  
  @Test(priority = 7)
  public void MarkAllTodoItemsCompletedTest() {
      // Complete all todos
      WebElement checkItem = driver.findElement(By.className("toggle-all"));
      checkItem .click();
      Assert.assertTrue(checkItem.isSelected(), "Todo items is not completed .");
  }

  @Test(priority = 8)
  public void DeleteAllTodoItemsTest()  {
      // Delete a todo
      WebElement Toggleclearcompleted = driver.findElement(By.className("clear-completed"));
      Toggleclearcompleted.click();
      Assert.assertTrue(driver.findElements(By.className("todo-count")).isEmpty(), "Todo item is not deleted .");
      
  }

  @AfterClass
  public void tearDown() {
      // Close the WebDriver
      driver.quit();
  }
}
