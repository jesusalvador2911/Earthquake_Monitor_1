package com.example.earthquakemonitor

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.earthquakemonitor.databinding.EqListItemBinding
import kotlin.math.log
private val  TAG = EqAdapter::class.java.simpleName
class EqAdapter : ListAdapter<Earthquake, EqAdapter.EqViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Earthquake>() {
        override fun areItemsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqAdapter.EqViewHolder {
        val binding = EqListItemBinding.inflate(LayoutInflater.from(parent.context))

        return EqViewHolder(binding)
    }
    lateinit var onItemClickListener: (Earthquake) -> Unit

    override fun onBindViewHolder(holder: EqAdapter.EqViewHolder, position: Int) {
        val earthquake = getItem(position)
        holder.bind(earthquake)

    }
    inner class EqViewHolder(private val binding: EqListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(earthquake: Earthquake){
            binding.eqMagnitudeText.text = earthquake.magnitude.toString()
            binding.eqPlaceText.text = earthquake.place
            binding.root.setOnClickListener{
                if (::onItemClickListener.isInitialized){
                    onItemClickListener(earthquake)
                } else {
                    Log.e("TAG", "onItemClickListener no iciciada")
                }

            }

        }
    }
}