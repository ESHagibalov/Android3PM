package com.example.glomadovbottomnavigation.ui.events

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.glomadovbottomnavigation.models.event.Event
import com.example.glomadovbottomnavigation.models.event.EventDataObject
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class EventsViewModel : ViewModel() {
    private val eventsList: MutableLiveData<List<Event>> = MutableLiveData()

    init {
        eventsList.value = EventDataObject.getEvents()
    }

    fun getEventList() = eventsList

}