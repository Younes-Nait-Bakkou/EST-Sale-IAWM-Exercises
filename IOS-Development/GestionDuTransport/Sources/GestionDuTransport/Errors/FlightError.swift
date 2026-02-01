import Foundation

enum FlightError: Error, LocalizedError {
    case staffAlreadyAssigned
    case airplaneAlreadyAssigned

    var errorDescription: String? {
        switch self {
        case .staffAlreadyAssigned:
            return "This staff has already been assgined to a flight"
        case .airplaneAlreadyAssigned:
            return "This airplane has already been assgined to a flight"
        }
    }
}
