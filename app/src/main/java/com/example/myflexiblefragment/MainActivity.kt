package com.example.myflexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//   Memasang Fragment pada Activity
        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            Log.d("myFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)
                mFragmentManager
//               Untuk memulai proses perubahan
                .beginTransaction()
//               manambahkan objek fragment ke dalam layout container
                .add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName)
//               akan mengeksekusi untuk melakukan pemasangan objek secara asynchronous untuk ditampilkan ke antar muka pengguna(user interface)
                .commit()
        }
    }
}
