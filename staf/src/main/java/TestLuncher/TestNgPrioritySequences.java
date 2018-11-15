package TestLuncher;

import org.testng.annotations.Test;

public class TestNgPrioritySequences {
  @Test(priority=0)
  public void One() {
	  System.out.println("One");
  }
  
  @Test(priority=1,enabled=false)	//If we don't want to execute one test out of four then we need to pass "enabled=false"
  public void Two() {
	  System.out.println("Two");
  }
  @Test(priority=2)
  public void Three() {
	  System.out.println("Three");
  }
  @Test(priority=4)
  public void Four() {
	  System.out.println("Four");
  }
}
