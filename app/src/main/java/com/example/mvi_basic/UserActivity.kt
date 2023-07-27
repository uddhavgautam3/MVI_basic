package com.example.mvi_basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.mvi_basic.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            showUserFragment()
        }
    }

    private fun showUserFragment() {
        supportFragmentManager.commit {
            replace(R.id.container, UsersFragment.newInstance())
        }
    }
}