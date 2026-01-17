import Foundation

class User {
    let uuid: UUID
    var username: String
    var passwordHash: String
    var name: String
    
    init(username: String, passwordHash: String, name: String) {
        self.uuid = UUID()
        self.username = username
        self.passwordHash = passwordHash
        self.name = name
    }
}