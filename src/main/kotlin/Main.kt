fun main() {
    var time: Int

    time = 31*60*60 // 31 час - от суток до двух
    println(agoToText(time))
}

fun agoToText(sec: Int): String {
    val min: Int = 60
    val hour: Int = 60*60
    val day: Int = 24*60*60

    var result = "был(а) " + when {
        sec in 0..min           -> "только что"
        sec in min + 1..hour    -> agoToTextMin(sec)
        sec in hour + 1..day    -> agoToTextHour(sec)
        sec in day + 1.. 2 * day    -> "сегодня"
        sec in 2 * day + 1..3 * day -> "вчера"
        else                          -> "давно"

    }

    return result
}

fun agoToTextMin(sec: Int): String {
    val min = sec / 60 // переводим в минуты
    var result: String

    var minForCompare: Int = min % 100
    if(min > 20) minForCompare = min %10

    result = when {
        minForCompare == 1               -> "$min минуту"
        minForCompare in 2..4     -> "$min минуты"
        //min in 5..20     -> "минут"
        else -> "$min минут"
    } + " назад"

    return result
}

fun agoToTextHour(sec: Int): String {
    val hour = sec / 60 / 60 // переводим в часы
    var result: String

    var hourForCompare: Int = hour % 100
    if(hour>20) hourForCompare = hour % 10

    result = when {
        hourForCompare == 1               -> "$hour час"
        hourForCompare in 2..4     -> "$hour часа"
        //hour in 5..20     -> "часов"
        else -> "$hour часов"
    } + " назад"

    return result
}