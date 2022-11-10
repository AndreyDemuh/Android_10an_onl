package com.example.firstapp.ui.registration


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.firstapp.*
import com.example.firstapp.dataBase.TaskDataBase
import com.example.firstapp.databinding.FragmentSignUpBinding
import com.example.firstapp.model.User
import com.example.firstapp.repositories.SharePreferencesRepository
import com.example.firstapp.ui.fragments.TaskFragment


class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReturnLogin.setOnClickListener { onClickLogIn() }
        binding.btnSignUp.setOnClickListener { onSignUp() }
    }

    //функция проверяющая результат валидации полей Name, Lastname, Email и Password
    private fun validate(): Boolean {
        val isPasswordValid = validatePassword()
        val isEmailValid = validateEmail()
        val isNameValid = validateName()
        val isLastnameValid = validateLastname()
        return isPasswordValid == null && isEmailValid == null &&
                isNameValid == null && isLastnameValid == null
    }

    //функция принимающая результат валидации поля name (пустое либо нет)
    private fun validateName(): String? {
        val nameInputLayout = binding.firstNameContainer
        nameInputLayout.editText?.let {
            val result = validateNames(it.text.toString())
            return when (result) {
                is Invalid -> {
                    nameInputLayout.error = this.getString(result.textError)
                    this.getString(result.textError)
                }
                else -> {
                    nameInputLayout.error = null
                    null
                }
            }
        } ?: return null
    }

    //функция принимающая результат валидации поля lastname (пустое либо нет)
    private fun validateLastname(): String? {
        val lastnameInputLayout = binding.lastNameSignUpContainer
        lastnameInputLayout.editText?.let {
            val result = validateLastNames(it.text.toString())
            return when (result) {
                is Invalid -> {
                    lastnameInputLayout.error = this.getString(result.textError)
                    this.getString(result.textError)
                }
                else -> {
                    lastnameInputLayout.error = null
                    null
                }
            }
        } ?: return null
    }

    //функция принимающая результат валидации поля password (пустое либо нет)
    private fun validatePassword(): String? {
        val passwordInputLayout = binding.passwordSignUpContainer
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

    //функция принимающая результат валидации поля email (пустое либо нет)
    private fun validateEmail(): String? {
        val emailInputLayout = binding.emailSignUpContainer
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

    fun onSignUp() {
        val sharedPreferencesRepository = SharePreferencesRepository(requireContext())
        if (validate()) {
            if (sharedPreferencesRepository.getUserEmail() == null || ((sharedPreferencesRepository.getUserEmail() != null) &&
                        (!(sharedPreferencesRepository.getUserEmail()
                            .equals(binding.emailSignUpEditText.text.toString()))))
            ) {
                TaskDataBase.db.userDao().addUser(
                    User(binding.emailSignUpEditText.text.toString())
                )
                sharedPreferencesRepository.setUserName(binding.firstNameEditText.text.toString())
                sharedPreferencesRepository.setUserEmail(binding.emailSignUpEditText.text.toString())
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, TaskFragment())
                    .addToBackStack("")
                    .commit()
            } else if (sharedPreferencesRepository.getUserEmail()
                    .equals(binding.emailSignUpEditText.text.toString()) && sharedPreferencesRepository.getUserEmail() != null
            ) {
                Toast.makeText(
                    requireContext(),
                    R.string.app_have_this_user,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun onClickLogIn() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, LogInFragment())
            .addToBackStack("")
            .commit()
    }
}
