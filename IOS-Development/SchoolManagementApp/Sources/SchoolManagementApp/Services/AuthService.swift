import Foundation

class AuthService {
    @MainActor
    static func login() {
        print("--- School Management System Login ---")
        while SessionManager.shared.currentUser == nil {
            let username = readUserInput(prompt: "Username:")
            let password = readUserInput(prompt: "Password:")

            if SessionManager.shared.login(username: username, password: password) {
                print("Welcome, \(SessionManager.shared.currentUser!.name)!")
            } else {
                print("Invalid credentials. Please try again.")
            }
        }
    }
}
