import Foundation

class Flight {
    let number: String
    let date: Date
    var staffMembers: [Staff]
    var reservations: [Reservation]

    init(number: String, date: Date, staffMembers: [Staff], reservations: [Reservation]) {
        self.number = number
        self.date = date
        self.staffMembers = staffMembers
        self.reservations = reservations
    }

}
