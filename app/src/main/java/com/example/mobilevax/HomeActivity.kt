package com.example.mobilevax

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobilevax.databinding.ActivityHomeBinding
import com.example.mobilevax.fragments.AddVaccineFragment
import com.example.mobilevax.fragments.TestFragment
import com.example.mobilevax.fragments.VaccineListFragment

class HomeActivity : AppCompatActivity(){

    private lateinit var binding: ActivityHomeBinding
    private lateinit var menuBarToggle: ActionBarDrawerToggle
    private var vaccinelistFragment = VaccineListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        setupVaccineListFragment()
        setupMenuDrawer()

        setContentView(binding.root)
        println("WelcomeActivity--onCreate")
    }

    private fun setupVaccineListFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, vaccinelistFragment)
            commit()
        }
    }

    private fun setupMenuDrawer() {
        menuBarToggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.menu_open, R.string.menu_close)
        binding.drawerLayout.addDrawerListener(menuBarToggle)
        // it's now ready to be used
        menuBarToggle.syncState()

        // when the menu drawer opens, the toggle button moves to a "back" button and it will close again.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // handle menu drawer item clicks.
        // since these are all events that influence the fragment list, delegate their actions!
        binding.navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when (it.itemId) {
                R.id.goToLogout -> swapFragment(TestFragment())
                R.id.goToVaccines -> swapFragment(VaccineListFragment())
                R.id.addToVaccines -> swapFragment(AddVaccineFragment())
            }
            true
        }
    }

    private fun swapFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment).addToBackStack("fragment")

        fragmentTransaction.commit()

        binding.drawerLayout.closeDrawers()
    }
    /*
    fun hideKeyboard(view: View) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
     */

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