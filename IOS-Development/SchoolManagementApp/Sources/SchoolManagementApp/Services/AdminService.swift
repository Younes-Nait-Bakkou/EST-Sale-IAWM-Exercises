import Foundation

@MainActor
class AdminService {

    init(user: Admin) {}

    func showMenu() {
        loop: while true {
            print("\n--- Administrator Menu ---")
            print("1. Manage Students")
            print("2. Manage Teachers")
            print("3. Manage Subjects")
            print("4. Logout")

            let choice = readUserInput(prompt: "Your choice:")
            switch choice {
            case "1": manageStudents()
            case "2": manageTeachers()
            case "3": manageSubjects()
            case "4":
                SessionManager.shared.logout()
                break loop
            default: print("Invalid option.")
            }
        }
    }

    private func manageStudents() {
        print("\n--- Manage Students ---")

        let students = Database.shared.getStudents()
        students.forEach { print("- \($0.name) (Username: \($0.username))") }

        print("\n[C]reate, [D]elete, [B]ack")

        let action = readUserInput(prompt: "Action:").lowercased()

        switch action {
        case "c":
            let name = readUserInput(prompt: "Full Name:")
            let username = readUserInput(prompt: "Username:")
            let password = readUserInput(prompt: "Password:")
            let semester = Int(readUserInput(prompt: "Semester:")) ?? 1
            let newStudent = Student(
                username: username, passwordHash: password, name: name, semester: semester)

            Database.shared.users.append(newStudent)

            print("Student '\(name)' created.")

        case "d":
            let username = readUserInput(prompt: "Username of student to delete:")

            if let index = Database.shared.users.firstIndex(where: {
                $0.username == username && $0 is Student
            }) {
                let removedUser = Database.shared.users.remove(at: index)
                print("Student '\(removedUser.name)' deleted.")

            } else {
                print("Student not found.")
            }

        case "b":
            return
        default:
            print("Invalid action.")
        }
    }

    private func manageTeachers() {
        print("\n--- Manage Teachers ---")
        let teachers = Database.shared.getTeachers()

        teachers.forEach { print("- \($0.name) (Username: \($0.username))") }

        print("\n[C]reate, [D]elete, [B]ack")
        let action = readUserInput(prompt: "Action:").lowercased()

        switch action {
        case "c":
            let name = readUserInput(prompt: "Full Name:")
            let username = readUserInput(prompt: "Username:")
            let password = readUserInput(prompt: "Password:")
            let newTeacher = Teacher(username: username, passwordHash: password, name: name)

            Database.shared.users.append(newTeacher)

            print("Teacher '\(name)' created.")
        case "d":
            let username = readUserInput(prompt: "Username of teacher to delete:")

            if let index = Database.shared.users.firstIndex(where: {
                $0.username == username && $0 is Teacher
            }) {
                let teacher = Database.shared.users[index] as? Teacher

                Database.shared.subjects.forEach {
                    if $0.teacher?.uuid == teacher?.uuid {
                        $0.teacher = nil
                    }
                }

                let removedUser = Database.shared.users.remove(at: index)

                print("Teacher '\(removedUser.name)' deleted.")
            } else {
                print("Teacher not found.")
            }
        case "b":
            return
        default:
            print("Invalid action.")
        }
    }

    private func manageSubjects() {
        print("\n--- Manage Subjects ---")
        Database.shared.subjects.forEach { print("- \($0.name)") }

        print("\n[C]reate, [D]elete, [B]ack")
        let action = readUserInput(prompt: "Action:").lowercased()

        switch action {
        case "c":
            let name = readUserInput(prompt: "Subject Name:")
            let newSubject = Subject(name: name)

            Database.shared.subjects.append(newSubject)

            print("Subject '\(name)' created.")
        case "d":
            let name = readUserInput(prompt: "Name of subject to delete:")

            if let index = Database.shared.subjects.firstIndex(where: {
                $0.name.lowercased() == name.lowercased()
            }) {
                let removedSubject = Database.shared.subjects.remove(at: index)

                print("Subject '\(removedSubject.name)' deleted.")
            } else {
                print("Subject not found.")
            }

        case "b":
            return
        default:
            print("Invalid action.")
        }
    }
}
