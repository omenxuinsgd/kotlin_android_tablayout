package com.example.kotlinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.kotlinandroid.project10_webview.Project10Activity
import com.example.kotlinandroid.project11_seekbar.Project11Activity
import com.example.kotlinandroid.project12_tablayout.P12FramelayoutActivity
import com.example.kotlinandroid.project12_tablayout.P12ViewpagerActivity
import com.example.kotlinandroid.project13_xmlparsing.P13DomparsingActivity
import com.example.kotlinandroid.project13_xmlparsing.P13SaxpraserActivity
import com.example.kotlinandroid.project13_xmlparsing.XmlPullParserHandler
import com.example.kotlinandroid.project15_mediaplayer.Project15Activity
import com.example.kotlinandroid.project16_videoplayer.Project16Activity
import com.example.kotlinandroid.project18_SQLite.Project18Activity
import com.example.kotlinandroid.project19_notification.Project19Activity
import com.example.kotlinandroid.project22_admop.P22BanneradsActivity
import com.example.kotlinandroid.project5_listview.Project5CustomActivity
import com.example.kotlinandroid.project5_listview.Project5ListviewActivity
import com.example.kotlinandroid.project6_alertdialog.Project6Activity
import com.example.kotlinandroid.project7_contextmenu.Project7Activity
import com.example.kotlinandroid.project8_optionmenu.Project8Activity
//import android.net.Uri
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(){
//            intent = Intent(Intent.ACTION_VIEW)
//            intent.setData(Uri.parse("https://www.javatpoint.com/"))
//            startActivity(intent)
            /*  intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/"))
            startActivity(intent)*/
            startActivity(Intent(this@MainActivity, P22BanneradsActivity::class.java))
        }

        // source: http://www.madtutorial.com/2020/03/tutorial-create-android-fragment-with.html
//        supportFragmentManager!!.
//        beginTransaction().
//        add(R.id.fragmentContainer, Project2Customtoast(),"FragmentOne").commit()

        //startActivity(Intent(this@MainActivity, FirstActivityImplicit::class.java))
    }
}