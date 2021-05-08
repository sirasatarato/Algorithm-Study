package hackerrank.arrays

import kotlin.math.max

/*
현재 index에서 2 이상 앞설 수는 없으니 "Too chaotic"을 출력한다.

만약 어떤 사람이 누군가에게 뇌물을 주고 앞선다는 것은 원래 위치에 서 있지 않거나,
혹은 나보다 더 많은 숫자를 가진 모든 사람이 어느 순간 나에게 뇌물을 준 것이다.

여기서 최대 두 개의 뇌물만 허용한다.
num의 경우 내부 루프는 [num - 2, arr.size - 1] 또는 [0, arr.size - 1]이 된다 (num - 2 < 0인 경우)

예를 들어 보자
from: [1,2,3,4,5,6,7,8]
to:   [1,2,5,3,7,8,6,4]

여기서 Person4는 어느 시점에 4개에게 뇌물을 주고 왼쪽으로이동해야 한다.
4는[6,8,7,5]개의 숫자가 앞에 있으므로 오른쪽 사람들이 Person4에게 뇌물을 주고
왼쪽으로 이동해야 한다는 것을 의미한다.

참고: Person4는 원래 위치보다 앞서 있지 않기 때문에 뇌물을 주지 않는다.

Person7과 Person8도 Person6 보다 앞섰고, 다른 사람들도 같은 방법으로 찾을 수 있다.

따라서 다음과 같은 과정을 나타낼 수 있다.
for 4: 4 (6, 8, 7, 5)
for 6: 2 (8, 7)
for 8: 0
for 7: 0
for 3: 1 (5)
for 5: 0
for 2: 0
for 1: 0

그래서 앞서야 하는 사람들을 다 합해보면 총 7명이다.
* */

fun minimumBribes(q: Array<Int>) {
    var count = 0

    for (i in q.lastIndex downTo 0) {
        if (q[i] - (i + 1) > 2) {
            println("Too chaotic")
            return
        } else {
            for (j in max(0, q[i] - 2) until i) {
                if (q[j] > q[i]) {
                    count++
                }
            }
        }
    }

    println(count)
}

fun main() {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val q = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        minimumBribes(q)
    }
}
