package com.example.bookmyevent.events

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.bookmyevent.network.model.EventsResponse

class EventsPagerAdapter(
    private val fm: FragmentManager, private val pages: ArrayList<String>,
    private val eventsResponse: EventsResponse
) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return EventsFragment.newInstance(pages[position], eventsResponse)
    }

    override fun getPageTitle(position: Int) = pages[position]
    override fun getCount() = pages.size

}