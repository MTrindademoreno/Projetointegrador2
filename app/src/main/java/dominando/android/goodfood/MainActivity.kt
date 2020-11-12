package dominando.android.goodfood

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        loadfragment(FragmentLogin())
        mainViewModel.dataOk.observe(this, Observer {
            if (it == true) {
                loadfragment(RegisterFragment())
            }
        })

    }

    private fun loadfragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}