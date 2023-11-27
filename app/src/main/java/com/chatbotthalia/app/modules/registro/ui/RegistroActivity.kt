package com.chatbotthalia.app.modules.registro.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.chatbotthalia.app.R
import com.chatbotthalia.app.appcomponents.base.BaseActivity
import com.chatbotthalia.app.databinding.ActivityRegistroBinding
import com.chatbotthalia.app.modules.iniciooregistro.ui.InicioORegistroActivity
import com.chatbotthalia.app.modules.registro.`data`.viewmodel.RegistroVM
import com.chatbotthalia.app.modules.solicituddediagnostico.ui.SolicitudDeDiagnosticoActivity
import kotlin.String
import kotlin.Unit

class RegistroActivity : BaseActivity<ActivityRegistroBinding>(R.layout.activity_registro) {
  private val viewModel: RegistroVM by viewModels<RegistroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.registroVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtRegresar.setOnClickListener {
      val destIntent = InicioORegistroActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnRegistrate.setOnClickListener {
      val destIntent = SolicitudDeDiagnosticoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "REGISTRO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegistroActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
