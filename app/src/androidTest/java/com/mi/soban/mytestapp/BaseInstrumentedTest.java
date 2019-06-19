package com.mi.soban.mytestapp;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BaseInstrumentedTest {

    public  static UiDevice device;
    Instrumentation instrumentation;
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.mi.soban.mytestapp", appContext.getPackageName());
    }

    @Before
    public void setUp() {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        device = UiDevice.getInstance(instrumentation);


    }//end of setup
    public String execute(String strCmd) {
        String str="";
        try {
//device.executeShellCommand(strCmd);


            str=device.executeShellCommand(strCmd);
            //   Runtime.getRuntime().exec(strCmd);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
    public void sleep(int n)
    {
        try
        {
            Thread.sleep(n);
        }
        catch (Exception e){e.printStackTrace();}
    }//sleep function end
}


