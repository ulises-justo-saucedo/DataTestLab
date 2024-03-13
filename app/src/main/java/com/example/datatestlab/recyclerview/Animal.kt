package com.example.datatestlab.recyclerview

data class Animal(
    val name: String,
    val type: String,
    val age: String
){
    constructor() : this("foo", "foo", "-1")
}
