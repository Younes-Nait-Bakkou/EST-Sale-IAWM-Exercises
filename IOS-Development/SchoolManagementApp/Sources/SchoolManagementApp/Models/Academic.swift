import Foundation

class Subject {
    let uuid: UUID
    var name: String
    weak var teacher: Teacher?
    var students: [Student] = []
    
    init(name: String) {
        self.uuid = UUID()
        self.name = name
    }
}

class Module {
    let uuid: UUID
    var name: String
    var subjects: [Subject]
    
    init(name: String, subjects: [Subject]) {
        self.uuid = UUID()
        self.name = name
        self.subjects = subjects
    }
}

class Grade {
    let student: Student
    let subject: Subject
    var score: Double
    
    init(student: Student, subject: Subject, score: Double) {
        self.student = student
        self.subject = subject
        self.score = score
    }
}