package com.saadfauzi.edupajak.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.saadfauzi.edupajak.R
import com.saadfauzi.edupajak.data.local.PajakEntity
import com.saadfauzi.edupajak.ui.navigation.Screens
import kotlinx.coroutines.launch

@Composable
fun AvailableData(
    pajakEntityList: List<PajakEntity>,
    navController: NavController,
    scaffoldState: ScaffoldState,
    onUpdateFavoriteTourism: (id: Int, isFavorite: Boolean) -> Unit,
) {
    LazyColumn {
        items(pajakEntityList, key = { it.taxesName }) { taxes ->
            PajakItem(taxes, navController, scaffoldState, onUpdateFavoriteTourism)
        }
    }
}

@Composable
fun PajakItem(
    pajak: PajakEntity,
    navController: NavController,
    scaffoldState: ScaffoldState,
    onUpdateFavoriteTourism: (id: Int, isFavorite: Boolean) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val (id, taxesCode, taxesName, taxesIcon, desc, isBookmarked) = pajak

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .border(1.dp, Color.LightGray.copy(0.5f), MaterialTheme.shapes.small)
            .clickable { navController.navigate(Screens.Detail.createRoute(id)) },
    ) {
        Column {
            Box {
                AsyncImage(
                    model = taxesIcon,
                    contentDescription = taxesName,
                    contentScale = ContentScale.FillWidth,
                    placeholder = painterResource(R.drawable.placeholder_image),
                    modifier = Modifier.fillMaxWidth()
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(bottomEnd = 8.dp))
                        .background(Color.Red)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = taxesCode.toString(),
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {
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
                                onUpdateFavoriteTourism(id ?: 0, !isBookmarked)
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
            }
        }
    }
}