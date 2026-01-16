import Foundation

@MainActor
class DepartmentHeadService {
    private let deptHead: DepartmentHead
    
    init(user: DepartmentHead) {
        self.deptHead = user
    }
    
    func showMenu() {
        loop: while true {
            print("\n--- Department Head Menu ---")
            print("1. View Subject Report")
            print("2. View Deliberation PV (Pass/Fail List)")
            print("3. Logout")
            
            let choice = readUserInput(prompt: "Your choice:")
            switch choice {
            case "1": viewSubjectReport()
            case "2": viewDeliberationPV()
            case "3":
                SessionManager.shared.logout()
                break loop
            default: print("Invalid option.")
            }
        }
    }
    
    private func selectSubject() -> Subject? {
        let subjects = Database.shared.subjects
        print("\nSelect a subject:")
        for (index, subject) in subjects.enumerated() {
            print("\(index + 1). \(subject.name)")
        }
        
        let choice = Int(readUserInput(prompt: "Your choice:")) ?? 0
        if (1...subjects.count).contains(choice) {
            return subjects[choice - 1]
        } else {
            print("Invalid selection.")
            return nil
        }
    }
    
    private func viewSubjectReport() {
        guard let subject = selectSubject() else { return }
        
        let gradesForSubject = Database.shared.getStudents().flatMap {
            $0.grades.filter { $0.subject.uuid == subject.uuid }
        }
        
        guard !gradesForSubject.isEmpty else {
            print("No grades found for \(subject.name).")
            return
        }

        for grade in gradesForSubject {
            print("- \(grade.student.name): \(grade.score)/20")
        }
    }
    
    private func viewDeliberationPV() {
        print("\n--- Deliberation PV (Semester 1) ---")
        let students = Database.shared.getStudents().filter { $0.semester == 1 }
        
        for student in students {
            let scores = student.grades.map { $0.score }
            guard !scores.isEmpty else {
                print("- \(student.name): Incomplete Grades")
                continue
            }
            let average = scores.reduce(0, +) / Double(scores.count)
            let status = average >= 10 ? "PASS" : "FAIL"
            print(String(format: "- %-20s | Average: %5.2f | Status: %s", student.name, average, status))
        }
    }
}
