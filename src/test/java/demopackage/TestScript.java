package demopackage;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class TestScript {

	private  WebDriver driver;
    public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	/*public static void main(String[] args) throws InterruptedException {

    	Login360Dashbord login360Dashbord=new Login360Dashbord();
    	login360Dashbord.LaunchChromeBrowser();
    	login360Dashbord.LaunchServify360DashbordUrl();
    	login360Dashbord.LoginServify360();
    	
    	
    	ConsumerTab2 consumerTab2 =new ConsumerTab2(login360Dashbord);
    	consumerTab2.ConsumerTab();
    	consumerTab2.ConsumerViewDetilsButtons();
    	
    	System.out.println(" End of main" );
    }
    */
  
    @Test(priority=1)
    public void LaunchChromeBrowser() {
    	this.driver = new ChromeDriver();
  }
    
    @Test (priority=2)
    public void OpenLinkServify360DashbordUrl () throws InterruptedException{
      //driver.get("https://360.servify.in/");
       driver.get("http://staging.servify.in:3000/");  
      //driver.get ("http://staging.servify.in:3002/");
      //driver.findElement(By.name("username")).sendKeys("karan.b@servify.in"); 
       String homePageUrl = driver.getCurrentUrl();
       AssertJUnit.assertEquals(homePageUrl, "http://staging.servify.in:3000/");
       Thread.sleep(2000); 
 }
     @Test	(priority=3)
     public void UserLoginServify360Dashbord () throws InterruptedException {
	 driver.findElement(By.name("username")).sendKeys("superadmin ");
     driver.findElement(By.name("next")).click();	
     Thread.sleep(2000);
     //driver.findElement(By.name("password")).sendKeys("|$JBRmed+K#im");
    driver.findElement(By.name("password")).sendKeys("1414286540");
     driver.findElement(By.name("submit")).click();
     Thread.sleep(2000); 
     String HomepageURl = driver.getCurrentUrl();
     AssertJUnit.assertEquals(HomepageURl, "http://staging.servify.in:3000/dashboard");
     Thread.sleep(6000);
     WebElement element =driver.findElement(By.id("filterDashboard"));
     Assert.assertNotEquals(element, null);  
     Thread.sleep(2000);  
     
     System.out.println("Test case has benn pass for jenkins");
  }/*
      @Test (priority=4)
      public void ConsumerTab () throws InterruptedException {
 	      System.out.println("calling consumer tab");
 		// WebElement  sidebar = driver.findElement(By.className("sidebar-report"));
 	     //sidebar.click(); 
 	      driver.findElement(By.className("sidebar-consumers")).click();
 	      Thread.sleep(4000);
 	      //WebElement SomthingWEnterong = driver.findElement(By.className("sweet-content"));
 		  AssertJUnit.assertEquals(driver.getCurrentUrl(), "http://staging.servify.in:3000/consumers");
 	      WebElement Viewbutton = driver.findElement(By.xpath("html/body/consumer/div[1]/div/div/div[4]/div[1]/table/tbody/tr[2]/td[7]/button"));
 	      Assert.assertNotEquals(Viewbutton, null);
 	      Thread.sleep(2000);
 	     
       }
          @Test (priority=5)
          public void ConsumerViewDetilsButtons  () throws InterruptedException{
          WebElement Viewbutton =driver.findElement(By.xpath("html/body/consumer/div[1]/div/div/div[4]/div[1]/table/tbody/tr[3]/td[7]/a/button"));
          Viewbutton.click();
          Thread.sleep(2000);
          Assert.assertNotEquals(driver.getTitle(), null);
         // driver.quit();
       }
           
          @Test   (priority=6)   
          public void  Diagnosistab() throws InterruptedException{
        	  this.driver = new ChromeDriver();
        	  OpenLinkServify360DashbordUrl();
        	  UserLoginServify360Dashbord();
        	  
        	  
       	  driver.findElement(By.className("sidebar-diagnosis")).click();  
       	  Thread.sleep(2000);
       	  WebElement Mobile = driver.findElement(By.id("mobileNo"));
       	  Assert.assertNotEquals(Mobile, null);
             }
           @Test   (priority=7) 
           public void DiagnosisCheckyMobileNO () throws InterruptedException{
       	  WebElement Mobile = driver.findElement(By.id("mobileNo"));
       	  Mobile.sendKeys("8714416083");
       	  WebElement nextbutton = driver.findElement(By.className("button-next"));
       	  nextbutton.click();
       	  Thread.sleep(2000);
       	  WebElement MobileNo = driver.findElement(By.id("fullname"));
       	  Assert.assertNotEquals(MobileNo, null);
       	  Thread.sleep(2000);
          driver.quit();
         }
          			
	   @Test  (priority=8)
           public void PlansTab () throws InterruptedException{
           this.driver = new ChromeDriver();
           OpenLinkServify360DashbordUrl();
     	  UserLoginServify360Dashbord();
      
           Thread.sleep(2000);
           WebElement plans = driver.findElement(By.className("sidebar-plans"));
           plans.click();
           Thread.sleep(3000);
           WebElement Details =driver.findElement(By.className("firepath-matching-node"));
            WebElement PlantDeatilsButton = null;
       	try {
       		PlantDeatilsButton = driver.findElement(By.xpath(
       				"html/body/div[2]/plan_list/div/div[2]/div/div/div/div/table/tbody/tr[7]/td[4]/button"));
       	} catch (Exception e) {
       		// TODO: handle exception
       	}
           Assert.assertNotEquals(Details, null);
           Thread.sleep(2000);
           }
          @Test (priority = 9)
           public void PlansManagementDetails() throws InterruptedException{
           WebElement PlantDeatilsButton = driver.findElement(By.xpath("html/body/div[2]/plan_list/div/div[2]/div/div/div/div/table/tbody/tr[7]/td[4]/button"));
           PlantDeatilsButton.click();
            Thread.sleep(4000);
          	WebElement PlantDeatilsButton1 = driver.findElement(By.xpath(" html/body/div[2]/plan_list/div/div[3]/div/div/div[3] "));
          	PlantDeatilsButton1.click();
          	Thread.sleep(2000);	
          }
	   
           @Test (priority =9)
           public void ReqestTab () throws InterruptedException{
           driver.findElement(By.className("sidebar-requests")).click(); //  Clicking Side bar
           Thread.sleep(3000);
           WebElement raised= (WebElement) driver.findElement(By.className("nav-raised")); 
           Assert.assertNotEquals(raised, null);
           }
	   
*/
}
