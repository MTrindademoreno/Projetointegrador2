package dominando.android.goodfood.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var dataOk:MutableLiveData<Boolean> = MutableLiveData()
    val go:MutableLiveData<Boolean> = MutableLiveData()



    fun atualizaData(data:Boolean){
        dataOk.postValue(data)
    }

//    fun validaEmail(email: String): Boolean {
//
//        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
//
//        return email.trim { it <= ' ' }.matches(emailPattern.toRegex())
//    }
    fun validaEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun goFragmentInit(){
        go.postValue(true)
    }

}