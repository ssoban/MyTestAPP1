package com.mi.soban.mytestapp;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Registration_Page extends BaseInstrumentedTest {



    public void launch_truecaller_app()  {

        device.pressHome();
        sleep(5000);
        //launching truecaller app using package and activity name
        execute("am start -n com.truecaller/com.truecaller.ui.TruecallerInit");
        sleep(6000);

        // Validate that the package name is the expected one
        String packagename="com.truecaller";
        String truecaller_validation = device.getCurrentPackageName();
        assertTrue("Unable to detect truecaller App", truecaller_validation.equals(packagename));
        System.out.println("truecaller App launched");
        // adding 5sec delay after app is launched
        sleep(5000);



        sleep(3000);
    }

    public boolean VerifyOnScreenNameTextFields() {

        UiObject name_text_field = device.findObject(new UiSelector().text("nametext").className("android.widget.Button123"));
        try {

            if(name_text_field.exists() && name_text_field.isEnabled())
            {
                Log.i( "Success:Name_Text_field","Verified Name text field");

            }

        }
        catch (UiObjectNotFoundException e)
        {
            Log.i( "Error:Name_Text_field","Unable to verify Name text field");

            return false;
        }
        return true;

    }

    public void verifyOnScreennumberTextFields()
    {
        try{

            UiObject number_text_field = device.findObject(new UiSelector()
                    .text("numbertext")
                    .className("android.widget.Button123"));
            assertTrue("Number text field  doesn't exist", number_text_field.exists());
            assertTrue("Number text field isn't enabled", number_text_field.isEnabled());


        }

        catch(UiObjectNotFoundException e){
            Log.i( "Error:Number_Text_field","Unable to verify phone number text field");


        }

    }
    public void verifyOnScreenEmailTextFields()
    {
        try{

            UiObject Email_text_field = device.findObject(new UiSelector()
                    .text("email")
                    .className("android.widget.Button123"));
            assertTrue("Email Texr field doesn't exist", Email_text_field.exists());
            assertTrue("Email Texr field isn't enabled", Email_text_field.isEnabled());


        }

        catch(UiObjectNotFoundException e){
            Log.i( "Error:Email_Text_field","Unable to verify phone number text field");


        }

    }

    public void verifyOnScreenSubmitbtn() {
        try {

            UiObject submt_btn = device.findObject(new UiSelector()
                    .text("submitbtn")
                    .className("android.widget.Button123"));
            assertTrue("Submit button doesn't exist", submt_btn.exists());
            assertTrue("Submit button isn't enabled", submt_btn.isEnabled());


        } catch (UiObjectNotFoundException e) {
            Log.i("Error:Submit button", "Unable to verify phone number text field");


        }
    }
    public void verifyOnScreenTClink() {
        try {

            UiObject tc_btn = device.findObject(new UiSelector()
                    .text("tclink")
                    .className("android.widget.Button123"));
            assertTrue("TC link doesn't exist", tc_btn.exists());
            assertTrue("TC link isn't enabled", tc_btn.isClickable());


        } catch (UiObjectNotFoundException e) {
            Log.i("Error:TC link", "Unable to verify phone number text field");


        }
    }

    public void verifySignupmessage(String personname, String phonenumber, String emailadd) {

        try {
            UiObject name_text_field = device.findObject(new UiSelector()
                    .text("nametext")
                    .className("android.widget.Button123"));

            sleep(5000);
            //clear text
            name_text_field.clearTextField();
            //Enter name
            name_text_field.setText(personname);

            //enter email
            UiObject number_text_field = device.findObject(new UiSelector()
                    .text("numbertext")
                    .className("android.widget.Button123"));
            number_text_field.clearTextField();
            number_text_field.setText(phonenumber);

            //enter email address
            UiObject Email_text_field = device.findObject(new UiSelector()
                    .text("email")
                    .className("android.widget.Button123"));
            Email_text_field.clearTextField();
            Email_text_field.setText(emailadd);

            //clicking on submit button
            UiObject submt_btn = device.findObject(new UiSelector()
                    .text("submitbtn")
                    .className("android.widget.Button123"));

            submt_btn.clickAndWaitForNewWindow();

            String signupmessage ="hey" + name_text_field.getText().toString()+ "i can reach at " + Email_text_field.getText().toString()+ "or" + number_text_field.getText().toString();

            UiObject signup_msg = device.findObject(new UiSelector()
                    .text("signuptext")
                    .className("android.widget.Button123"));
            //Validating the message
            assertEquals(signupmessage, signup_msg.getText().toString().trim());



        } catch (UiObjectNotFoundException e) {
            Log.i("Error:Number_Text_field", "Unable to verify phone number text field");


        }
    }

    public void verifyLinkbtn() {
        try {
            sleep(5000);
            UiObject lnk_btn = device.findObject(new UiSelector()
                    .text("numbertext")
                    .className("android.widget.Button123"));
            assertTrue("Link btn exist", lnk_btn.exists());
            assertTrue("link btn isn't enabled", lnk_btn.isClickable());
            sleep(5000);
            lnk_btn.clickAndWaitForNewWindow();
            device.pressBack();


        } catch (UiObjectNotFoundException e) {
            Log.i("Error:Number_Text_field", "Unable to verify phone number text field");


        }
    }



}

