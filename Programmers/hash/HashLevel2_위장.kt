package programers.hash

private fun solution(clothes: Array<Array<String>>): Int {
    val counts = HashMap<String, Int>()
    for (i in clothes.map { it[1] }.toList()) counts[i] = if (counts.containsKey(i)) counts[i]!! + 1 else 1
    return counts.values.fold(1) { a, b -> a * (b + 1) } - 1
}

//fun solution(clothes: Array<Array<String>>): Int = clothes.groupBy { it[1] }.values.fold(1) { a, v -> a * (v.size + 1) }  - 1