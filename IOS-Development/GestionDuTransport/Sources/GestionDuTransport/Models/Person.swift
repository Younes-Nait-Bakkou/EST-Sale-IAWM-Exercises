class Person {
    private let id: Int
    private var firstName: String
    private var lastName: String

    init(id: Int, firstName: String, lastName: String) {
        self.id = id
        self.firstName = firstName
        self.lastName = lastName
    }

    public func displayInfo() {
        print("ID: \(id), Full Name: \(firstName) \(lastName)")
    }

}
