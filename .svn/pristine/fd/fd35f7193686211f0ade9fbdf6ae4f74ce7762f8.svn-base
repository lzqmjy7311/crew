package com.huateng.fs.micro.demo.test;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.huateng.flowswitch.micro.ctl.GeneratorControl;

public class BaseTestCase extends TestCase {
	
	@BeforeClass
	public  void setUp() throws Exception{
		String switchpath = System.getProperty("user.dir").replace("\\", "/")+"/WebContent/WEB-INF/switch";
		GeneratorControl.init(switchpath);
		GeneratorControl.start();
	}
	
	@AfterClass
	public void tearDown() throws Exception{
		GeneratorControl.stop();
		GeneratorControl.destory();
	}
	

}
