package com.mubarak.tmdb.ui.screens.people.details

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.R
import com.mubarak.tmdb.data.network.Constant
import com.mubarak.tmdb.ui.screens.dashboard.movies.main.components.MovieCard
import com.mubarak.tmdb.ui.screens.people.component.AlsoKnownAsItem
import com.mubarak.tmdb.ui.screens.people.component.PeopleImages
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.skydoves.landscapist.coil.CoilImage

@Destination
@Composable
fun PeopleDetailsScreen(
    personId: Int,
    navigator: DestinationsNavigator,
    viewModel: PeopleDetailsViewModel = hiltViewModel()
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val imagesState by viewModel.imagesViewState.collectAsStateWithLifecycle()
    val peopleMovieCreditsViewState by viewModel.peopleMovieCreditsViewState.collectAsStateWithLifecycle()
    val peopleSocialMediaViewState by viewModel.peopleSocialMediaViewState.collectAsStateWithLifecycle()

    val imageUrl = Constant.BASE_POSTER_URL + state?.data?.profilePath
    var showMore by remember { mutableStateOf(false) }

    LaunchedEffect(null) {
        viewModel.getPersonDetails(personId = personId)
    }
    LaunchedEffect(null) {
        viewModel.getPersonImages(personId = personId)
    }
    LaunchedEffect(null) {
        Log.e("working", "PeopleDetailsScreen: ")
        viewModel.getPersonMovieCredits(personId = personId)
    }
    LaunchedEffect(null) {
        Log.e("working", "PeopleDetailsScreen: ")
        viewModel.getPersonSocialMedia(personId = personId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
       // DetailsTopBar(itemId = personId, title = title, navigator)

        Row(modifier = Modifier.fillMaxWidth()) {

            CoilImage(
                imageModel = { imageUrl },
                previewPlaceholder = R.drawable.full_logo,
                modifier = Modifier
                    .height(300.dp)
                    .width(200.dp)
                    .padding(start = 16.dp, top = 16.dp),
                // shows an indicator while loading an image.
                loading = {
                    Box(modifier = Modifier.matchParentSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
            )
            Column {

                Text(text = "Also Known As:", modifier = Modifier.padding(top = 8.dp))
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), content = {
                    items(state?.data?.alsoKnownAs ?: emptyList()) { item ->
                        AlsoKnownAsItem(knownAs = item)
                    }
                })
            }
        }

        PeopleSocialMedia(peopleSocialMediaViewState)

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier
                    .animateContentSize(animationSpec = tween(100))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { showMore = !showMore }) {
                    if (showMore) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            text = state?.data?.biography ?: ""
                        )
                    } else {
                        Text(
                            text = state?.data?.biography ?: "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            maxLines = 5,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }


        MovieCreditsLazyRow(peopleMovieCreditsViewState, navigator)
        PersonImagesLazyRow(imagesState)

    }
}

@Composable
fun PeopleSocialMedia(peopleSocialMediaViewState: PeopleSocialMediaViewState?) {
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            if (!peopleSocialMediaViewState?.data?.imdbId.isNullOrEmpty()) {

                Image(
                    painter = painterResource(id = R.drawable.ic_imdb),
                    contentDescription = "imdb",
                    modifier = Modifier
                        .clickable {
                            uriHandler.openUri("https://www.imdb.com/name/" + peopleSocialMediaViewState?.data?.imdbId)
                        }
                        .padding(8.dp)
                )
            }


            if (!peopleSocialMediaViewState?.data?.instagramId.isNullOrEmpty()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "imdb",
                    modifier = Modifier
                        .clickable {
                            uriHandler.openUri("https://www.instagram.com/" + peopleSocialMediaViewState?.data?.instagramId)
                        }
                        .padding(8.dp)
                        .height(28.dp)
                        .width(54.dp)
                )
            }

            if (!peopleSocialMediaViewState?.data?.tiktokId.isNullOrEmpty()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_tiktok),
                    contentDescription = "imdb",
                    modifier = Modifier
                        .clickable {
                            uriHandler.openUri("https://www.tiktok.com/@" + peopleSocialMediaViewState?.data?.tiktokId)
                        }
                        .padding(8.dp)
                        .height(28.dp)
                        .width(54.dp)
                )
            }
            if (!peopleSocialMediaViewState?.data?.twitterId.isNullOrEmpty()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_twitter_x),
                    contentDescription = "imdb",
                    modifier = Modifier
                        .clickable {
                            uriHandler.openUri("https://twitter.com/" + peopleSocialMediaViewState?.data?.twitterId)
                        }
                        .padding(8.dp)
                        .height(28.dp)
                        .width(54.dp)
                )
            }
            if (!peopleSocialMediaViewState?.data?.youtubeId.isNullOrEmpty()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_youtube),
                    contentDescription = "imdb",
                    modifier = Modifier
                        .clickable {
                            uriHandler.openUri("https://www.youtube.com/user/" + peopleSocialMediaViewState?.data?.youtubeId)
                        }
                        .padding(8.dp)
                        .height(28.dp)
                        .width(54.dp)
                )
            }

        }
    }
}

@Composable
private fun PersonImagesLazyRow(imagesState: PeopleImagesViewState?) {
    LazyRow(content = {
        items(imagesState?.data.orEmpty()) { item ->
            PeopleImages(item?.filePath)
        }
    })
}

@Composable
private fun MovieCreditsLazyRow(
    peopleMovieCreditsViewState: PeopleMovieCreditsViewState?,
    navigator: DestinationsNavigator
) {
    LazyRow(content = {
        items(peopleMovieCreditsViewState?.data.orEmpty()) { item ->
            MovieCard(
                item.title ?: item.originalTitle ?: "-",
                item.posterPath,
                modifier = Modifier.clickable {
//                    navigator.navigate(
//                        DetailsScreenDestination(
//                            movieItem = item
//                        )
//                     )
                })
        }
    })
}