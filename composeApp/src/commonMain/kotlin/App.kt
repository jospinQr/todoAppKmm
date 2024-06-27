import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import todoapp.composeapp.generated.resources.Res
import todoapp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App(viewModel: AppViewModel = viewModel { AppViewModel() }) {

    val uistate by viewModel.uistate
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    MaterialTheme {
        Scaffold(

            snackbarHost = { snackbarHostState },
            topBar = {
                TopAppBar(
                    title = { Text("ToDo App") },
                    actions = {
                        IconButton(onClick = {}, content = {
                            Icon(
                                Icons.Rounded.MoreVert, contentDescription = null
                            )
                        })
                    })
            }) {


            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text("Text")


                TextField(value = uistate.nom, onValueChange = viewModel::onNomChange, label = { Text("Nom") })
                TextField(
                    value = uistate.postnom,
                    onValueChange = viewModel::onPostNomChange,
                    label = { Text("Post-nom") })
                Button(onClick = {

                    viewModel.onBtnClik()

                }) {
                    Text("Ok")
                }

                Text("Mon nom est " + uistate.nom)
                Text("Mon postNom est " + uistate.postnom)


            }

        }
    }


    if (uistate.isDialogShown) {

        Dialog(
            onDismissRequest = { viewModel.onDismiss()},
            content = {
                Box(modifier = Modifier.background(color = MaterialTheme.colors.background, shape = RoundedCornerShape(10)).padding(50.dp)) {
                    Column(modifier = Modifier) {
                        Text("Nom est :" + uistate.nom)
                        Text("Post Nom est :" + uistate.postnom)
                    }

                }
            })

    }
}