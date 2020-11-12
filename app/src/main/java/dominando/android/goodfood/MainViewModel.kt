package dominando.android.goodfood

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var dataOk:MutableLiveData<Boolean> = MutableLiveData()


    fun atualizaData(data:Boolean){
        dataOk.postValue(data)
    }

    fun validaEmail(email: String): Boolean {

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        return email.trim { it <= ' ' }.matches(emailPattern.toRegex())
    }


}