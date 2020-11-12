package dominando.android.goodfood

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetalhesViewModel:ViewModel() {

    val restaurantDetalhes:MutableLiveData<Restaurant> = MutableLiveData()

    fun atualizaDetalhes(restaurant: Restaurant){
        restaurantDetalhes.postValue(restaurant)
    }
}