package dominando.android.goodfood.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Prato(val imgPrato:String, val nome:String, val descricao:String):Parcelable