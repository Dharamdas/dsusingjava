package designpattern.creationalpatterns.abfactory;

public class FactoryDemo {

	public static void main(String[] args) {
		
		Logger logger= FactoryLogger.getLoggerObject(new FileLoggerFactory());
		logger.log();
	}

}
