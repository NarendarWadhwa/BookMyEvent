package com.example.bookmyevent.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookmyevent.R
import com.example.bookmyevent.base.BaseAdapter
import com.example.bookmyevent.databinding.FragmentEventsBinding
import com.example.bookmyevent.databinding.ItemEventBinding
import com.example.bookmyevent.network.model.EventsResponse
import com.example.bookmyevent.network.model.Featured
import com.example.bookmyevent.utils.EVENT_DETAILS
import com.example.bookmyevent.utils.EVENT_NAME

class EventsFragment : Fragment() {

    companion object {
        fun newInstance(eventName: String, eventsResponse: EventsResponse): EventsFragment {
            return EventsFragment().apply {
                arguments = Bundle().apply {
                    putString(EVENT_NAME, eventName)
                    putParcelable(EVENT_DETAILS, eventsResponse)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_events,
            container,
            false
        ) as FragmentEventsBinding

        val eventsList = mutableListOf<Featured>()

        arguments?.run {
            val eventName = getString(EVENT_NAME, "")
            val eventModel = getParcelable<EventsResponse>(EVENT_DETAILS)

            if (eventName.isNotEmpty()) {
                eventModel?.let { it ->
                    it.lists?.masterList?.forEach {
                        if (it.groupId.name == eventName) {
                            eventsList.add(it)
                        }
                    }
                }
            }

        }

        val eventAdapter =
            object : BaseAdapter<Featured, ItemEventBinding>(activity as EventsActivity) {
                override fun getLayoutId() = R.layout.item_event
                override fun onBindView(binding: ItemEventBinding, item: Featured, position: Int) {
                    binding.eventModel = item
                }
            }

        binding.rvEvents.run {
            layoutManager = LinearLayoutManager(activity)
            itemAnimator = DefaultItemAnimator()
            adapter = eventAdapter
        }
        eventAdapter.updateData(eventsList)

        return binding.root
    }

}