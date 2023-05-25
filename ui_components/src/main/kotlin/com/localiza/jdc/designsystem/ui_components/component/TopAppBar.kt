package com.localiza.jdc.designsystem.ui_components.component

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CarCrash
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.localiza.jdc.designsystem.R
import com.localiza.jdc.designsystem.ui_components.theme.Black
import com.localiza.jdc.designsystem.ui_components.theme.LocalizaJDCMaterialTheme
import com.localiza.jdc.designsystem.ui_components.theme.White

@Composable
fun LocalizaTopAppBar(
    title: String = "",
    isStartActionBackPage: Boolean = false,
    onClickStartAction: () -> Unit = {},
    isEndActionLECOLogo: Boolean = true,
    navigationIcons: List<ImageVector> = emptyList(),
    onClickNavigationIcons: List<() -> Unit> = emptyList()
) {
    val context = LocalContext.current
    TopAppBar(
        backgroundColor = if (isSystemInDarkTheme()) Black else MaterialTheme.colors.primary,
        title = { Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
        navigationIcon = {
            IconButton(onClick = { onClickStartAction() }) {
                Icon(
                    if (isStartActionBackPage) Icons.Filled.ArrowBack else Icons.Filled.Menu,
                    contentDescription = null
                )
            }
        },
        actions = {
            navigationIcons.forEachIndexed { index, icon ->
                IconButton(onClick = {
                    try {
                        onClickNavigationIcons[index]
                    } catch (_: IndexOutOfBoundsException) {
                    }
                }) {
                    Icon(
                        imageVector = icon,
                        tint = if (isSystemInDarkTheme()) White else Black,
                        contentDescription = null
                    )
                }
            }
            if (isEndActionLECOLogo)
                IconButton(onClick = {
                    Toast.makeText(context, "Logo L&CO", Toast.LENGTH_SHORT).show()
                }) {
                    Image(
                        painterResource(
                            id = if (isSystemInDarkTheme())
                                R.drawable.logo_reduzida_leco_2
                            else
                                R.drawable.logo_reduzida_leco_1
                        ),
                        null
                    )
                }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun previewLocalizaTopAppBar() {
    LocalizaJDCMaterialTheme {
        Surface {
            Column {
                LocalizaTopAppBar(
                    title = "Agiliza",
                    navigationIcons = listOf(Icons.Filled.Person, Icons.Filled.Help)
                )
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun previewLocalizaTopAppBarDark() {
    LocalizaJDCMaterialTheme {
        Surface {
            Column {
                LocalizaTopAppBar(
                    title = "Assistência",
                    isEndActionLECOLogo = false,
                    navigationIcons = listOf(
                        Icons.Filled.Person,
                        Icons.Filled.Help,
                        Icons.Filled.CarCrash
                    ),
                    isStartActionBackPage = true
                )
            }
        }
    }
}