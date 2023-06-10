package com.example.networkme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.ui.setupWithNavController

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment

import com.example.networkme.databinding.ActivityMain2Binding

//Aplikasi dikerjakan dalam kurun waktu 05-06-2023 sampai 10-06-2023
//3 hari membuat layouting tampilan
//2 hari membuat fungsi fungsi
//Nim   : 10120765
//Nama  : Dendi Rizal Fauzi
//Kelas : IF-9
class MainActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        navigationController()
    }

    private fun navigationController(){
        binding.apply {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val  navController = navHostFragment.navController
            navController.addOnDestinationChangedListener{_,destination,_ ->
                if ((destination.id == R.id.splashScreen) || (destination.id == R.id.viewPager2)){
                    binding.navMenu.visibility = View.GONE
                }else{
                    binding.navMenu.visibility = View.VISIBLE
                }
            }
            navMenu.setupWithNavController(navController)

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.homePage ->{
                homePage()
                true
            }
            R.id.dailyAct ->{
                dailyAct()
                true
            }
            R.id.gallery2 ->{
                gallery()
                true
            }
            R.id.music ->{
                music()
                true
            }
            R.id.profile2 ->{
                profile()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}