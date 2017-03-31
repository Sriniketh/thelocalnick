package booboo.thelocalnick.data

class Schedule(days: List<String>, timeFromHrs: Int, timeFromMins: Int, timeToHrs: Int, timeToMins: Int) {
    var days: List<String>? = null
    var timeFromHrs: Int? = null
    var timeFromMins: Int? = null
    var timeToHrs: Int? = null
    var timeToMins: Int? = null

    init {
        this.days = days
        this.timeFromHrs = timeFromHrs
        this.timeFromMins = timeFromMins
        this.timeToHrs = timeToHrs
        this.timeToMins = timeToMins
    }

    fun daysToString(): String {
        var temp: String = ""
        for (day in days!!) {
            temp += day + " "
        }
        return temp
    }
}
