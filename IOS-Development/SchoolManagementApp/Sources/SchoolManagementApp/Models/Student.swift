import Foundation

class Student: User {
    var grades: [Grade] = []
    var semester: Int
    
    init(username: String, passwordHash: String, name: String, semester: Int) {
        self.semester = semester
        super.init(username: username, passwordHash: passwordHash, name: name)
    }
}