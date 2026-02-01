import Foundation

enum ReservationError: Error, LocalizedError {
    case alreadyHasReservation
    case invalidStatus
    case flightNotOpen

    var errorDescription: String? {
        switch self {
        case .alreadyHasReservation:
            return "Already has a reservation"
        case .invalidStatus:
            return "Invalid status"
        case .flightNotOpen:
            return "Flight not open"
        }
    }
}
