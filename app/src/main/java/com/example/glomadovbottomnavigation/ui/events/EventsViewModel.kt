package com.example.glomadovbottomnavigation.ui.events

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.glomadovbottomnavigation.models.event.Event
import com.example.glomadovbottomnavigation.models.event.EventDataObject

@RequiresApi(Build.VERSION_CODES.O)
class EventsViewModel : ViewModel() {
    private val mutableEventsList: MutableLiveData<List<Event>> = MutableLiveData()
    val eventsList: LiveData<List<Event>> = mutableEventsList
    init {
        mutableEventsList.value = EventDataObject.getEvents()

    }

}