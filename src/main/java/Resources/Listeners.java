package Resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.Basepage;

public class Listeners extends Basepage implements ITestListener {

	public Listeners() throws IOException {
		super();
	}
  public void onTestFailure(ITestResult result) {
	  
	  try {
	  takeSnapShot(result.getName());
  }
	  catch(Exception e) {
	  e.printStackTrace();
  }
}
}
