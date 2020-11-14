package dominando.android.goodfood.view.acticity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dominando.android.goodfood.view.acticity.MainRestaurants.Companion.KEY_RESTAURANT
import dominando.android.goodfood.view.fragment.PratosFragment
import dominando.android.goodfood.R
import dominando.android.goodfood.model.Restaurant
import dominando.android.goodfood.view.fragment.FragmentDetalhePrato
import dominando.android.goodfood.viewModel.DetalhesViewModel

class DetalhesActivity : AppCompatActivity() {
    private lateinit var detalhesViewModel: DetalhesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
    detalhesViewModel = ViewModelProvider(this).get(DetalhesViewModel::class.java)

        val restaurant = intent.getParcelableExtra<Restaurant>(KEY_RESTAURANT)
        if (restaurant != null) {
            detalhesViewModel.atualizaDetalhes(restaurant)


            loadFragment(PratosFragment())
            backFragment()

            detalhesViewModel.pos.observe(this, Observer {
                loadFragment(FragmentDetalhePrato())
            })


            detalhesViewModel.backD.observe(this, Observer {
                loadFragment(PratosFragment())
            })


        }


    }



    private fun backFragment() {
        detalhesViewModel.back.observe(this, Observer {
            finish()
        })
    }

    private fun loadFragment(fragment:Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container_pratos,fragment)
            .commit()    }
}