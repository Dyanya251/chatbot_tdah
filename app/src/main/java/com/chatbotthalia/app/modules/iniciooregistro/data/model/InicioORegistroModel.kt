package com.chatbotthalia.app.modules.iniciooregistro.`data`.model

import com.chatbotthalia.app.R
import com.chatbotthalia.app.appcomponents.di.MyApp
import kotlin.String

data class InicioORegistroModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtThalia: String? = MyApp.getInstance().resources.getString(R.string.lbl_thalia)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTeayudareaen: String? =
      MyApp.getInstance().resources.getString(R.string.msg_te_ayudare_a_en)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtO: String? = MyApp.getInstance().resources.getString(R.string.lbl_o)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtIniciaSesin: String? = MyApp.getInstance().resources.getString(R.string.lbl_inicia_sesi_n)

)
