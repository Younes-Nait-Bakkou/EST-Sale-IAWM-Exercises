import Foundation

_ = Database.shared

print("--- Welcome to the School Management System ---")

while true {
    if SessionManager.shared.currentUser == nil {
        AuthService.login()
    }

    if let user = SessionManager.shared.currentUser {
        switch user {
        case let admin as Admin:
            AdminService(user: admin).showMenu()
        case let deptHead as DepartmentHead:
            DepartmentHeadService(user: deptHead).showMenu()
        case let teacher as Teacher:
            TeacherService(user: teacher).showMenu()
        case let student as Student:
            StudentService(user: student).showMenu()
        default:
            print("Unknown user role. Logging out.")
            SessionManager.shared.logout()
        }
    } else {
        print("\nSession ended. Please login to continue.")
    }
}
