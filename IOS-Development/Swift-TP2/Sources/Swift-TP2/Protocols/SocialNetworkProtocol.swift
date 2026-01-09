protocol SocialNetworkProtocol {
    var name: String { get }
    var members: [Account] { get set }
    func registerUser(user: User, email: String, password: String, nickname: String?)
    func listMembers()
    func numberOfMembers() -> Int
}
