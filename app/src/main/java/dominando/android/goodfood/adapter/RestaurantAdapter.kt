package dominando.android.goodfood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dominando.android.goodfood.R
import dominando.android.goodfood.model.Restaurant

class RestaurantAdapter(

    private val listRestautants:List<Restaurant>,
    private val eventoClick:(Int)->Unit

):RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurants,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listRestautants[position],eventoClick)

    }

    override fun getItemCount(): Int {
        return listRestautants.size
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bind(restaurant: Restaurant, eventoClick: (Int) -> Unit)=with(itemView){

            Picasso.get().load(restaurant.image).into(findViewById<ImageView>(R.id.img_item_restaurant))

            findViewById<TextView>(R.id.txt_name_restaurant).text = restaurant.nome
            findViewById<TextView>(R.id.txt_endereco_restaurant).text = restaurant.endereco
            findViewById<TextView>(R.id.txt_horario_restaurant).text = restaurant.horario
            findViewById<CardView>(R.id.layout_item).setOnClickListener {
                eventoClick(this@ViewHolder.adapterPosition)

            }


        }

    }
}