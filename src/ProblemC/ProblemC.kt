package ProblemC

import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(FileReader(File("C-large-practice.in")))
    val pw = PrintWriter(File("output.txt"))

    solve(br, pw)

    br.close()
    pw.close()
}

fun solve(br: BufferedReader, pw: PrintWriter) {
    val testCount = br.readLine().toInt()
    for (test in 1..testCount) {
        val (n, k) = br.readLine().split(" ").map(String::toLong)

        val counts = TreeMap<Long, Long> { a, b -> compareValues(b, a) }
        val set = TreeSet<Long>()

        counts[n] = 1
        set.add(n)

        while (set.isNotEmpty()) {
            val maxValue = set.last()
            val a = listOf((maxValue - 1) / 2, maxValue / 2)

            set.remove(maxValue)

            for (x in a) {
                if (x != 0L) {
                    counts[x] = (if (x in counts) counts[x]!! else 0) + counts[maxValue]!!
                    set.add(x)
                }
            }
        }

        var x1 = 0L
        var x2 = 0L
        var tempK = k

        for ((key, value) in counts) {
            tempK -= value
            if (tempK <= 0) {
                x1 = key / 2
                x2 = (key - 1) / 2
                break
            }
        }

        pw.println("Case #$test: $x1 $x2")
    }
}