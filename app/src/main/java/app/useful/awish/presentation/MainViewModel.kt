package app.useful.awish.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.useful.awish.domain.models.SaveUserNameParam
import app.useful.awish.domain.models.UserName
import app.useful.awish.domain.usecase.GetUserNameUseCase
import app.useful.awish.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
    ) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "VM Created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM Cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData : Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value =  "Save result = $resultData"
    }

    fun load(){
        val userName : UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }

}