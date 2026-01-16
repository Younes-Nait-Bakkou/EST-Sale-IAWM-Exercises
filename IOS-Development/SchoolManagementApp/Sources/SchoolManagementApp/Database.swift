import Foundation

@MainActor
class Database {
    static let shared = Database()

    var users: [User] = []
    var subjects: [Subject] = []
    var modules: [Module] = []

    private init() {
        setupMockData()
    }

    func findUser(username: String) -> User? {
        return users.first { $0.username.lowercased() == username.lowercased() }
    }

    func getStudents() -> [Student] {
        return users.compactMap { $0 as? Student }
    }

    func getTeachers() -> [Teacher] {
        return users.compactMap { $0 as? Teacher }
    }

    private func setupMockData() {
        let math = Subject(name: "Algebra")
        let physics = Subject(name: "Mechanics")
        let cs = Subject(name: "Data Structures")
        let history = Subject(name: "World History")
        self.subjects = [math, physics, cs, history]

        let scienceModule = Module(name: "Core Science", subjects: [math, physics])
        let humanitiesModule = Module(name: "Humanities", subjects: [history])
        self.modules = [scienceModule, humanitiesModule]

        let teacher1 = Teacher(username: "t.dupont", passwordHash: "pass123", name: "Thomas Dupont")
        let teacher2 = Teacher(
            username: "t.martin", passwordHash: "pass123", name: "Therese Martin")
        let deptHead = DepartmentHead(
            username: "dh.leroy", passwordHash: "pass123", name: "David Leroy")

        math.teacher = teacher1
        physics.teacher = teacher1
        cs.teacher = teacher2
        history.teacher = deptHead

        teacher1.subjectsTaught = [math, physics]
        teacher2.subjectsTaught = [cs]
        deptHead.subjectsTaught = [history]

        let student1 = Student(
            username: "s.petit", passwordHash: "pass123", name: "Sylvie Petit", semester: 1)
        let student2 = Student(
            username: "s.durand", passwordHash: "pass123", name: "Simon Durand", semester: 1)
        let student3 = Student(
            username: "s.moreau", passwordHash: "pass123", name: "Sophie Moreau", semester: 2)

        math.students = [student1, student2]
        physics.students = [student1, student2]
        cs.students = [student1, student2, student3]
        history.students = [student3]

        let grade1 = Grade(student: student1, subject: math, score: 15.5)
        let grade2 = Grade(student: student2, subject: math, score: 12.0)
        let grade3 = Grade(student: student1, subject: physics, score: 18.0)
        let grade4 = Grade(student: student3, subject: cs, score: 16.0)

        student1.grades = [grade1, grade3]
        student2.grades = [grade2]
        student3.grades = [grade4]

        let admin = Admin(username: "admin", passwordHash: "admin123", name: "Administrator")

        self.users = [teacher1, teacher2, deptHead, student1, student2, student3, admin]
    }
}
