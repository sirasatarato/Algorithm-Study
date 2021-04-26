import Foundation

// Defining enum for throwing error
// throw RangeError.NotInRange... is used to throw the error
enum RangeError : Error {
    case NotInRange(String)
}

class Calculator {
    func power(n: Int, p: Int) throws -> Int {
        guard n >= 0, p >= 0 else {
            throw RangeError.NotInRange("n and p should be non-negative")
        }

        return Int(pow(Double(n), Double(p)))
    }
}

let myCalculator = Calculator()
let t = Int(readLine()!)!

for _ in 0..<t {
    let np = readLine()!.components(separatedBy: " ").map{ Int($0)! }
    let n = np[0]
    let p = np[1]

    do {
        let ans = try myCalculator.power(n: n, p: p)
        print(ans)
    } catch RangeError.NotInRange(let errorMsg) {
        print(errorMsg)
    }
}
