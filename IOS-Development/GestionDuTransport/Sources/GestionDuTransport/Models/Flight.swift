import Foundation

class Flight {
    private let number: String
    private let date: Date
    private var staffMembers: [Staff] = []
    private var reservations: [Reservation] = []

    init(number: String, date: Date, staffMembers: [Staff], reservations: [Reservation]) {
        self.number = number
        self.date = date
        self.staffMembers = staffMembers
        self.reservations = reservations
    }

}
