package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var menu: Menu = bottomView.menu
        selectedMenu(menu.getItem(0))
        bottomView.setOnNavigationItemReselectedListener { item: MenuItem ->
            selectedMenu(item)

            false
        }
    }

    private fun selectedMenu(item: MenuItem) {
        item.isChecked = true
        when (item.itemId) {
            R.id.navHome -> selectedFragment(HomeFragment.getInstance())
            R.id.navTable -> selectedFragment(TableFragment.getInstance())
            R.id.navProfil -> selectedFragment(ProfilFragment.getInstance())

        }
    }

    private fun selectedFragment(fragment: Fragment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var transaction : FragmentTransaction? = supportFragmentManager.beginTransaction()
        transaction?.replace(R.id.rootFragment, fragment)
        transaction?.commit()
    }
}