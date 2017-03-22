package booboo.thelocalnick.data

class Spot (name: String, address: String, description: String) {
    var name: String? = null
    var address: String? = null
    var description: String? = null

    init {
        this.name = name
        this.address = address
        this.description = description
    }
}
