package hackerrank.dictionaries_and_hashmaps

fun checkMagazine(magazine: Array<String>, note: Array<String>) {
    for(word in note) {
        if (!magazine.contains(word)) {
            print("No")
            return
        }

        magazine[magazine.indexOfFirst { it == word }] = ""
    }

    print("Yes")
}

fun main() {
    val magazine = readLine()!!.trimEnd().split(" ").toTypedArray()

    val note = readLine()!!.trimEnd().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}
