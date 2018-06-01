package be.mygod.vpnhotspot.manage

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View

object ManageBar : Manager() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) = start(itemView.context)
    }

    override val type: Int get() = VIEW_TYPE_MANAGE

    fun start(context: Context) {
        try {
            context.startActivity(Intent()
                    .setClassName("com.android.settings", "com.android.settings.Settings\$TetherSettingsActivity"))
        } catch (e: ActivityNotFoundException) {
            context.startActivity(Intent()
                    .setClassName("com.android.settings", "com.android.settings.TetherSettings"))
        }
    }
}
