package com.chatbotthalia.app.modules.solicituddediagnostico.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.chatbotthalia.app.R
import com.chatbotthalia.app.appcomponents.base.BaseActivity
import com.chatbotthalia.app.databinding.ActivitySolicitudDeDiagnosticoBinding
import com.chatbotthalia.app.modules.solicituddediagnostico.`data`.viewmodel.SolicitudDeDiagnosticoVM
import kotlin.String
import kotlin.Unit

class SolicitudDeDiagnosticoActivity :
    BaseActivity<ActivitySolicitudDeDiagnosticoBinding>(R.layout.activity_solicitud_de_diagnostico)
    {
  private val viewModel: SolicitudDeDiagnosticoVM by viewModels<SolicitudDeDiagnosticoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.solicitudDeDiagnosticoVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SOLICITUD_DE_DIAGNOSTICO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SolicitudDeDiagnosticoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
