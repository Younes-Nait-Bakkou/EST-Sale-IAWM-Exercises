import Foundation

let casablancaAirport = Airport(codeIATA: "CMN", city: "Casablanca")
let marrakechAirport = Airport(codeIATA: "RAK", city: "Marrakech")

casablancaAirport.displayInfo()

let airplane = Airplane(capacity: 10)
print("Is airplane not full: \(airplane.verifyCapacity())")

let ahmedStaff = Staff(firstName: "Ahmed", lastName: "Benali", role: "Pilot")
let mohamedStaff = Staff(firstName: "Mohamed", lastName: "Benali", role: "Attendant")

let karimPassenger = Passenger(firstName: "Karim", lastName: "Benali")

var components = DateComponents()
components.year = 2026
components.month = 2
components.day = 10
components.hour = 15
components.minute = 30

let casablanceFlightDate = Calendar.current.date(from: components)!

do {

    let casablancaToMarrakechFlight = try Flight(
        date: Date(), airplane: airplane, departure: casablancaAirport, arrival: marrakechAirport)

    casablancaToMarrakechFlight.openFlight()

    print(
        "Number of reservations before reservation: \(casablancaToMarrakechFlight.countReservations())"
    )

    try karimPassenger.reserveFlight(flight: casablancaToMarrakechFlight, seat: "A10", price: 100)

    print(
        "Number of reservations after draft reservation: \(casablancaToMarrakechFlight.countReservations())"
    )

    try karimPassenger.reservation?.confirm()

    print(
        "Number of reservations after confirmed reservation: \(casablancaToMarrakechFlight.countReservations())"
    )

    print(
        "Number of staff before staff assignment: \(casablancaToMarrakechFlight.countStaffMembers())"
    )

    try ahmedStaff.assignFlight(flight: casablancaToMarrakechFlight)
    try mohamedStaff.assignFlight(flight: casablancaToMarrakechFlight)

    print(
        "Number of staff after staff assignment: \(casablancaToMarrakechFlight.countStaffMembers())"
    )

} catch {
    print(error.localizedDescription)
}
