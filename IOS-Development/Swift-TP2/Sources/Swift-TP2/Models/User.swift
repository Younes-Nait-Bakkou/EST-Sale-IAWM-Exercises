struct User: CustomStringConvertible {
    var firstName: String
    var lastName: String
    var phoneNumber: String

    init(firstName: String, lastName: String, phoneNumber: String) {
        self.firstName = firstName
        self.lastName = lastName
        self.phoneNumber = phoneNumber
    }

    var description: String {
        return "\(firstName) \(lastName)"
    }
}
