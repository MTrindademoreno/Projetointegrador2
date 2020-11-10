package dominando.android.goodfood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class FragmentLogin : Fragment() {
    private lateinit var mainViewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        activity?.let {
            mainViewModel = ViewModelProvider(it).get(MainViewModel::class.java)
            it.findViewById<Button>(R.id.btn_register_login).setOnClickListener {
                mainViewModel.atualizaData(true)
            }

        }

    }
}