import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {

    var uistate = mutableStateOf(AppUistate())

    private val _nom get() = uistate.value.nom
    private val _postnom get() = uistate.value.postnom

    fun onNomChange(newValue:String){
        uistate.value=uistate.value.copy(nom = newValue)
    }

    fun onPostNomChange(newValue: String){
        uistate.value =uistate.value.copy(postnom = newValue)
    }

    fun onBtnClik() {

        uistate.value=uistate.value.copy(isDialogShown = true)
    }

    fun onDismiss() {
        uistate.value=uistate.value.copy(isDialogShown = false)
    }


}


data class AppUistate(

    val isDialogShown :Boolean = false,
    val nom: String = "",
    val postnom: String = ""
)