package dominando.android.goodfood

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class FragmentLogin : Fragment() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mEmail: EditText
    private lateinit var mEditPassword: EditText


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
        }

        initComponents()

    }

    private fun initComponents() {

        activity?.let { activity ->
            mEmail = activity.findViewById<EditText>(R.id.edt_email_login)
            mEditPassword = activity.findViewById<EditText>(R.id.edt_password_login)

            val mbtn_Register = activity.findViewById<Button>(R.id.btn_register_login)
            val mbtn_Login = activity.findViewById<Button>(R.id.btn_login)
            mbtn_Login.setOnClickListener {
                val mailvalida = mEmail.editableText.toString()
                val mPassword = mEditPassword.editableText.toString()
                if (mPassword.isEmpty()) {
                    mEditPassword.setError(getString(R.string.emptyPassword))
                }
                if (mailvalida.isEmpty()) {
                    mEmail.setError(getString(R.string.emptyEmail))
                } else {
                    if (mainViewModel.validaEmail(mailvalida)) {
                        val intent = Intent(requireContext(), MainRestaurants::class.java)
                        startActivity(intent)
                        activity.finish()

                    }else{
                        mEmail.setError(getString(R.string.invalidEmail))
                    }
                }


            }

            mbtn_Register.setOnClickListener {
                mainViewModel.atualizaData(true)

            }


        }
    }


}