class Airplane {
    private let registration: String
    private let capacity: Int
    private var flight: Flight? = nil

    init(capacity: Int) {
        self.registration = Faker.generateAirplaneID()
        self.capacity = capacity
    }

    func assignFlight(flight: Flight) throws {
        guard self.flight == nil else {
            throw FlightError.airplaneAlreadyAssigned
        }

        self.flight = flight
    }

    func verifyCapacity() -> Bool {
        guard let flight = self.flight else {
            return true
        }

        return flight.countReservations() < capacity
    }

}
