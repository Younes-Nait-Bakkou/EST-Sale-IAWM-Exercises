struct Account: CustomStringConvertible {
    let user: User
    let email: String
    let password: String
    let nickname: String?

    init(user: User, email: String, password: String, nickname: String?) {
        self.user = user
        self.email = email
        self.password = password
        self.nickname = nickname
    }

    var description: String {
        var description = "\(user.description) \(email) \(password)"

        if let nickname {
            description += " \(nickname)"
        }

        return description
    }

}
