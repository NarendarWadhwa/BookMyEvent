package com.example.bookmyevent.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, V : ViewDataBinding>(private val context: Context) :
    RecyclerView.Adapter<BaseViewHolder<V>>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(context)
    private val items = mutableListOf<T>()

    fun updateData(_listItems: MutableList<T>) {
        items.clear()
        items.addAll(_listItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<V> {
        return BaseViewHolder<V>(DataBindingUtil.inflate(mInflater, getLayoutId(), parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<V>, position: Int) {
        onBindView(holder.binding, items[position], position)
    }

    override fun getItemCount() = items.size

    abstract fun getLayoutId(): Int
    abstract fun onBindView(binding: V, item: T, position: Int)
}