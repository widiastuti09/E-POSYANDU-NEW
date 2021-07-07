package com.example.e_posyandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.e_posyandu.databinding.ActivityMainBinding
import com.example.e_posyandu.fragment.CatatanAnakFragment
import com.example.e_posyandu.fragment.CatatanBumilFragment
import com.example.e_posyandu.fragment.CatatanLansiaFragment

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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home ->Toast.makeText(this, "You Click home item",Toast.LENGTH_SHORT).show()
                R.id.nav_anak ->setCurrentFragment(CatatanAnakFragment())
                R.id.nav_bumil ->setCurrentFragment(CatatanBumilFragment())
                R.id.nav_lansia ->setCurrentFragment(CatatanLansiaFragment())
                R.id.nav_logout ->Toast.makeText(this, "You Click logout item",Toast.LENGTH_SHORT).show()


            }
            true
        }
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
}