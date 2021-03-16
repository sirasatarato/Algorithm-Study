package programers.exhaustiveSearch

fun solution(answers: IntArray): IntArray {
    val score = intArrayOf(0, 0, 0)
    val result = mutableListOf<Int>()
    val person1 = intArrayOf(1, 2, 3, 4, 5)
    val person2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val person3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    for (ans in answers.indices) {
        if (answers[ans] == person1[ans % 5]) {
            score[0]++
        }

        if (answers[ans] == person2[ans % 8]) {
            score[1]++
        }

        if (answers[ans] == person3[ans % 10]) {
            score[2]++
        }
    }

    val maxScore = Math.max(score[0], Math.max(score[1], score[2]))

    for (i in 0..2) {
        if (score[i] == maxScore) {
            result.add(i + 1)
        }
    }

    return result.toIntArray()
}