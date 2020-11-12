package dominando.android.goodfood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class PratosFragment : Fragment() {
    private lateinit var detalhesViewModel: DetalhesViewModel
    lateinit var list: List<Pratos>
    private lateinit var pratosAdapter: PratosAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pratos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        activity?.let {
            detalhesViewModel = ViewModelProvider(it).get(DetalhesViewModel::class.java)
            detalhesViewModel.restaurantDetalhes.observe(this, { valor ->
                list = valor.pratos
                Picasso.get().load(valor.image).into(it.findViewById<ImageView>(R.id.img_card_pratos))
                it.findViewById<RecyclerView>(R.id.rv_recycler_pratos).apply {
                    layoutManager = GridLayoutManager(it,2)
                    adapter = PratosAdapter(list) {
                        Toast.makeText(requireContext(), "ok", Toast.LENGTH_SHORT).show()
                    }
                }
            })

        }


    }


}
