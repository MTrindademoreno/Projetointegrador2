package dominando.android.goodfood.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dominando.android.goodfood.R
import dominando.android.goodfood.viewModel.MainViewModel


class RegisterFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        activity?.let {


            it.findViewById<Button>(R.id.btn_register_frag_register).setOnClickListener { v ->
                var ok :Boolean = true
                val mNome = it.findViewById<EditText>(R.id.edt_name)
                val nome = mNome.editableText.toString()
                val mEmail = it.findViewById<EditText>(R.id.edt_email_register)
                val email = mEmail.editableText.toString()
                val mPassword = it.findViewById<EditText>(R.id.edt_password_register)
                val password = mPassword.editableText.toString()
                val mRpassword = it.findViewById<EditText>(R.id.edt_r_password)
                val Rpassword = mRpassword.editableText.toString()

                if (nome.isEmpty()) {
                    mNome.error = getString(R.string.campo_obrigatorio)
                    ok=false
                }

                if (email.isEmpty()) {
                    ok=false
                    mEmail.error = getString(R.string.campo_obrigatorio)
                }else{if (!viewModel.validaEmail(email)) {
                    mEmail.error = getString(R.string.invalidEmail)
                    ok=false
                }
                }

                if (password.isEmpty()) {
                    mPassword.error = getString(R.string.campo_obrigatorio)
                    ok=false
                }

                if (Rpassword.isEmpty()) {
                    mRpassword.error = getString(R.string.campo_obrigatorio)
                    ok=false
                }else{if (Rpassword != password) {
                    mRpassword.error = "Não confere com a senha digitada!"
                    ok=false
                } }

                if(ok){
                    viewModel.goFragmentInit()
                }






            Toast.makeText(requireContext(), "$nome", Toast.LENGTH_SHORT).show()

        }
    }
}


}