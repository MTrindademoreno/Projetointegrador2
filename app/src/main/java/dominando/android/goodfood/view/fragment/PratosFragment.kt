package dominando.android.goodfood.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dominando.android.goodfood.R
import dominando.android.goodfood.adapter.PratosAdapter
import dominando.android.goodfood.model.Prato
import dominando.android.goodfood.viewModel.DetalhesViewModel


class PratosFragment : Fragment() {
    private lateinit var detalhesViewModel: DetalhesViewModel
    lateinit var list: List<Prato>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pratos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler()
        back()


    }

    private fun back() {
        activity?.findViewById<ImageView>(R.id.img_back)?.setOnClickListener {
            detalhesViewModel.backFragment()
        }
    }

    private fun recycler() {
        activity?.let {
            detalhesViewModel = ViewModelProvider(it).get(DetalhesViewModel::class.java)
            detalhesViewModel.restaurantDetalhes.observe(this, { valor ->
                list = valor.pratos
                Picasso.get().load(valor.image)
                    .into(it.findViewById<ImageView>(R.id.img_card_pratos))

                it.findViewById<TextView>(R.id.txt_nome_restaurant_detalhe).text = valor.nome

                it.findViewById<RecyclerView>(R.id.rv_recycler_pratos).apply {
                    layoutManager = GridLayoutManager(requireActivity(), 2)
                    adapter = PratosAdapter(list) { pos ->
                        detalhesViewModel.setPosition(list[pos])


                    }
                }
            })

        }
    }


}
