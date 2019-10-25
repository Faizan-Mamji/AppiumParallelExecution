package JeeniePomDriverTwo;

import DriverAppium.MainConfiguration;
import DriverAppium.MainDriverCalling;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class LinguistFeedbackCustomer extends MainDriverCalling {

    MainConfiguration objConf = new MainConfiguration();

    public LinguistFeedbackCustomer(AndroidDriver<MobileElement> driver) {
        this.driverTwo = driver;
    }

    public List<MobileElement> feedbackStep1ForCustomer() {
        return driverTwo.findElementsByXPath("//android.widget.TextView[@index='0']");
    }

    public MobileElement feedbackNextBtn() {
        return driverTwo.findElementByAndroidUIAutomator("text(\"" + objConf.getNextbtnText() + "\")");
    }

    public MobileElement feedbackStep2SelectTypeOfCall() {
        return driverTwo.findElementByAndroidUIAutomator("text(\"" + objConf.getCallTypeText() + "\")");
    }

    public MobileElement clickCallDetailsSection() {
        return driverTwo.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android.widget.ScrollView\")).scrollIntoView("
                + "new UiSelector().text(\"" + objConf.getCallDetailsText() + "\"))");
    }

    public List<MobileElement> typeComments() {
        return driverTwo.findElementsByAndroidUIAutomator("text(\"" + objConf.getCommentsMessageText() + "\")");
    }

    public List<MobileElement> closeCommentsEvent() {
        return driverTwo.findElementsByAndroidUIAutomator("text(\"" + objConf.getCloseEventMessageText() + "\")");
    }

    public MobileElement feedbackSubmitBtn() {
        return driverTwo.findElementByXPath("//android.widget.TextView[@text='Submit']");
    }
}
