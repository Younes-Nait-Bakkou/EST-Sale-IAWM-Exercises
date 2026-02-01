class Staff: Person {
    private let staffNumber: String
    private let role: String
    private var assignedFlight: Flight?

    init(firstName: String, lastName: String, role: String) {
        self.staffNumber = Faker.generateEmployeeNumber()
        self.role = role
        self.assignedFlight = nil

        super.init(firstName: firstName, lastName: lastName)
    }

    public func assignFlight(flight: Flight) throws {
        guard assignedFlight == nil else {
            throw FlightError.staffAlreadyAssigned
        }

        self.assignedFlight = flight

        flight.addStaffMember(member: self)
    }

}
