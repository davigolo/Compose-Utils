package com.example.myapplication.ui.screens.Login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.formutils.PassTextField
import com.example.myapplication.ui.formutils.UserTextField
import com.example.myapplication.ui.screens.Screen

@Preview(showBackground = true)


@Composable
fun Login(loginViewModel: LoginViewModel = viewModel()) {

    val state = loginViewModel.state
    val message = when {
        state.userLoggedIn -> "Success"
        state.error != null -> state.error
        else -> null
    }

    LoginForm(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.LightGray)
            .padding(16.dp)
            .width(IntrinsicSize.Min),
        message = message,
        onSubmit = { user, pass -> loginViewModel.loginClick(user, pass) }
    )
}

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    message: String?,
    onSubmit: (user: String, pass: String) -> Unit
) {
    Screen {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            modifier = modifier
        ) {

            var user by rememberSaveable { mutableStateOf("") }
            var pass by rememberSaveable { mutableStateOf("") }
            val isButtonEnabled = user.isNotEmpty() && pass.isNotEmpty()

            UserTextField(
                value = user,
                onValueChange = { user = it },
                message = message

            )

            PassTextField(
                pass = pass,
                onValueChange = { pass = it },
                isError = message != null,
                imeAction = ImeAction.Done,
                onImeActionClick = { if (isButtonEnabled) onSubmit(user, pass) }
            )

            Button(
                onClick = { onSubmit(user, pass) },
                modifier = Modifier.fillMaxWidth(),
                enabled = isButtonEnabled
            ) {
                Text(text = "Login")
            }
            if (message != null) {
                Text(text = message, color = MaterialTheme.colorScheme.error)
            }
        }

    }
}


/*
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun LoginFormDarkMode() {
    LoginForm(message = "")
}
 */
