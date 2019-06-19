package com.mi.soban.mytestapp;

import android.util.Log;

import org.junit.Test;

import java.util.logging.Logger;

public class Smoke_Suite_Registration_Page extends BaseInstrumentedTest {

    Registration_Page signup =new Registration_Page();
    public Smoke_Suite_Registration_Page(){

        this.device=device;
    }
    @Test
    public void TC_01(){

        signup.launch_truecaller_app();

    }
    @Test
    public void TC_02(){
        signup.VerifyOnScreenNameTextFields();
        signup.verifyOnScreennumberTextFields();
        signup.verifyOnScreenEmailTextFields();
        signup.verifyOnScreenSubmitbtn();;
        signup.verifyOnScreenTClink();
    }

    @Test
    public void TC_03(){
        signup.verifySignupmessage("soban","727290909090","abc@gmail.com");

    }
    @Test
    public void TC_04(){
        signup.verifyLinkbtn();

    }
}
