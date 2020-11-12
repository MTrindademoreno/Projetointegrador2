package dominando.android.goodfood

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize

data class Restaurant(val image:String,val nome :String, val endereco:String, val horario:String, val pratos :  List<Pratos>):Parcelable