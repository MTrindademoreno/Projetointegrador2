package dominando.android.goodfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import dominando.android.goodfood.MainRestaurants.Companion.KEY_RESTAURANT

class DetalhesActivity : AppCompatActivity() {
    private lateinit var detalhesViewModel: DetalhesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
    detalhesViewModel = ViewModelProvider(this).get(DetalhesViewModel::class.java)

        val restaurant = intent.getParcelableExtra<Restaurant>(KEY_RESTAURANT)
        if (restaurant != null) {
            detalhesViewModel.atualizaDetalhes(restaurant)
            Log.i("sos", "${restaurant.pratos[1].nome}")
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.container_pratos,PratosFragment())
                .commit()
        }


    }
}