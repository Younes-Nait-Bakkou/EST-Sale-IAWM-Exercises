import Foundation

@MainActor
class TeacherService {
    private let teacher: Teacher

    init(user: Teacher) {
        self.teacher = user
    }

    func showMenu() {
        loop: while true {
            print("\n--- Teacher Menu ---")
            print("1. Grade Students")
            print("2. View Grade Report")
            print("3. Logout")

            let choice = readUserInput(prompt: "Your choice:")
            switch choice {
            case "1": gradeStudents()
            case "2": viewGradeReport()
            case "3":
                SessionManager.shared.logout()
                break loop
            default: print("Invalid option.")
            }
        }
    }

    private func selectSubject() -> Subject? {
        guard !teacher.subjectsTaught.isEmpty else {
            print("You are not assigned to any subjects.")
            return nil
        }

        print("\nSelect a subject:")
        for (index, subject) in teacher.subjectsTaught.enumerated() {
            print("\(index + 1). \(subject.name)")
        }

        let choice = Int(readUserInput(prompt: "Your choice:")) ?? 0
        if (1...teacher.subjectsTaught.count).contains(choice) {
            return teacher.subjectsTaught[choice - 1]
        } else {
            print("Invalid selection.")
            return nil
        }
    }

    private func gradeStudents() {
        guard let subject = selectSubject() else { return }

        print("\n--- Grading for \(subject.name) ---")
        guard !subject.students.isEmpty else {
            print("No students are enrolled in this subject.")
            return
        }

        for student in subject.students {
            let existingGrade = student.grades.first { $0.subject.uuid == subject.uuid }

            let prompt =
                "Enter grade for \(student.name) (current: \(existingGrade.map { String($0.score) } ?? "N/A"))/20:"
            let gradeInput = Double(readUserInput(prompt: prompt))

            guard let score = gradeInput, (0...20).contains(score) else {
                print("Invalid grade. Must be between 0 and 20. Skipping.")
                continue
            }

            if let grade = existingGrade {
                grade.score = score
            } else {
                let newGrade = Grade(student: student, subject: subject, score: score)
                student.grades.append(newGrade)
            }
        }

        print("\nGrades updated for \(subject.name).")
        calculateAndShowStats(for: subject)
    }

    private func viewGradeReport() {
        guard let subject = selectSubject() else { return }
        print("\n--- Grade Report for \(subject.name) ---")

        let gradesForSubject = subject.students.compactMap { student -> Grade? in
            return student.grades.first { $0.subject.uuid == subject.uuid }
        }

        guard !gradesForSubject.isEmpty else {
            print("No grades have been entered for this subject yet.")
            return
        }

        for grade in gradesForSubject {
            print("- \(grade.student.name): \(grade.score)/20")
        }

        calculateAndShowStats(for: subject)
    }

    private func calculateAndShowStats(for subject: Subject) {
        let scores = subject.students.compactMap {
            $0.grades.first { $0.subject.uuid == subject.uuid }?.score
        }

        guard !scores.isEmpty else { return }

        let minGrade = scores.min() ?? 0
        let maxGrade = scores.max() ?? 0
        let averageGrade = scores.reduce(0, +) / Double(scores.count)

        print("\n--- Statistics for \(subject.name) ---")
        print(String(format: "Minimum Grade: %.2f/20", minGrade))
        print(String(format: "Maximum Grade: %.2f/20", maxGrade))
        print(String(format: "Average Grade: %.2f/20", averageGrade))
    }
}
