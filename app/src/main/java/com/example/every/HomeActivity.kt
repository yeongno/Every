package com.example.every

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.every.article.ArticleFragment
import com.example.every.home.HomeFragment
import com.example.every.mypage.MypageFragment
import com.example.every.schedule.ScheduleFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //main
        val homeFragment = HomeFragment()
        val scheduleFragment = ScheduleFragment()
        val articleFragment = ArticleFragment()
        val scheduleFragement = ScheduleFragment()
        val mypageFragment = MypageFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        replaceFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(homeFragment)
                R.id.schedule -> replaceFragment(scheduleFragment)
                R.id.article -> replaceFragment(articleFragment)
                R.id.schedule -> replaceFragment(scheduleFragement)
                R.id.myPage -> replaceFragment(mypageFragment)

            }
            return@setOnNavigationItemReselectedListener
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }
}