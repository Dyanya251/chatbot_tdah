package com.chatbotthalia.app.modules.iniciarsesion.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.chatbotthalia.app.R
import com.chatbotthalia.app.appcomponents.base.BaseActivity
import com.chatbotthalia.app.databinding.ActivityIniciarSesionBinding
import com.chatbotthalia.app.modules.iniciarsesion.`data`.viewmodel.IniciarSesionVM
import com.chatbotthalia.app.modules.iniciooregistro.ui.InicioORegistroActivity
import com.chatbotthalia.app.modules.solicituddediagnostico.ui.SolicitudDeDiagnosticoActivity
import kotlin.String
import kotlin.Unit

class IniciarSesionActivity :
    BaseActivity<ActivityIniciarSesionBinding>(R.layout.activity_iniciar_sesion) {
  private val viewModel: IniciarSesionVM by viewModels<IniciarSesionVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.iniciarSesionVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtRegresar.setOnClickListener {
      val destIntent = InicioORegistroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtThree.setOnClickListener {
      val destIntent = SolicitudDeDiagnosticoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "INICIAR_SESION_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, IniciarSesionActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
