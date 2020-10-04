package com.example.bookmyevent.events

import androidx.lifecycle.Observer
import com.example.bookmyevent.R
import com.example.bookmyevent.base.BaseActivity
import com.example.bookmyevent.databinding.ActivityEventsBinding
import com.example.bookmyevent.utils.showToast

class EventsActivity : BaseActivity<ActivityEventsBinding, EventsViewModel>() {
    override fun getLayoutId() = R.layout.activity_events
    override fun getViewModel() = EventsViewModel::class.java

    override fun onBinding() {
        mViewModel.errorLiveData.observe(this@EventsActivity, Observer {
            showToast(it)
        })
        mViewModel.getEventsData().observe(this@EventsActivity, Observer {
            val eventsAdapter = EventsPagerAdapter(supportFragmentManager, it.groups, it)
            mBinding.viewpager.adapter = eventsAdapter
            mBinding.tabs.setupWithViewPager(mBinding.viewpager)
        })
        mViewModel.getEvents()
    }

}