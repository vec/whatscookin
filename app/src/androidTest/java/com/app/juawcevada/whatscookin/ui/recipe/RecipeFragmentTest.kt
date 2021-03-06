package com.app.juawcevada.whatscookin.ui.recipe

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.app.juawcevada.whatscookin.R
import com.app.juawcevada.whatscookin.R.id.loadingView
import com.app.juawcevada.whatscookin.util.createFactoryWithNavController
import com.app.juawcevada.whatscookin.util.createNavControllerMock
import com.app.juawcevada.whatscookin.util.checkThatMatches
import com.app.juawcevada.whatscookin.util.createTestFactory
import com.app.juawcevada.whatscookin.util.factories.recipe.RecipeFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class RecipeFragmentTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: RecipeViewModel
    private lateinit var viewState: MutableLiveData<RecipeViewModel.ViewState>
    private lateinit var fragmentScenario: FragmentScenario<RecipeFragment>
    private val mockNavController: NavController = createNavControllerMock(R.id.recipeFragment)

    @Test
    fun showRecipe() {
        startFragment()

        viewState.value = RecipeViewModel.ViewState(
            isLoading = false,
            recipe = RecipeFactory.create(
                title = "Chicken",
                summary = "Summary"
            )
        )

        "Chicken" checkThatMatches isDisplayed()
        "Summary" checkThatMatches isDisplayed()
    }

    @Test
    fun showLoading() {
        startFragment()

        viewState.value = RecipeViewModel.ViewState(
            isLoading = true
        )

        loadingView checkThatMatches isDisplayed()
    }

    private fun initViewState() {
        viewState = MutableLiveData()

        viewModel = mock {
            on { viewState } doReturn this@RecipeFragmentTest.viewState
        }
    }

    private fun startFragment() {
        initViewState()
        fragmentScenario = launchFragmentInContainer(
            fragmentArgs = RecipeFragmentArgs("id").toBundle(),
            themeResId = R.style.AppTheme,
            factory = createFactoryWithNavController(mockNavController) {
                RecipeFragment(
                    mock { on { create(any()) } doReturn viewModel.createTestFactory() }
                )
            }
        )
    }
}
