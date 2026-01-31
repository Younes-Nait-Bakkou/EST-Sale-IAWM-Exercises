class Staff: Person {
    let staffNumber: String
    let role: String
    var assignedFlight: Flight?

    init(id: Int, firstName: String, lastName: String, staffNumber: String, role: String) {
        self.staffNumber = staffNumber
        self.role = role
        self.assignedFlight = nil
        super.init(id: id, firstName: firstName, lastName: lastName)
    }

    public func assignFlight(flight: Flight) {
        guard let flight = assignedFlight else {
            return
        }
        self.assignedFlight = flight
    }

}
