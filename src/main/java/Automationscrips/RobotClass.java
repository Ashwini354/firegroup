package Automationscrips;
import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent; 
import java.util.Properties;

import com.techarck.config.PropertiesConfguration;

import Reusablemethods.ReusableAllMethod;

public class RobotClass extends ReusableAllMethod{
	private static Properties prop;
	static {
		prop = PropertiesConfguration.loadProperties();
	}

	public static void main(String[] args) throws AWTException {
		Launch(prop.getProperty("qaurl"));
		Robot robot=new Robot(); 
		robot.keyPress(KeyEvent.VK_DOWN);
		
		
		

	}

}
