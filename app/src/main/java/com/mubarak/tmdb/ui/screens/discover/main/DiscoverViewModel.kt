package com.mubarak.tmdb.ui.screens.discover.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor() : ViewModel() {}
data class DiscoverListItems(val name: String, val id: Int)