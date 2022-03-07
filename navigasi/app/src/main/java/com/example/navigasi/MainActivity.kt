package com.example.navigasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.navigasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navCtrl = this.findNavController(R.id.navhost_fragment)
        //drawerLayout = binding.drawerL
        //NavigationUI.setupActionBarWithNavController(this, navCtrl, drawerLayout)
        //NavigationUI.setupWithNavController(binding.navView, navCtrl)
        NavigationUI.setupActionBarWithNavController(this, navCtrl)
        NavigationUI.setupWithNavController(binding.navBottom, navCtrl)
        //return binding.root
    }

    override fun onSupportNavigateUp(): Boolean {
//        navCtrl.navigateUp()
//        return super.onSupportNavigateUp()
        val navCtrl = this.findNavController(R.id.navhost_fragment)
        //return NavigationUI.navigateUp(navCtrl, drawerLayout) || navCtrl.navigateUp()
        return navCtrl.navigateUp()
    }
}
