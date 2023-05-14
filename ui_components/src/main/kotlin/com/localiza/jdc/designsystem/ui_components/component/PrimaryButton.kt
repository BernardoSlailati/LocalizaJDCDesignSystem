package com.localiza.jdc.designsystem.ui_components.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.localiza.jdc.designsystem.R
import com.localiza.jdc.designsystem.ui_components.component.ButtonSize.NORMAL
import com.localiza.jdc.designsystem.ui_components.theme.Gray30
import com.localiza.jdc.designsystem.ui_components.theme.Gray50
import com.localiza.jdc.designsystem.ui_components.theme.Green20
import com.localiza.jdc.designsystem.ui_components.theme.Green30
import com.localiza.jdc.designsystem.ui_components.theme.Green80
import com.localiza.jdc.designsystem.ui_components.theme.LECOPrimaryEnabledNormalNoIcon
import com.localiza.jdc.designsystem.ui_components.theme.LocalizaJDCMaterialTheme
import com.localiza.jdc.designsystem.ui_components.theme.Mint70
import com.localiza.jdc.designsystem.ui_components.theme.RACPrimaryEnabledNormalNoIcon
import com.localiza.jdc.designsystem.ui_components.theme.Spacing

enum class ButtonSize {
    NORMAL,
    X_SMALL,
    SMALL,
    LARGE,
    X_LARGE
}

@Composable
fun LocalizaButton(
    modifier: Modifier,
    text: String,
    size: ButtonSize = NORMAL,
    isLECO: Boolean,
    @DrawableRes iconStart: Int? = null,
    @DrawableRes iconEnd: Int? = null,
    onClick: () -> Unit
) {
    var selected by remember { mutableStateOf(false) }
    val color = if (selected) {
        if (isLECO) Green30 else Mint70
    } else {
        if (isLECO) Green20 else Green80
    }

    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            contentColor = if (isLECO) Color.Black else Color.White,
            disabledBackgroundColor = Gray30,
            disabledContentColor = Gray50
        ),
        onClick = {
            selected = !selected
            onClick()
        }
    ) {
        if (iconStart != null)
            Icon(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = iconStart),
                contentDescription = stringResource(id = R.string.button_icon_content_description)
            )
        Text(
            text = text,
            fontWeight = FontWeight.Bold
        )
        if (iconEnd != null)
            Icon(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = iconEnd),
                contentDescription = stringResource(id = R.string.button_icon_content_description)
            )
    }
}

@Preview
@Composable
fun RACPrimaryButton() {
    LocalizaJDCMaterialTheme {
        LocalizaButton(
            isLECO = false,
            modifier = RACPrimaryEnabledNormalNoIcon.fillMaxWidth(),
            text = "Compras",
            onClick = {},
            iconEnd = R.drawable.carrinho_de_compras
        )
    }
}

@Preview
@Composable
fun LECOPrimaryButton() {
    LocalizaJDCMaterialTheme {
        LocalizaButton(
            isLECO = true,
            modifier = LECOPrimaryEnabledNormalNoIcon.fillMaxWidth(),
            text = "Neutralização de Carbono",
            onClick = {},
            iconStart = R.drawable.neutraliza
        )
    }
}