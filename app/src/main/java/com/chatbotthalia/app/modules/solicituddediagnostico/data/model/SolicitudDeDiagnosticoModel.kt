package com.chatbotthalia.app.modules.solicituddediagnostico.`data`.model

import com.chatbotthalia.app.R
import com.chatbotthalia.app.appcomponents.di.MyApp
import kotlin.String

data class SolicitudDeDiagnosticoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtOne: String? = MyApp.getInstance().resources.getString(R.string.lbl)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMessage: String? = MyApp.getInstance().resources.getString(R.string.lbl_respuesta)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etHolaDyanyraSoyThaliaValue: String? = null
)
