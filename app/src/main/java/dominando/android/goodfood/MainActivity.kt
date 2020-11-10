package dominando.android.goodfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)



        loadfragment(FragmentLogin())
        mainViewModel.dataOk.observe(this, Observer {
            if (it==true){

                loadfragment(RegisterFragment())

            }
        })
    }

    private fun loadfragment(fragment: Fragment) {
        val ft= supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .commit()
    }
}