package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723";
    private static Platform instance;
    private Platform(){}

    public static Platform getInstance()
    {
        if(instance == null)
        {
            instance = new Platform();
        }
        return instance;
    }

    public AppiumDriver getDriver() throws Exception
    {
        URL url = new URL(APPIUM_URL);
        if (this.isAndroid())
        {
            return new AndroidDriver(url, this.getAndroidDesiredCapabilities());
        } else if (this.isiOS())
        {
            return new IOSDriver(url, this.getiOSDesiredCapabilities());
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value: " + this.getPlatformVar());
        }
    }
    public boolean isAndroid()
    {
        return isPlatform(PLATFORM_ANDROID);
    }
    public boolean isiOS()
    {
        return isPlatform(PLATFORM_IOS);
    }

    private boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }
    private String getPlatformVar(){
        return System.getenv("PLATFORM");
    }
    private DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app",
                "/Users/arslan/Desktop/course/apks/org.wikipedia.apk");
        capabilities.setCapability("automationName",
                "UiAutomator2");
        return capabilities;
    }
    private DesiredCapabilities getiOSDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("deviceName","iPhone SE (3rd generation)");
        capabilities.setCapability("platformVersion","16.4");
        capabilities.setCapability("app",
                "/Users/arslan/Desktop/course/apps/Wikipedia.app");
        capabilities.setCapability("automationName","XCUITest");
        return capabilities;
    }
}
