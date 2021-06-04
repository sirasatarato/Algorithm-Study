package hackerrank.search

fun whatFlavors(cost: Array<Int>, money: Int) {
    val map = HashMap<Int, MutableList<Int>>()

    cost.withIndex().forEach {
        if(!map.containsKey(it.value)) map[it.value] = mutableListOf()
        map[it.value]!!.add(it.index)
    }

    for (i in cost.indices) {
        val nowMoney = money - cost[i]
        if(cost[i] == nowMoney && map.containsKey(nowMoney) && map[nowMoney]!!.size > 1) {
            println("${i + 1} ${map[nowMoney]?.get(1)?.plus(1)}")
            return
        }
        if (cost[i] != nowMoney && map.containsKey(nowMoney)) {
            println("${i + 1} ${map[nowMoney]?.first()?.plus(1)}")
            return
        }
    }
}

fun main() {
//    val t = readLine()!!.trim().toInt()
//
//    for (tItr in 1..t) {
//        val money = readLine()!!.trim().toInt()
//        val cost = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    whatFlavors(arrayOf(4, 3, 2, 5, 7), 8)
//    }
}
