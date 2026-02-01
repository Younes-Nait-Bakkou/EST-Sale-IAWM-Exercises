class Person {
    private let id: Int
    private var firstName: String
    private var lastName: String

    init(firstName: String, lastName: String) {
        self.id = Faker.generateRandomIntID()
        self.firstName = firstName
        self.lastName = lastName
    }

    public func displayInfo() {
        print("ID: \(id), Full Name: \(firstName) \(lastName)")
    }

}
