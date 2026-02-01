class Airport {
    private let codeIATA: String
    private let city: String

    init(codeIATA: String, city: String) {
        self.codeIATA = codeIATA
        self.city = city
    }

    public func displayInfo() {
        print("Code IATA: \(codeIATA)")
        print("City: \(city)")
    }
}
