package dominando.android.goodfood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PratosAdapter(
    private val listaPratos:List<Pratos>,
    private val clickPrato:(Int)->Unit
):RecyclerView.Adapter<PratosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PratosAdapter.ViewHolder {
      val view = LayoutInflater.from(parent.context)
          .inflate(R.layout.item_prato,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: PratosAdapter.ViewHolder, position: Int) {
        holder.bind(listaPratos[position],clickPrato)
    }

    override fun getItemCount(): Int {
        return listaPratos.size
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(pratos: Pratos, clickPrato: (Int) -> Unit)= with(itemView){

            findViewById<TextView>(R.id.txt_nome_prato).text = pratos.nome
            Picasso.get().load(pratos.imgPrato).into(findViewById<ImageView>(R.id.image_prato))
            clickPrato(this@ViewHolder.adapterPosition)


        }

    }

}