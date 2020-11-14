package dominando.android.goodfood.view.acticity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.goodfood.R
import dominando.android.goodfood.adapter.RestaurantAdapter
import dominando.android.goodfood.model.MainRestBusiness
import dominando.android.goodfood.viewModel.MainRestViewModel

class MainRestaurants : AppCompatActivity() {
    private lateinit var restaurantAdapter: RestaurantAdapter
    private lateinit var viewModel: MainRestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_restaurants)
viewModel = ViewModelProvider(this).get(MainRestViewModel::class.java)

       val list =viewModel.getRestaurants()


        findViewById<RecyclerView>(R.id.rv_restaurants).apply {
            layoutManager =LinearLayoutManager(this@MainRestaurants)
            adapter = RestaurantAdapter(list){position ->
                val intent = Intent(this@MainRestaurants, DetalhesActivity::class.java)
                val mrestaurant = list[position]
                intent.putExtra(KEY_RESTAURANT,mrestaurant)

                startActivity(intent)


            }

        }
    }
    companion object{
        const val KEY_RESTAURANT = "restaurant"
    }
}