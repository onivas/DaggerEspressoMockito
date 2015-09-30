package com.savinoordine.daggerespressomockito;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class,
            true,     // initialTouchMode
            false);   // launchActivity. False we launch it from the test

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();

        Alphabet alphabet = Mockito.mock(Alphabet.class);
        Mockito.when(alphabet.getStringA()).thenReturn("blablabla");

        List<String> stringList = Arrays.asList("aaa", "sss", "ddd", "fff", "ggg", "hhh", "jjj");;
        DataSource dataSource = Mockito.mock(DataSource.class);
        Mockito.when(dataSource.getItems()).thenReturn(stringList);

        DemoApplication app = (DemoApplication) instrumentation.getTargetContext().getApplicationContext();
        // Some explaination https://blog.gouline.net/2015/05/04/dagger-2-even-sharper-less-square/
        DemoComponent component = DaggerDemoApplication_ApplicationComponent.builder()
                .alphabetModule(new MockAlphabetModule(alphabet))
                .dataSourceModule(new MockDataSourceModule(dataSource))
                .build();

        app.setComponent(component);
    }

    @Test
    public void pressButton() {

        activityRule.launchActivity(new Intent());

        onView(withId(R.id.button)).perform(click());

        onView(withText("blablabla"))
            .check(matches(isDisplayed()));
    }

    @Test
    public void scrollRecycleView() {

        activityRule.launchActivity(new Intent());

        //onData(matches(AllOf(withId(R.id.my_recycler_view), instanceOf(RecycleViewFragment)))).atPosition()
        
        onView(withText("aaa")).check(matches(isDisplayed()));
    }

}
