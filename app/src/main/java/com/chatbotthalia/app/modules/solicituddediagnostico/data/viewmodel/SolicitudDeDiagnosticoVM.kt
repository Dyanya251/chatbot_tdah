package com.chatbotthalia.app.modules.solicituddediagnostico.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chatbotthalia.app.modules.solicituddediagnostico.`data`.model.SolicitudDeDiagnosticoModel
import org.koin.core.KoinComponent

class SolicitudDeDiagnosticoVM : ViewModel(), KoinComponent {
  val solicitudDeDiagnosticoModel: MutableLiveData<SolicitudDeDiagnosticoModel> =
      MutableLiveData(SolicitudDeDiagnosticoModel())

  var navArguments: Bundle? = null
}
