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
import dominando.android.goodfood.model.Prato

class PratosAdapter(
    private val listaPratos:List<Prato>,
    private val clickPrato:(Int)->Unit
):RecyclerView.Adapter<PratosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context)
          .inflate(R.layout.item_prato,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaPratos[position],clickPrato)
    }

    override fun getItemCount(): Int {
        return listaPratos.size
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(prato: Prato, clickPrato: (Int) -> Unit)= with(itemView){

            findViewById<TextView>(R.id.txt_nome_prato).text = prato.nome
            Picasso.get().load(prato.imgPrato).into(findViewById<ImageView>(R.id.image_prato))

            findViewById<CardView>(R.id.layout_prato).setOnClickListener {
                clickPrato(this@ViewHolder.adapterPosition)
            }



        }

    }

}