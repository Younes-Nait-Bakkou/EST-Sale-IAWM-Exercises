import Foundation

@MainActor
class SessionManager {
    static let shared = SessionManager()
    
    var currentUser: User?
    
    private init() {}
    
    func login(username: String, password enteredPassword: String) -> Bool {
        let user = Database.shared.findUser(username: username)
        
        if let user = user, user.passwordHash == enteredPassword {
            self.currentUser = user
            return true
        }
        return false
    }
    
    func logout() {
        currentUser = nil
        print("You have been logged out.")
    }
}