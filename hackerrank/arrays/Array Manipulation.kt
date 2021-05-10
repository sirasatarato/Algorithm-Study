package hackerrank.arrays

/*
시간제한 때문에 Brute-force 로 해결할 수 없다.
따라서 prefix sum Algorithm(구간 합 알고리즘)을 사용하여 코드를 최적화해야 한다.
배열의 a에서 b까지 범위 내의 모든 요소에 k를 추가하는 대신 다른 배열에 누적합니다.
우리가 어떤 인덱스에서든 배열에 추가하고 prefix sum Algorithm 을 적용할 때마다 같은 요소가 배열의 끝까지 추가될 것 입니다.

ex- n=5, m=1, a=2 b=5 k=5

    i     0.....1.....2.....3.....4.....5.....6   //인덱스가 범위를 벗어나지 않도록 N + 1 크기의 배열을 사용합니다.
  A[i]    0     0     0     0     0     0     0

     i    0.....1.....2.....3.....4.....5.....6
   A[i]   0     0     5     0     0     0     0

     i    0.....1.....2.....3.....4.....5.....6
  A[i]    0     0     5     5     5     5     5

K=5가 prefix sum Algorithm 을 적용한 후 끝까지 모든 요소에 추가되지만, k를 끝까지 추가할 필요가 없습니다.
이를 방지하려면 b+1 인덱스 뒤에 -K를 추가하여 [a,b] 범위에서만 K를 추가할 수 있도록 해야 합니다.

A[b + 1] = A[b] - k

    i    0.....1.....2.....3.....4.....5.....6
  A[i]   0     0     5     0     0     0    -5

    i    0.....1.....2.....3.....4.....5.....6
  A[i]   0     0     5     5     5     5     0

K=5가 a=2에서 b=5까지 추가 되었습니다.



또 다른 예시)

         # 0.....1.....2.....3.....4.....5.....6
5 3      # 0     0     0     0     0     0     0
1 2 100  # 0    100    0   -100    0     0     0
2 5 100  # 0    100   100  -100    0     0   -100
3 4 100  # 0    100   100    0     0  -100   -100

모든 작업을 수행한 후 prefix sum Algorithm 적용

    i      0.....1.....2.....3.....4.....5.....6
  A[i]     0     100   200  200   200   100    0
최종적으로 최대값은 200이고 O(N) 시간이 걸립니다.
각 쿼리에 대해 두 인덱스를 업데이트하려면 O(1)* 쿼리 수(m)가 필요

전체 복잡도 = O(N) + O(M) = O(N + M)
* */

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val answer = LongArray(n + 1)

    for ((a, b, k) in queries) {
        answer[a] += k.toLong()

        if (b + 1 < n) {
            answer[b + 1] -= k.toLong()
        }
    }

    var max = 0L
    var sum = 0L
    for (i in 1..n) {
        sum += answer[i]
        max = kotlin.math.max(max, sum)
    }

    return max
}

fun main() {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")
    val n = firstMultipleInput[0].toInt()
    val m = firstMultipleInput[1].toInt()
    val queries = Array(m) { Array(3) { 0 } }

    for (i in 0 until m) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}
