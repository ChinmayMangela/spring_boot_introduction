package com.example.spring_boot_introduction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootIntroductionApplication

fun main(args: Array<String>) {
	runApplication<SpringBootIntroductionApplication>(*args)
}
