import Foundation

func readUserInput(prompt: String) -> String {
    print(prompt, terminator: " ")
    while let line = readLine() {
        if !line.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty {
            return line
        }
    }
    return ""
}
