package com.chatbotthalia.app.modules.registro.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chatbotthalia.app.modules.registro.`data`.model.RegistroModel
import org.koin.core.KoinComponent

class RegistroVM : ViewModel(), KoinComponent {
  val registroModel: MutableLiveData<RegistroModel> = MutableLiveData(RegistroModel())

  var navArguments: Bundle? = null
}
