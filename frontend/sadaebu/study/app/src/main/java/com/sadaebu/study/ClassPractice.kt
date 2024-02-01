package com.sadaebu.study

// Java처럼 파일명과 class명을 반드시 일치해야 할 필요는 없음! 선택사항

open class Human (){
    val name = "jellyfish"

    // init: 객체가 생성될 때마다 자동으로 실행되는 구문 (ex. 컴퓨터를 실행할 때마다 자동으로 실행되는 Windows 운영체제 like 초기값 불러오기)
    init{
        println("New Human is Born!")
    }

    fun eatingCake(){
        println("This is so yummy~~~~")
    }

    open fun singAsong(){
        println("lalala")
    }
}

// 부생성자(Secondary Constructor): 주생성자 측에서 받지 않은 매개변수를 추가적으로 받아 객체를 생성할 수 있게 해주는 문법 (ex. 기본 음료에 포함되지 않은 옵션을 토핑 추가할 때)
// 주생성자 옵션이 먼저 실행되고 나서 실행됨 (ex. init은 주생성자의 옵션이므로 init이 실행되고 난 후에 부생성자 constructor가 실행됨)
// 위 코드를 부생성자를 사용하는 형태로 다시 작성할 경우
/*
class Human(val name: String) {
    constructor(name: String, age: Int) : this(name) {
        println("$name is $age years old.")
    }
}
 */

// Kotlin 상속: class 자식객체명 : 부모객체명() {}
// 하나의 클래스만 상속받을 수 있음
// open: 특정 클래스가 다른 클래스에 의해 상속될 수 있음을 나타내는 문법, 부모객체 쪽에 작성
// Kotlin은 기본적으로 모든 클래스가 'final'이라는 속성을 가지고 있어 다른 클래스가 상속할 수 없음

class Korean : Human() {
    // override: 부모 클래스의 기능을 그대로 사용하지 않고,자식 클래스에서 이를 약간씩 변형하거나 추가하여 자신만의 기능을 만들어내는 문법
    override fun singAsong() {
        println("라라라")
    }
}

fun main(){
    // Kotlin 객체 생성 문법: val 변수명 = 클래스명()
    val human = Human()
    human.eatingCake()

    println("This human's name is ${human.name}")

    val korean = Korean()
    korean.singAsong()

}

// 위 코드를 생성자를 사용하는 형태로 다시 작성할 경우
/*
// constructor: 해당 클래스가 생성자를 사용하고 있음을 명시하는 문법, 생략 가능
class Human constructor(val name: String){
    fun eatingCake(){
        println("This is so yummy~~~~")
    }
}

// 아래와 같은 형태로 'Annonymous'라는 기본값 지정 가능
// 기본값 지정시 빈 생성자 생성 가능
// 빈 생성자: 매개변수 없이 객체를 생성할 수 있는 생성자 (ex. val stranger = Human())
class Human constructor(val name: String = "Annonymous"){
    fun eatingCake(){
        println("This is so yummy~~~~")
    }
}

fun main(){
    val human = Human("jellyfish")
    human.eatingCake()

    println("This human's name is ${human.name}")
}
*/