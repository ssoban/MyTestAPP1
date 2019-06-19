# MyTestAPP1
EspressoFramework

for reference: https://developer.android.com/training/testing/ui-testing 
Build your own registration page and Test ui with espresso:

Steps to create Espresso Framework with uiaotomator
Pre-requiste:
Java 
Android Studio 
Espresso Libraries
Test Single app(Under development)
1:Setup android studio:
2: Create a new Java Project with basic activity.(Try to run once to see app in mobile device is working).
1: Do changes in res >> layout >>  content_main.xml
choose text or pick n drop 
>...........................................................
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:visibility="visible"
    tools:context=".MainActivity"
    tools:showIn="@layout/activity_main"
    android:orientation="vertical"
    android:gravity="center_horizontal"
    android:layout_gravity="center_vertical"
    android:layout_marginTop="100dp">

    <EditText
        android:id="@+id/name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="40dp"
        android:minEms="10"
        android:saveEnabled="false"
        android:importantForAutofill="no"/>

    <EditText
        android:id="@+id/email"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="40dp"
        android:gravity="center_horizontal"
        android:minEms="10"
        android:importantForAutofill="no"/>

    <EditText
        android:id="@+id/phonenumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="40dp"
        android:minEms="10"
        android:importantForAutofill="no" />



    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="40dp"
        >

        <Button
            android:id="@+id/submit"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:minEms="10"
            android:text="Button"/>

        <Button
            android:id="@+id/TC"
            style="@android:style/Widget.Holo.Light.Button.Small"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="20dp"
            android:minEms="10"
            android:text="TC" />


    </LinearLayout>

</LinearLayout>
................................................................................................................./>
b: Now go to main activity  and do  the below changes :(write actions as per your requirement)
import static android.support.test.InstrumentationRegistry.getContext;

public class MainActivity extends AppCompatActivity {
    public EditText email,phonenumber,name;
    public Button submit;
    public Button TC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is just a example", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phonenumber = (EditText) findViewById(R.id.phonenumber);
        submit = (Button) findViewById(R.id.submit);
        TC=(Button)findViewById(R.id.TC);

        phonenumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // do your stuff here
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                }
                return false;
            }

        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().trim().length()>0 && email.getText().toString().trim().length()>0 && phonenumber.getText().toString().trim().length()>0){
                    Snackbar.make(view, "Hi, I am " + name.getText().toString().trim() + "I can be reach at " + phonenumber.getText().toString().trim() +"or" +email.getText().toString().trim(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
                    Snackbar.make(view, "Error:Empty Text field", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        TC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*WebView mywebview = (WebView) findViewById(R.id.webView);


                mywebview.loadUrl(url);*/

                String url="http://urlecho.appspot.com/echo?sta- tus=200&ContentType=text%2Fhtml&body=Hello%20Truecaller)";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                try {
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } catch (ActivityNotFoundException exception) {
                    Toast.makeText(getContext(), "Error text", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
.............................................................................................................................


3: Configure build.gradle(Module xml as below).
........................................
dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    implementation 'com.android.support:design:28.0.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/espresso-contrib-2.2-release-no-dep.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/espresso-core-2.2-release-no-dep.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/espresso-idling-resource-2.2-release-no-dep.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/espresso-intents-2.2-release-no-dep.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/espresso-web-2.2-release-no-dep.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/exposed-instrumentation-api-publish-0.3-release-no-dep.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/guava-18.0.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/hamcrest-core-1.3.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/hamcrest-integration-1.3.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/hamcrest-library-1.3.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/javawriter-2.1.1.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/javax.annotation-api-1.2.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/javax.inject-1.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/jsr305-2.0.1.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/junit-4.12.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/rules-0.3-release-no-dep.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/runner-0.3-release-no-dep.jar')
    implementation files('C:/Users/soban/AndroidStudioProjects/MyTestAPP1/libs/uiautomator-v18-2.1.1-release-no-dep.jar')
}
.................................................
4:Add libs folder and add these libraries and change the path
5: Now Do changes in Example Instrumented class under App > Java > <package> android test (Project structure as View). 
..............................................
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
        }
.................................................................................................

   6: Now make espresso class and do changes 
   
   @RunWith(AndroidJUnit4.class)
public class Espresso_Testing_basic {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void TC01VerifyOnScreenObjectsActivityLaunch() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.name)).check(matches(isDisplayed()));

        onView(withId(R.id.email)).check(matches(isDisplayed()));

        onView(withId(R.id.phonenumber)).check(matches(isDisplayed()));

        onView(withId(R.id.submit)).check(matches(isDisplayed()));

        onView(withId(R.id.TC)).check(matches(isDisplayed()));

        onView(withId(R.id.fab)).check(matches(isDisplayed()));

        onView(withId(R.id.fab)).perform(click());
        Thread.sleep(5000);
    }
...................................................................................................................................................
   
Now Run the test with espresso  cases:

To test Multiple apps using uiautomator:
1; Create a project .
2: Repeat 3/4/5/ points as above.
3: Make a new clase under app> java > android Test which extends Instrumented base clase and write your code as below  :

public void launch_any_app()  {

        device.pressHome();
        sleep(5000);
        //launching truecaller app using package and activity name
        execute("am start -n package/activity"); 
        sleep(6000);

        // Validate that the package name is the expected one
        String packagename="com.appr";
        String app_validation = device.getCurrentPackageName();
        assertTrue("Unable to detect truecaller App", app_validation.equals(packagename));
        System.out.println("'app' App launched");
        // adding 5sec delay after app is launched
        sleep(5000);



        sleep(3000);
    }
............................
Write below code under base instrumented class if you using above:
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
    .....................................
    
    Or just pull or cline my code
