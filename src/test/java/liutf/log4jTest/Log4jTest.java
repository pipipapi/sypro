/**   
 * @title: Log4jTest.java 
 * @package: liutf.log4jTest 
 * @description: TODO
 * @author liutf  
 * @date 2015年5月29日 下午4:31:05 
 * @version 1.0.0 
 */
package liutf.log4jTest;

import org.apache.log4j.*;

import java.io.IOException;

/** 
 * @description: TODO
 * @author: liutf
 * @date: 2015年5月29日 下午4:31:05 
 * @version: V1.0.0
 */
public class Log4jTest {
	
	public Logger log = Logger.getLogger(Log4jTest.class);
	
	public void doTest() throws IOException{
		/*BasicConfigurator.configure();
		
//		HTMLLayout layout = new HTMLLayout();
		SimpleLayout layout = new SimpleLayout();
		//ConsoleAppender appender = new ConsoleAppender(layout);
		FileAppender appender = new FileAppender(layout,"E:\\out.txt",false);
		
		log.addAppender(appender);
		
		log.setLevel(Level.DEBUG);
		
		log.debug("debug--");
		log.info("info--");
		log.warn("warn--");
		log.error("error--");
		log.info("message");*/
	}
	
	
	public static void main(String[] args) throws IOException {
		Log4jTest lTest = new Log4jTest();
		lTest.doTest();
		
	}

}
