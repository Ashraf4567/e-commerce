package com.route.e_commerce.util

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.Fragment

fun Fragment.showMessage(
    message: String,
    posActionName: String? = null,
    posAction: DialogInterface.OnClickListener? = null,
    nagActionName: String? = null,
    negAction: DialogInterface.OnClickListener? = null

): AlertDialog {
    val dialogBuilder = AlertDialog.Builder(context)
    dialogBuilder.setMessage(message)
    if (posActionName != null) {
        dialogBuilder.setPositiveButton(posActionName, posAction)
    }
    if (nagActionName != null) {
        dialogBuilder.setNegativeButton(nagActionName, negAction)
    }

    return dialogBuilder.show()
}