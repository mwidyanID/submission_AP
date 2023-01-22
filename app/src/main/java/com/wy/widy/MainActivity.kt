package com.wy.widy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wy.widy.activity.AboutActivity
import com.wy.widy.adapter.ListCharAdapter
import com.wy.widy.db.CharData
import com.wy.widy.model.GenshinChar

class MainActivity : AppCompatActivity() {
    private lateinit var rvChar: RecyclerView
    private var list: ArrayList<GenshinChar> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title = "DAFTAR KARTUN"

        rvChar = findViewById(R.id.rv_char)
        rvChar.setHasFixedSize(true)

        list.addAll(CharData.listData)
        rvChar.layoutManager = LinearLayoutManager(this)
        val listCharAdapter = ListCharAdapter(list)
        rvChar.adapter = listCharAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about -> {
                val goAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(goAbout)
            }
        }
    }
}