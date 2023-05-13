package com.localiza.jdc.designsystem.ui_components.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.localiza.jdc.designsystem.ui_components.theme.Green20
import com.localiza.jdc.designsystem.ui_components.theme.Green80
import com.localiza.jdc.designsystem.ui_components.theme.LECOPrimaryEnabledNormalNoIcon
import com.localiza.jdc.designsystem.ui_components.theme.LocalizaJDCMaterialTheme
import com.localiza.jdc.designsystem.ui_components.theme.RACPrimaryEnabledNormalNoIcon

enum class ButtonType {
    Primary,
    Outlined,
    Text
}

@Composable
fun LocalizaButton(
    modifier: Modifier,
    text: String,
    isLECO: Boolean,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = if (isLECO) Green20 else Green80),
        onClick = onClick
    ) {
        Text(text = text, color = if (isLECO) Color.Black else Color.White, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun RACPrimaryButton() {
    LocalizaJDCMaterialTheme {
        LocalizaButton(
            isLECO = false,
            modifier = RACPrimaryEnabledNormalNoIcon.fillMaxWidth(),
            text = "Primary",
            onClick = {}
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
            text = "Primary",
            onClick = {}
        )
    }
}