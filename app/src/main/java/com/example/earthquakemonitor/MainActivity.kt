package com.example.earthquakemonitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earthquakemonitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eqRecycler.layoutManager = LinearLayoutManager(this)
        val eqList = mutableListOf<Earthquake>()
        eqList.add(Earthquake("1", "Mexico", 4.3,121542154, -12512.2, 15125.0 ))
        eqList.add(Earthquake("2", "Querertaro", 4.2,121542, -154.2, 12750.0 ))
        eqList.add(Earthquake("3", "Puebla", 4.1,12154221552, -1547.2, 1279451.0 ))
        eqList.add(Earthquake("4", "Colima", 4.4,12154215221, -1545.2, 1271422.0 ))
        eqList.add(Earthquake("5", "Tlaxcal", 4.5,1215421552, -1544.2, 12715214.0 ))

        val adapter = EqAdapter()
        binding.eqRecycler.adapter = adapter
        adapter.submitList(eqList)

        adapter.onItemClickListener = {
            Toast.makeText(this, it.place, Toast.LENGTH_LONG).show()
        }

        if (eqList.isEmpty()) {
            binding.eqEmptyView.visibility = View.VISIBLE
        } else {
            binding.eqEmptyView.visibility = View.GONE
        }

    }
}