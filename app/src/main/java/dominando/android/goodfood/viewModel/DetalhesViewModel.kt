package dominando.android.goodfood.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dominando.android.goodfood.model.Prato
import dominando.android.goodfood.model.Restaurant

class DetalhesViewModel:ViewModel() {

    val restaurantDetalhes:MutableLiveData<Restaurant> = MutableLiveData()
    val back:MutableLiveData<Boolean> = MutableLiveData()
    val backD:MutableLiveData<Boolean> = MutableLiveData()
    val pos:MutableLiveData<Prato> = MutableLiveData()
    fun atualizaDetalhes(restaurant: Restaurant){
        restaurantDetalhes.postValue(restaurant)
    }

    fun backFragment(){
        back.postValue(true)
    }
    fun backFragmentD(){
        backD.postValue(true)

    }

    fun setPosition(position:Prato){
        pos.postValue(position)

    }
}