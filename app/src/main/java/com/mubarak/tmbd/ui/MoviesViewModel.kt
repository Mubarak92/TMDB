package com.mubarak.tmbd.ui

import androidx.lifecycle.ViewModel
import com.mubarak.tmbd.data.domain.model.MovieModel
import com.mubarak.tmbd.data.domain.repository.IMovieRepository
import com.mubarak.tmbd.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMovies: IMovieRepository): ViewModel() {

       private val _viewState = MutableStateFlow<ViewState<List<MovieModel>>>(ViewState.loading())
       val viewState = _viewState.asStateFlow()


       init {
              getMovies.getMovies(1)
       }

       private fun getMovies(){
              _viewState.value
       }

}