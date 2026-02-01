class Reservation {

    private var number: String
    private let seat: String
    private let price: Double
    private let flight: Flight
    private unowned let passenger: Passenger
    private(set) var status: ReservationStatus = ReservationStatus.draft

    init(seat: String, price: Double, flight: Flight, passenger: Passenger) {
        self.number = Faker.generateReservationID()
        self.seat = seat
        self.price = price
        self.flight = flight
        self.passenger = passenger
    }

    public func confirm() throws {
        guard status == ReservationStatus.draft else {
            throw ReservationError.invalidStatus
        }

        self.status = ReservationStatus.confirmed
    }

    public func cancel() throws {
        guard status == ReservationStatus.draft else {
            throw ReservationError.invalidStatus
        }

        self.status = ReservationStatus.cancelled
    }

}
