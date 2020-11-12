package dominando.android.goodfood

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainRestaurants : AppCompatActivity() {
    private lateinit var restaurantAdapter: RestaurantAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_restaurants)

        val listaPrato  = listOf(
            Pratos("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSXnumMuguhtjzdeLamoDZRM7ItyN9-F0fmaw&usqp=CAU","Filet","Somente filet sem nada"),Pratos("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSXnumMuguhtjzdeLamoDZRM7ItyN9-F0fmaw&usqp=CAU",
                "Filet","Somente filet sem nada"),Pratos("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSXnumMuguhtjzdeLamoDZRM7ItyN9-F0fmaw&usqp=CAU",
                "Filet","Somente filet sem nada"),Pratos("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSXnumMuguhtjzdeLamoDZRM7ItyN9-F0fmaw&usqp=CAU",
                "Filet","Somente filet sem nada"),Pratos("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSXnumMuguhtjzdeLamoDZRM7ItyN9-F0fmaw&usqp=CAU",
                "Filet","Somente filet sem nada"),Pratos("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSXnumMuguhtjzdeLamoDZRM7ItyN9-F0fmaw&usqp=CAU",
                "Filet","Somente filet sem nada"),Pratos("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSXnumMuguhtjzdeLamoDZRM7ItyN9-F0fmaw&usqp=CAU",
                "Filet","Somente filet sem nada")
        )
        val list = listOf<Restaurant>(
            Restaurant("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSSgGSXMNRq1AmAg8eeaeVCXL5cULu1L-ylzQ&usqp=CAU",
                "PF Do Zé",
                "Rua mafra ,121-Jabaquara",
                "Fecha às 19:00",listaPrato),
            Restaurant("https://uploads.metropoles.com/wp-content/uploads/2019/06/19164343/Pizza.jpeg",
                "Pizzaria Babbo Luigi",
                "Rua Itália ,21-Bixiga",
                "Fecha às 00:00",listaPrato),
            Restaurant("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRn9bftrvJ-KUoOpE9Nnf2p8dRMYl3GpDkN-Q&usqp=CAU",
                "Casa do Camarão",
                "Rua do Porto ,100-Centro","19:00",listaPrato),
            Restaurant("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ_oefUPQBr1CRspNMAstI7NApvBYgQstiSkA&usqp=CAU",
                "O Feijuca",
                "Av. Europa,21-Jardins",
                "Fecha às 20:00",listaPrato),
            Restaurant("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQQm-VgKjaE5K_bDQt4psSxGY60j8IfJG05eA&usqp=CAU",
                "Gauchão",
                "Rua do Sul ,1-Pinheiros",
                "Fecha às 19:00",listaPrato),
            Restaurant("https://img.elo7.com.br/product/original/24E2F9A/painel-adesivo-comida-japonesa-prato-parede-restaurante-hd-adesivo-parede-infantil.jpg",
                "Sushi Japa",
                "Rua da Glória ,12-Liberdade",
                "Fecha às 21:00",listaPrato),
            Restaurant("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSBhLW9QsXmUfrkljn2tPrS75Vb5DSmYz2ivw&usqp=CAU",
                "PF Do Zé",
                "Rua mafra ,121-Jabaquara",
                "19:00",listaPrato),
            Restaurant("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSH74UgYhXhCXPFyIBdGcOkcB4ymGS7x07YbQ&usqp=CAU",
                "Shawarma's",
                "Rua Libano ,99-Brás",
                "18:00",listaPrato),
            Restaurant("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR8c_0pz_xV1PHZF4OU0peVaMehDo8RQYUi5w&usqp=CAU",
                "Cremes e Cia",
                "Rua sete lagoas ,45-Lapa",
                "Não Fecha",listaPrato),
            Restaurant("https://res.cloudinary.com/tf-lab/image/upload/restaurant/03b515a3-2ca0-43f5-a01c-cb84096b41df/18c82651-a8e4-4548-b3fc-1beb2c3040fd.jpg",
                "Hero´s Burger",
                "Av. Nova ,1567-Pinheiros",
                "Fecha às 23:00",listaPrato)
        )

        findViewById<RecyclerView>(R.id.rv_restaurants).apply {
            layoutManager =LinearLayoutManager(this@MainRestaurants)
            adapter = RestaurantAdapter(list){position ->
                val intent = Intent(this@MainRestaurants,DetalhesActivity::class.java)
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