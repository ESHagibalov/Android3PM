package com.example.glomadovbottomnavigation.models.event

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
object EventDataObject {
    private var eventsList = mutableListOf<Event>(
        Event("1 сентября", "Торжественная линейка", LocalDate.of(2021, 9, 1)),
        Event("Смотрины", "Выступление первокурсников 1го сентября", LocalDate.of(2021, 9, 1)),
        Event("Отличное начало", "Общеуниверский ивент", LocalDate.of(2021, 9, 7)),
        Event("Балткоса", "Посвят", LocalDate.of(2021, 9, 18)),
        Event("День первокурсника", "Выступление первокурсников", LocalDate.of(2021, 10, 15)),
        Event("Зимняя сессия", "Игра началась", LocalDate.of(2021, 12, 14)),
        Event("День физмата", "Главный праздник в году", LocalDate.of(2022, 4, 26)),
        Event(
            "Первый день лета",
            "Первый день любимого времени годаБ скоро каникулы!!!",
            LocalDate.of(2022, 6, 1)
        ),
        Event("Летняя сессия", "Задача: остаться на степухе", LocalDate.of(2022, 6, 3)),
    )

    fun getEvents() = eventsList
    fun addEvent(event: Event) {
        eventsList.add(event)
       sortEvents()
    }

    private fun sortEvents() {
        eventsList.sortWith(Comparator { x: Event, y: Event ->
            x.dateStart.compareTo(
                y.dateStart
            )
        })//сортировать тут - не лучшее решение с точки зрения архитектуры, полага, но в viewModel пока не получилось
    }
}