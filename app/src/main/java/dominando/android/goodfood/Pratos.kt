package dominando.android.goodfood

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pratos(val imgPrato:String,val nome:String, val descricao:String):Parcelable