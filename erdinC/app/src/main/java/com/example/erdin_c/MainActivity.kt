package com.example.erdin_c

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.example.erdin_c.Fragments.ListFragment
import com.example.erdin_c.databinding.ActivityMainBinding

private lateinit var mainBinding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val listFragment = ListFragment.newInstance("I dont need this now","Erdinc dont need this one too")
        startFragment(listFragment)
        setContentView(mainBinding.root)
    }


    fun startFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainActivityFragmentContainer, fragment, "tagg")
        transaction.addToBackStack("tagg")
        transaction.commitAllowingStateLoss()
    }

}

