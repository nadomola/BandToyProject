package com.sadaebu.study

// Kotlin 함수의 기본형: fun 함수명

// 엔트리 함수(Entry Function): 프로그램에서 가장 먼저 실행되는 함수
fun main(){
    helloWorld()
    println(add(4,5))
    stringTemplate()
    checkNum(1)
    forAndWhile()
}

// return값이 없는 함수: fun 함수명() : Unit{} 형태
// Unit: return값이 없음을 나타내는 단어, Java의 void와 같은 의미, 생략 가능
fun helloWorld() : Unit {
    println("Hello World!")
}

// return값이 있는 함수: fun 함수명(변수명 : 변수형, 변수명 : 변수형) : 반환형 형태
// 자료형의 첫 글자를 대문자로 작성해야 하는 것에 유의
// return값이 있을 경우 반환형 생략 불가
fun add(a : Int, b :Int) : Int {
    return a + b
}

// val: value, 상수, 변하지 않는 값, val 상수명 : 상수형 = 값 형태
// var: variable, 변수, 변하는 값, val 변수명 : 변수형 = 값 형태
// 자료형 생략 가능
fun type(){
    val a : Int = 10
    var b : Int = 9
    val c = 8
    var d = 7
}

// 문자열 템플릿: 문자열 내에 변수를 삽입할 수 있는 문법, {$변수명} 형태
// $ 기호를 사용하고 싶을 경우: $ 기호 앞에 \ 추가
fun stringTemplate(){
    val name = "Jelly"
    val lastName = "Fish"
    println("My Name is ${name + lastName}!")
    println("Is This True? ${1==0}")
    println("This is 2\$.")

}

// 한 줄 주석: //
// 여러 줄 주석: /* 기호로 시작해서 */ 기호로 끝내기
// 주석 단축키: Drag + Ctrl + /

// 기본형 if 조건문
fun maxBy(a : Int, b : Int) : Int {
    if(a > b) {
        return a
    } else {
        return b
    }
}

// Kotlin형 if 조건문: Kotlin은 삼항 연산자 사용이 불가한 대신, 아래와 같은 형태로 축약된 조건문 작성 가능
fun maxBy2(a : Int, b : Int) : Int = if(a > b) a else b

// when 조건문: switch 조건문과 같은 기능
// when 조건문을 반환값 지정에 사용할 경우: else문 반드시 작성

fun checkNum(score : Int) {
    when(score) {
        0 -> println("This is 0!")
        1 -> println("This is 1!")
        2 -> println("This is 2!")
        3,4 -> println("This is 3 or 4!")
        else -> println("I don't know!")
    }

    var result : Int = when(score){
        1 -> 1
        2 -> 2
        3 -> 3
        else -> 4
    }

    println("result is ${result}")

    when(score){
        in 90..100 -> println("You are Genius!")
        in 70..89 -> println("Excellent!")
        in 50 .. 69 -> println("Great Job!")
        in 30 .. 49 -> println("Well done!")
        in 10..29 -> println("Okay!")
        else -> println("You can Do It!")
    }
}

// Expression: 표현식, 특정 기능 수행 뒤 값을 반환하는 식 (ex. 2+3=5)
// Statement: 문장, 어떠한 기능을 수행하지만 값을 반환하지 않는 식 (ex. val a = 100)
// Kotlin의 모든 함수는 표현식! why? 반환값이 없는 함수도 형식상으로는 Unit이라는 반환값을 가지고 있기 때문!
// Java의 경우, void 함수는 문장 취급

// Array: 배열, 각 항목의 크기가 고정되어 있음
// List: 리스트, 각 항목 수정이 가능한 Mutable List와 각 항목 수정이 불가능한 (Immutable) List로 구분
// 배열 또한 수정이 가능하므로 기능적으로는 Mutable List로 볼 수 있음
fun array(){
    val array = arrayOf(1, 2, 3)
    val array2 = arrayOf(1, "A", 2, "B")
    val list = listOf(1, 2, 3)
    val list2 = listOf(1, "C", 2, "D")

    array[0] = 3
    var result = list.get(0)

    var arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 20
}

// for 반복문: for (변수명 in 반복할 배열명){} 형태
// step: 반복문에서 숫자 범위를 반복할 때, 몇 칸씩 건너뛸 것인지 결정하는 문법
// downTo: 반복문에서 특정 숫자부터 다른 숫자까지 숫자를 줄여가며 반복할 때 사용하는 문법 (ex. i in 5 downTo 1)
// ..: 시작 숫자와 끝 숫자를 모두 포함하는 범위 (≤)
// until: 시작 숫자와 끝 숫자를 모두 포함하지 않는 범위 (＜)
// while 반복문: while (조건문) {} 형태
fun forAndWhile(){
    val students = arrayListOf("Joyce", "James", "Jennie", "Jennifer")

    for (name in students){
        println("${name}")
    }

    for ((index : Int, name : String) in students.withIndex()){
        println("${index+1}번째 학생: ${name}")
    }


    var sum : Int = 0
    for (i in 1..10 step 2){
        sum += i
    }
    println(sum)

    var index : Int = 0
    while(index < 10){
        println("Current Index: ${index}")
        index++
    }
}

// Nullable: null값을 가질 수 있는 변수, var name: String? = null 형태
// NonNull: null값을 가질 수 없는 변수, var name: String = "A" 형태
// Nullable 변수임을 알리기 위해 반드시 자료형에 물음표를 붙여야 하므로 자료형 생략 불가
fun nullCheck(){
    var name : String = "jellyfish"
    var nullName : String? = null
    var nameInUpperCase = name.uppercase()
    var nullNameUpperCase = nullName?.uppercase()

    // 엘비스 프레슬리 연산자: ?: 고개를 왼쪽으로 돌려서 봤을 때 비스 프레슬리의 머리모양과 닮아서 붙여진 이름
    // null값 다루기에 특화된 연산자
    // Kotlin형 if 조건문과 유사한 형태
    // nullable_변수명? : null일_경우_대체할_값 형태
    var lastName : String? = null
    var fullName = name + "" + (lastName?: "No lastName")

}

// !!: 이 값은 무조건 null이 아니라는 것을 전달하는 문법, 100% 확신하지 않는 이상 사용해서는 안 됨, 남용 자제
fun ignoreNulls(str : String?){
    val notNull : String = str!!
    val upper : String = notNull.uppercase()

    val email : String? = "20211234@duksung.ac.kr"
    // 아래 코드의 뜻: email이 null이 아니라면, let 안의 코드를 실행하라!
    email?.let {
        println("My E-mail is ${it}")
    }

}