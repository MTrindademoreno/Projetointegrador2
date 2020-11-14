package dominando.android.goodfood.model

import android.os.Parcelable
import dominando.android.goodfood.model.Prato
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Restaurant(val image:String,val nome :String, val endereco:String, val horario:String, val pratos :  List<Prato>):Parcelable