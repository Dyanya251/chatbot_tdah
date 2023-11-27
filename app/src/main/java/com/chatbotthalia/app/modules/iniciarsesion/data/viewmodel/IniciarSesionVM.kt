package com.chatbotthalia.app.modules.iniciarsesion.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chatbotthalia.app.modules.iniciarsesion.`data`.model.IniciarSesionModel
import org.koin.core.KoinComponent

class IniciarSesionVM : ViewModel(), KoinComponent {
  val iniciarSesionModel: MutableLiveData<IniciarSesionModel> =
      MutableLiveData(IniciarSesionModel())

  var navArguments: Bundle? = null
}
