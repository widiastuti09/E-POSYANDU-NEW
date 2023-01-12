package com.example.e_posyandu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.e_posyandu.databinding.ActivityMainBinding
import com.example.e_posyandu.fragment.*
import com.example.e_posyandu.utilities.Constants
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout,R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        checkIsLoggedIn()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_anak -> {
                    setCurrentFragment(CatatanAnakFragment())
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_bumil -> {
                    setCurrentFragment(CatatanBumilFragment())
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_lansia -> {
                    setCurrentFragment(CatatanLansiaFragment())
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_about -> {
                    setCurrentFragment(TentangAplikasiFragment())
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_account -> {
                    setCurrentFragment(AkunFragment())
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_logout -> logout()
            }
            true
        }
    }

    private fun checkRole(){
        binding.navigationView.menu.findItem(R.id.nav_anak).isVisible = true
        binding.navigationView.menu.findItem(R.id.nav_bumil).isVisible = true
        binding.navigationView.menu.findItem(R.id.nav_lansia).isVisible = true
        if(Constants.getRole(this) == "ibuhamil"){
            navRoleIbuHamil()
            setCurrentFragment(CatatanBumilFragment())
        }else{
            navRoleLansia()
            setCurrentFragment(CatatanLansiaFragment())
        }
    }

    private fun navRoleIbuHamil(){
        binding.navigationView.menu.findItem(R.id.nav_anak).isVisible = true
        binding.navigationView.menu.findItem(R.id.nav_bumil).isVisible = true
        binding.navigationView.menu.findItem(R.id.nav_lansia).isVisible = false
    }

    private fun navRoleLansia(){
        binding.navigationView.menu.findItem(R.id.nav_anak).isVisible = false
        binding.navigationView.menu.findItem(R.id.nav_bumil).isVisible = false
        binding.navigationView.menu.findItem(R.id.nav_lansia).isVisible = true
    }

    private fun logout(){
        Constants.clearToken(this@MainActivity)
        Constants.clearName(this)
        Constants.clearEmail(this)
        Constants.clearIdUser(this)
        Constants.clearRole(this)
        checkIsLoggedIn()
    }

    private fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.Container, fragment).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun checkIsLoggedIn(){
        val token = Constants.getToken(this@MainActivity)
        if(token.equals("UNDEFINED")){
            startActivity(Intent(this@MainActivity, LoginActivity::class.java).also { finish() })
        }
    }

    override fun onResume() {
        super.onResume()
        checkRole()
    }
}