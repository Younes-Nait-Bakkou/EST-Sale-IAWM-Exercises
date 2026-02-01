class Passenger: Person {
    private let passport: String
    private(set) var reservation: Reservation?

    override init(firstName: String, lastName: String) {
        self.passport = Faker.generatePassportNumber()

        super.init(firstName: firstName, lastName: lastName)
    }

    public func reserveFlight(flight: Flight, seat: String, price: Double) throws {
        guard reservation == nil else {
            throw ReservationError.alreadyHasReservation
        }
        guard flight.status == .open else {
            throw ReservationError.flightNotOpen
        }

        let newReservation = Reservation(seat: seat, price: price, flight: flight, passenger: self)

        self.reservation = newReservation

        flight.addReservation(reservation: newReservation)
    }
}
