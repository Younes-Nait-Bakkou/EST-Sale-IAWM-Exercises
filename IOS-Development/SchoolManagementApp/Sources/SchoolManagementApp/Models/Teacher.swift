import Foundation

class Teacher: User {
    var subjectsTaught: [Subject] = []
    
    override init(username: String, passwordHash: String, name: String) {
        super.init(username: username, passwordHash: passwordHash, name: name)
    }
}