import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class XmlExecutor {

    public static void main(String[] args) {
        TestNG runner = new TestNG();
        List<String> suitefiles = new ArrayList<String>();
//        suitefiles.add("testng.xml");
//        suitefiles.add("testng1.xml");
//        suitefiles.add("testng2.xml");
//        suitefiles.add("testng3.xml");
        suitefiles.add("testng4.xml");
        suitefiles.add("testng5.xml");
        runner.setTestSuites(suitefiles);
        runner.run();
    }

}
