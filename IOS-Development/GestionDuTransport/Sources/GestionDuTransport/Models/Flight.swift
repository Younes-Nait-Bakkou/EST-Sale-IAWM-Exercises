import Foundation

class Flight {
    private let number: String
    private let date: Date
    private(set) var status: FlightStatus = FlightStatus.closed
    private var staffMembers: [Staff] = []
    private var reservations: [Reservation] = []
    private let airplane: Airplane
    private let departure: Airport
    private let arrival: Airport

    init(date: Date, airplane: Airplane, departure: Airport, arrival: Airport) throws {
        self.number = Faker.generateFlightNumber()
        self.date = date
        self.airplane = airplane
        self.departure = departure
        self.arrival = arrival

        try airplane.assignFlight(flight: self)
    }

    public func addStaffMember(member: Staff) {
        self.staffMembers.append(member)
    }

    public func addReservation(reservation: Reservation) {
        self.reservations.append(reservation)
    }

    public func openFlight() {
        self.status = FlightStatus.open
    }

    public func closeFlight() {
        self.status = FlightStatus.closed
    }

    public func countReservations() -> Int {
        return self.reservations.filter({ r in return r.status == ReservationStatus.confirmed })
            .count
    }

    public func countStaffMembers() -> Int {
        return self.staffMembers.count
    }

}
