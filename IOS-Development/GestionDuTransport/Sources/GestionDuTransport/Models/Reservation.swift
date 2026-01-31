class Reservation {
    let number: String
    let seat: String
    let price: Double
    let flight: Flight

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
