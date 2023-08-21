package com.mubarak.tmdb.ui.screens.people.details

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.R
import com.mubarak.tmdb.data.network.Constant
import com.mubarak.tmdb.ui.screens.dashboard.details.components.DetailsTopBar
import com.mubarak.tmdb.ui.screens.people.component.AlsoKnownAsItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.skydoves.landscapist.coil.CoilImage

@Destination
@Composable
fun PeopleDetailsScreen(
    personId: Int,
    title: String,
    navigator: DestinationsNavigator,
    viewModel: PeopleDetailsViewModel = hiltViewModel()
//    list: List<String> = listOf("ABC", "123", "xyz")
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val imageUrl = Constant.BASE_POSTER_URL + state?.data?.profilePath
    var showMore by remember { mutableStateOf(false) }

    LaunchedEffect(null) {
        viewModel.getPersonDetails(personId = personId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        DetailsTopBar(itemId = personId ,title = title, navigator)

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

            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp), content = {
                items(state?.data?.alsoKnownAs ?: emptyList()) { item ->
                    AlsoKnownAsItem(knownAs = item)
                }
            })

        }
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
}