// Written in Kotlin 1.0.0

import java.util.Scanner
import java.lang.Math

fun main(vararg args: String) {
    val s = Scanner(System.`in`)
    
    val n = s.nextInt().let {
        if (it < 1 || it > 4)
            throw IllegalArgumentException()
        else
            it
    }
    
    val ts = (1..n).map {
        s.nextInt().let {
            if (it < 1 || it > 50)
            	throw IllegalArgumentException()
            else
            	it
        }
    }
    
    var result = Int.MAX_VALUE
    
    repeat(1 shl n) { bitflag ->
        /*
         * 全組み合わせをとる
         * (0, 1, 10, 11, 100, 101, 110, 111
         * 1000, 1001, 1010, 1011, 1100, 1101,
         * 1110, 1111)
         */
        var a = 0
        var b = 0
        
        repeat(n) { itr ->
            // お肉の数だけまわしてbitが立ってるやつをa、立ってないのをbに置く
            if (bitflag and (1 shl itr) > 0) {
                a += ts[itr]
            } else {
                b += ts[itr]
            }
        }
        
        val total = Math.max(a, b) // abで時間がかかるほう
        result = Math.min(result, total) // 最小のパターンを知りたいので
    }
    
    println(result)
}
