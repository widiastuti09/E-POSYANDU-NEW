package com.example.e_posyandu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.e_posyandu.databinding.ActivityMainBinding
import com.example.e_posyandu.fragment.*
import com.example.e_posyandu.utilities.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCurrentFragment(CatatanAnakFragment())
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

    private fun logout(){
        Constants.clearToken(this@MainActivity)
        Constants.clearName(this)
        Constants.clearEmail(this)
        Constants.clearIdUser(this)
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
}