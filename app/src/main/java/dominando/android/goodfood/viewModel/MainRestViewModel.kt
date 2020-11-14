package dominando.android.goodfood.viewModel

import androidx.lifecycle.ViewModel
import dominando.android.goodfood.model.MainRestBusiness
import dominando.android.goodfood.model.Restaurant

class MainRestViewModel:ViewModel() {

    val business = MainRestBusiness()

    fun getRestaurants():List<Restaurant>{
        return business.getRestaurants()
    }
}