import Foundation

struct Faker {
    static func generateRandomIntID(digits: Int = 6) -> Int {
        let min = Int(pow(10.0, Double(digits - 1)))
        let max = Int(pow(10.0, Double(digits))) - 1
        return Int.random(in: min...max)
    }

    static func generateCIN() -> String {
        let cityCodes = [
            "A", "AA",  // Rabat
            "BE",  // Salé
            "B", "BK",  // Casablanca
            "D", "DN",  // Meknes
            "C", "CD",  // Fez
            "E", "EE",  // Marrakech
            "J", "JK",  // Agadir
            "K", "KA",  // Tangier
            "L",  // Tetouan
        ]

        let prefix = cityCodes.randomElement()!
        let number = Int.random(in: 10000...999999)
        return "\(prefix)\(number)"
    }

    static func generateEmployeeNumber() -> String {
        return "M-\(Int.random(in: 10000...99999))"
    }

    static func generateFlightNumber() -> String {
        let airlines = ["AT", "3O"]
        let prefix = airlines.randomElement()!
        let number = Int.random(in: 100...999)
        return "\(prefix)\(number)"
    }

    static func generateAirportCode() -> String {
        let airports = [
            "CMN",  // Mohammed V (Casablanca)
            "RAK",  // Menara (Marrakech)
            "RBA",  // Rabat-Salé
            "TNG",  // Ibn Battouta (Tangier)
            "FEZ",  // Saïss (Fez)
            "AGA",  // Al Massira (Agadir)
            "OUD",  // Angads (Oujda)
        ]
        return airports.randomElement()!
    }

    static func generateAirplaneID() -> String {
        let letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        let suffix = String((0..<3).map { _ in letters.randomElement()! })
        return "CN-\(suffix)"
    }

    static func generateReservationID() -> String {
        let chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return String((0..<6).map { _ in chars.randomElement()! })
    }

    static func generatePassportNumber() -> String {
        let letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        let prefix = String((0..<2).map { _ in letters.randomElement()! })

        let numbers = Int.random(in: 1_000_000...9_999_999)

        return "\(prefix)\(numbers)"
    }
}
