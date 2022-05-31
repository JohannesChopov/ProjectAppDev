package com.example.mobilevax.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobilevax.R
import com.example.mobilevax.databinding.ActivityHomeBinding
import com.example.mobilevax.fragments.secondActivity.AddVaccineFragment
import com.example.mobilevax.fragments.secondActivity.HostListOrInfoFragment
import com.example.mobilevax.fragments.secondActivity.LogoutFragment

class HomeActivity : AppCompatActivity(){

    private lateinit var binding: ActivityHomeBinding
    private lateinit var menuBarToggle: ActionBarDrawerToggle
    private val hostListOrInfoFragment = HostListOrInfoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        setupFragmentHost()
        setupMenuDrawer()

        setContentView(binding.root)
        println("WelcomeActivity--onCreate")
    }

    private fun setupFragmentHost() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, hostListOrInfoFragment)
            commit()
        }
    }

    private fun setupMenuDrawer() {
        menuBarToggle = ActionBarDrawerToggle(this, binding.drawerLayout,
            R.string.menu_open,
            R.string.menu_close
        )
        binding.drawerLayout.addDrawerListener(menuBarToggle)
        menuBarToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //in de navHeader van de menu drawer displayen we de email van de user
        val email = intent.getStringExtra("userEmail")
        val header = binding.navView.getHeaderView(0)
        header.findViewById<TextView>(R.id.txtUserEmail).text = email

        binding.navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when (it.itemId) {
                R.id.goToLogout -> swapFragment(LogoutFragment())
                R.id.goToVaccines -> swapFragment(HostListOrInfoFragment())
                R.id.addToVaccines -> swapFragment(AddVaccineFragment())
            }
            true
        }
    }

    private fun swapFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout, fragment).addToBackStack(null)
        fragmentTransaction.commit()

        binding.drawerLayout.closeDrawers()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // we need to do this to respond correctly to clicks on menu items, otherwise it won't be caught
        if(menuBarToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        println("WelcomeActivity--onStart")
    }

    override fun onResume() {
        super.onResume()
        println("WelcomeActivity--onResume")
    }

    override fun onPause() {
        super.onPause()
        println("WelcomeActivity--onPause")
    }

    override fun onStop() {
        super.onStop()
        println("WelcomeActivity--onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("WelcomeActivity--onDestroy")
    }
}