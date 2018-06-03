package br.com.tramalho.githubmvpkotlin.presentation

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import br.com.tramalho.githubmvpkotlin.infraestructure.CustomApplicationImpl
import org.junit.runner.RunWith
import br.com.tramalho.githubmvpkotlin.setup.infraestructure.CustomMockApplication
import org.hamcrest.Matchers.anyOf
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Rule



@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testMockApplication() {
        val application = mActivityTestRule.getActivity().getApplication()
        assertEquals(CustomMockApplication::class.java.simpleName, application.javaClass.getSimpleName())
    }

    @Test
    fun testShowRepos() {
        Thread.sleep(1000);
        onView(anyOf(withText("ReactiveX/RxJava")))
                .check(matches(isDisplayed()));
    }
}
