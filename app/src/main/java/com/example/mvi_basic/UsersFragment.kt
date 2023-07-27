package com.example.mvi_basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mvi_basic.databinding.FragmentUserBinding

class UsersFragment : Fragment() {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private lateinit var viewModel: UsersViewModel
    private lateinit var _binding: FragmentUserBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[UsersViewModel::class.java]

        observeUserModel()
        setButtonClick()

        return binding.root
    }

    private fun observeUserModel() {
        viewModel.state.observe(viewLifecycleOwner) { usersModel: UsersModel ->
            binding.userIdTv.text = StringFormatter.formatUserList(usersModel.users)
        }
    }

    private fun setButtonClick() {
        binding.getAllUserButton.setOnClickListener {
            viewModel.handleIntent(UsersIntent.LoadUsers)
        }

        binding.getUserByIdButton.setOnClickListener {
            val userId: Int = Integer.parseInt(binding.userIdField.text.toString())
            viewModel.handleIntent(UsersIntent.LoadUser(userId))
        }

    }

}

