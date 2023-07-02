package com.localiza.jdc.designsystem.ui_components.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.localiza.jdc.designsystem.ui_components.component.AlertType.*
import com.localiza.jdc.designsystem.ui_components.theme.Blue0
import com.localiza.jdc.designsystem.ui_components.theme.Blue90
import com.localiza.jdc.designsystem.ui_components.theme.Green80
import com.localiza.jdc.designsystem.ui_components.theme.Mint0
import com.localiza.jdc.designsystem.ui_components.theme.Mint80
import com.localiza.jdc.designsystem.ui_components.theme.Orange0
import com.localiza.jdc.designsystem.ui_components.theme.Orange90
import com.localiza.jdc.designsystem.ui_components.theme.Rose0
import com.localiza.jdc.designsystem.ui_components.theme.Rose80
import com.localiza.jdc.designsystem.ui_components.theme.Spacing

enum class AlertType {
    ERROR,
    SUCCESS,
    WARNING,
    INFO
}

@Composable
fun LocalizaAlert(modifier: Modifier, type: AlertType, message: String) {
    val icon = when (type) {
        ERROR -> Icons.Outlined.ErrorOutline
        SUCCESS -> Icons.Outlined.CheckCircleOutline
        WARNING -> Icons.Outlined.WarningAmber
        INFO -> Icons.Outlined.Info
    }

    val backgroundColor = when (type) {
        ERROR -> Rose0
        SUCCESS -> Mint0
        WARNING -> Orange0
        INFO -> Blue0
    }

    val textColor = when (type) {
        ERROR -> Rose80
        SUCCESS -> Mint80
        WARNING -> Orange90
        INFO -> Blue90
    }

    Surface(
        modifier = modifier,
        color = Color.Transparent,
        border = BorderStroke(width = 1.dp, color = Color.Transparent),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(modifier = Modifier.background(color = backgroundColor)) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Icon(imageVector = icon, contentDescription = type.name, tint = textColor, modifier = Modifier.padding(start = 10.dp))
                    Text(modifier = Modifier.padding(start = 8.dp, end = 16.dp), text = message, color = textColor)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

}

@Preview
@Composable
fun previewLocalizaAlertError() {
    LocalizaAlert(modifier = Modifier, type =  ERROR, "Exemplo de mensagem de Erro! Apenas um modelo")
}

@Preview
@Composable
fun previewLocalizaAlertSuccess() {
    LocalizaAlert(modifier = Modifier, type =  SUCCESS, "Exemplo de mensagem de Sucesso! Apenas um modelo")
}

@Preview
@Composable
fun previewLocalizaAlertWarning() {
    LocalizaAlert(modifier = Modifier, type =  WARNING, "Exemplo de mensagem de Alerta! Apenas um modelo")
}

@Preview
@Composable
fun previewLocalizaAlertInfo() {
    LocalizaAlert(modifier = Modifier, type =  INFO, "Exemplo de mensagem de Informação! Apenas um modelo")
}