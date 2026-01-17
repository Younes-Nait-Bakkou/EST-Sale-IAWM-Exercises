import Foundation

@MainActor
class StudentService {
    private let student: Student

    init(user: Student) {
        self.student = user
    }

    func showMenu() {
        loop: while true {
            print("\n--- Student Menu ---")
            print("1. View My Grades")
            print("2. View My Transcript (Semester \(student.semester))")
            print("3. Request Transcript")
            print("4. Logout")

            let choice = readUserInput(prompt: "Your choice:")
            switch choice {
            case "1": viewGrades()
            case "2": viewTranscript()
            case "3": requestTranscript()
            case "4":
                SessionManager.shared.logout()
                break loop
            default: print("Invalid option.")
            }
        }
    }

    private func viewGrades() {
        print("\n--- My Grades ---")
        guard !student.grades.isEmpty else {
            print("You have no grades recorded yet.")
            return
        }
        for grade in student.grades {
            print("- \(grade.subject.name): \(grade.score)/20")
        }
    }

    private func viewTranscript() {
        print("\n--- Transcript for Semester \(student.semester) ---")
        print("Student: \(student.name)")

        let semesterGrades = student.grades
        guard !semesterGrades.isEmpty else {
            print("No grades found for this semester.")
            return
        }

        viewGrades()

        let scores = semesterGrades.map { $0.score }
        let average = scores.reduce(0, +) / Double(scores.count)
        print(String(format: "\nSemester Average: %.2f/20", average))

        if average >= 10 {
            print("Status: Pass")
        } else {
            print("Status: Fail")
        }
    }

    private func requestTranscript() {
        print("\n--- Transcript Request ---")
        print("A request for an official transcript has been sent to the administration.")
        print("You will be notified upon its availability.")
    }
}
