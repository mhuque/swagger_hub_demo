package swaglabs.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import swaglabs.basepage.BasePage;

public class Hooks extends BasePage {

	
	
	
    @Before
    public void applicationStart() {
    	setUP();
    }
    
    
    @After
 	public void tearDown() {
 		driver.quit();
 	}
}
