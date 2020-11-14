package dominando.android.goodfood.view.acticity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dominando.android.goodfood.R
import dominando.android.goodfood.view.fragment.FragmentDetalhePrato
import dominando.android.goodfood.view.fragment.RegisterFragment
import dominando.android.goodfood.view.fragment.FragmentLogin
import dominando.android.goodfood.view.fragment.PratosFragment
import dominando.android.goodfood.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        loadfragment(FragmentLogin())
        mainViewModel.dataOk.observe(this, Observer {
            if (it) {
                loadfragment(RegisterFragment())
            }
        })
        mainViewModel.go.observe(this, Observer {
            if (it){
                loadfragment(PratosFragment())
            }
        })

    }

    private fun loadfragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}