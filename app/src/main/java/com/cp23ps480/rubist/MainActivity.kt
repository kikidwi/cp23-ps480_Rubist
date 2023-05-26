package com.cp23ps480.rubist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.cp23ps480.rubist.Fragment.AddPost
import com.cp23ps480.rubist.Fragment.Community
import com.cp23ps480.rubist.Fragment.Home
import com.cp23ps480.rubist.Fragment.Profile
import com.cp23ps480.rubist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        binding.BottomNavView.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.community -> replaceFragment(Community())
                R.id.add -> replaceFragment(AddPost())
                R.id.profile-> replaceFragment(Profile())
                else -> {}
            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
    }
}