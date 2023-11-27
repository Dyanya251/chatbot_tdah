package com.chatbotthalia.app.modules.registro.`data`.model

import com.chatbotthalia.app.R
import com.chatbotthalia.app.appcomponents.di.MyApp
import kotlin.String

data class RegistroModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtThalia: String? = MyApp.getInstance().resources.getString(R.string.lbl_thalia)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNombredeusuar: String? =
      MyApp.getInstance().resources.getString(R.string.msg_nombre_de_usuar)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtContrasea: String? = MyApp.getInstance().resources.getString(R.string.lbl_contrase_a)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGradoescolar: String? = MyApp.getInstance().resources.getString(R.string.lbl_grado_escolar)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRegresar: String? = MyApp.getInstance().resources.getString(R.string.lbl_regresar)

)
