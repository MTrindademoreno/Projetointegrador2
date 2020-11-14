package dominando.android.goodfood.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import dominando.android.goodfood.R
import dominando.android.goodfood.viewModel.DetalhesViewModel

class FragmentDetalhePrato : Fragment() {

private lateinit var viewModel:DetalhesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalhe_prato, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel=ViewModelProvider(requireActivity()).get(DetalhesViewModel::class.java)

            viewModel.pos.observe(this,Observer{pos->
                val prato = pos
                it.findViewById<TextView>(R.id.txt_descritivo).text = prato.descricao
                it.findViewById<TextView>(R.id.txt_nome_prato).text = prato.nome

                Picasso.get().load(prato.imgPrato).into(it.findViewById<ImageView>(R.id.img_card_pratos_f))


            })

            it.findViewById<ImageView>(R.id.img_back_d).setOnClickListener {

                    viewModel.backFragmentD()

            }




        }
    }


}