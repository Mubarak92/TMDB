package com.mubarak.tmdb.ui.screens.discover

import androidx.lifecycle.ViewModel
import com.mubarak.tmdb.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor() : ViewModel() {

    data class ScrollableTabs(val name: Int, val id: Int)

    val list = listOf(
        (ScrollableTabs(name = R.string.action, 28)),
        (ScrollableTabs(name = R.string.adventure, 12)),
        (ScrollableTabs(name = R.string.animation, 16)),
        (ScrollableTabs(name = R.string.comedy, 35)),
        (ScrollableTabs(name = R.string.crime, 80)),
        (ScrollableTabs(name = R.string.documentary, 99)),
        (ScrollableTabs(name = R.string.drama, 18)),
        (ScrollableTabs(name = R.string.family, 10751)),
        (ScrollableTabs(name = R.string.fantasy, 14)),
        (ScrollableTabs(name = R.string.history, 36)),
        (ScrollableTabs(name = R.string.horror, 27)),
        (ScrollableTabs(name = R.string.music, 10402)),
        (ScrollableTabs(name = R.string.mystery, 9648)),
        (ScrollableTabs(name = R.string.romance, 10749)),
        (ScrollableTabs(name = R.string.science_fiction, 878)),
        (ScrollableTabs(name = R.string.thriller, 53)),
        (ScrollableTabs(name = R.string.war, 37)),
    )
}