class Reservation {
    private let number: String
    private let seat: String
    private let price: Double
    private let flight: Flight

    init(number: String, seat: String, price: Double, flight: Flight) {
        self.number = number
        self.seat = seat
        self.price = price
        self.flight = flight
    }

    public func confirm() {
        fatalError("Not implemented")
    }

    public func cancel() {
        fatalError("Not implemented")
    }
}
