package com.chatbotthalia.app.modules.iniciooregistro.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chatbotthalia.app.modules.iniciooregistro.`data`.model.InicioORegistroModel
import org.koin.core.KoinComponent

class InicioORegistroVM : ViewModel(), KoinComponent {
  val inicioORegistroModel: MutableLiveData<InicioORegistroModel> =
      MutableLiveData(InicioORegistroModel())

  var navArguments: Bundle? = null
}
