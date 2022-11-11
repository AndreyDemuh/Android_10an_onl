package com.example.firstapp.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.firstapp.*
import com.example.firstapp.databinding.FragmentLogInBinding
import com.example.firstapp.repositories.SharePreferencesRepository
import com.example.firstapp.ui.fragments.TaskFragment

class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener { onLogIn() }
        binding.btnSignUpReturn.setOnClickListener { onClickReturnSignUp() }
    }

    //функция проверяющая результат валидации полей Email и Password
    private fun validate(): Boolean {
        val isPasswordValid = validatePassword()
        val isEmailValid = validateEmail()
        return isPasswordValid == null && isEmailValid == null
    }

    //функция принимающая результат валидации поля Password (пустое либо нет)
    private fun validatePassword(): String? {
        val passwordInputLayout = binding.passwordContainer
        passwordInputLayout.editText?.let {
            val result = validatePasswords(it.text.toString())
            return when (result) {
                is Invalid -> {
                    passwordInputLayout.error = this.getString(result.textError)
                    this.getString(result.textError)
                }
                else -> {
                    passwordInputLayout.error = null
                    null
                }
            }
        } ?: return null
    }

    //функция принимающая результат валидации поля Email (пустое либо нет)
    private fun validateEmail(): String? {
        val emailInputLayout = binding.emailContainer
        emailInputLayout.editText?.let {
            val result = validateEmails(it.text.toString())
            return when (result) {
                is Invalid -> {
                    emailInputLayout.error = this.getString(result.textError)
                    this.getString(result.textError)
                }
                else -> {
                    emailInputLayout.error = null
                    null
                }
            }
        } ?: return null
    }

    fun onLogIn() {
        val sharedPreferencesRepository = SharePreferencesRepository(requireContext())
        if (validate() && sharedPreferencesRepository.getUserEmail() != null) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, TaskFragment())
                .addToBackStack("")
                .commit()
        } else if (!(sharedPreferencesRepository.getUserEmail()
                .equals(binding.emailEditText.text.toString()))
        ) {
            Toast.makeText(requireContext(), R.string.user_no_registration, Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun onClickReturnSignUp() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, SignUpFragment())
            .addToBackStack("")
            .commit()
    }
}

