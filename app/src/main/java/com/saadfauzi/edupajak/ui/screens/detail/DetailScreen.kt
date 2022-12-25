package com.saadfauzi.edupajak.ui.screens.detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.saadfauzi.edupajak.data.local.PajakEntity
import com.saadfauzi.edupajak.ui.components.ErrorContent
import com.saadfauzi.edupajak.utilities.StateManagement
import kotlinx.coroutines.launch
import com.saadfauzi.edupajak.R

@Composable
fun DetailScreen(pajakId: Int, navController: NavController, scaffoldState: ScaffoldState) {
    val detailViewModel = hiltViewModel<DetailViewModel>()
    detailViewModel.taxes.collectAsState(StateManagement.Loading).value.let { state ->
        when (state) {
            is StateManagement.Loading -> detailViewModel.getTaxes(pajakId)
            is StateManagement.Error -> ErrorContent()
            is StateManagement.Success -> {
                DetailContent(
                    state.data,
                    navController,
                    scaffoldState,
                    detailViewModel::updateBookmarkedTaxes
                )
                Log.i("DetailScreen", state.data.toString())
            }
        }
    }
}

@Composable
fun DetailContent(
    pajak: PajakEntity,
    navController: NavController,
    scaffoldState: ScaffoldState,
    updatedBookmarkedItem: (id: Int, isBookmarked: Boolean) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val (id, taxesCode, taxesName, taxesIcon, desc, isBookmarked) = pajak
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 16.dp)
        ) {
            Box {
                AsyncImage(
                    model = taxesIcon,
                    contentDescription = taxesName,
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.placeholder_image),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topEnd = 8.dp))
                        .background(MaterialTheme.colors.primaryVariant)
                        .align(Alignment.BottomStart),
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text(
                            text = taxesCode.toString(),
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = taxesName,
                        style = MaterialTheme.typography.h6
                    )

                    Icon(
                        imageVector = if (isBookmarked) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                        tint = if (isBookmarked) Color.Red else MaterialTheme.colors.onSurface,
                        contentDescription = taxesName,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(RoundedCornerShape(100))
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                updatedBookmarkedItem(id ?: 0, !isBookmarked)
                                coroutineScope.launch {
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        message = "$taxesName ${if (isBookmarked) "dihapus dari" else "ditambahkan ke"} bookmark ",
                                        actionLabel = "Tutup",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            },
                    )
                }

//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    val nStar = countStar(rating)
//                    repeat(nStar) {
//                        Icon(
//                            imageVector = Icons.Rounded.Star,
//                            contentDescription = name,
//                            tint = Color(0xFFFFCC00)
//                        )
//                    }
//                    Spacer(modifier = Modifier.width(4.dp))
//                    Text(
//                        text = "rating reviews)",
//                        style = MaterialTheme.typography.body2
//                    )
//                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = desc,
                    style = MaterialTheme.typography.body1,
                    lineHeight = 24.sp,
                )
            }
        }

        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, "back")
                }
            },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White,
            elevation = 10.dp
        )

//        IconButton(
//            onClick = { navController.navigateUp() },
//            modifier = Modifier
//                .padding(start = 8.dp, top = 8.dp)
//                .align(Alignment.TopStart)
//                .clip(CircleShape)
//                .size(40.dp)
//                .testTag("back_button")
////                .background(Color.White)
//        ) {
//            Icon(
//                imageVector = Icons.Default.ArrowBack,
//                contentDescription = null,
//                modifier = Modifier
//                    .background(Color.White)
//            )
//        }
    }
}