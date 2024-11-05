package com.example.menuevent

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set toolbar as the ActionBar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Register TextView for context menu
        val textView = findViewById<TextView>(R.id.textView)
        registerForContextMenu(textView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_cari -> {
                Toast.makeText(this, "Cari dipilih", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_pengaturan -> {
                Toast.makeText(this, "Pengaturan dipilih", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_profil -> {
                Toast.makeText(this, "Profil dipilih", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_privasi -> {
                Toast.makeText(this, "Privasi dipilih", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_notifikasi -> {
                Toast.makeText(this, "Notifikasi dipilih", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        val pengaturanGroup = menu.findItem(R.id.group_pengaturan)
        // Contoh kondisi, bisa disesuaikan
        val isUserLoggedIn = true
        pengaturanGroup.isVisible = isUserLoggedIn
        return super.onPrepareOptionsMenu(menu)
    }


    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.context_edit -> {
                Toast.makeText(this, "Edit dipilih", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.context_hapus -> {
                Toast.makeText(this, "Hapus dipilih", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }


}