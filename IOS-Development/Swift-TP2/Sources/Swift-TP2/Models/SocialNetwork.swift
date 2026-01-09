class SocialNetwork: SocialNetworkProtocol {
    let name: String
    var members: [Account] = []

    init(name: String) {
        self.name = name
    }

    func registerUser(user: User, email: String, password: String, nickname: String?) {
        let member = Account(user: user, email: email, password: password, nickname: nickname)

        self.members.append(member)
    }

    func listMembers() {
        print("\n--- Network: \(name) ---")
        for member in members {
            print(
                "\(name): \(member.description)"
            )
        }
    }

    func numberOfMembers() -> Int {
        return members.count
    }
}
