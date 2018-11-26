package com.hiper2d.ui

import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.text.Text
import javafx.stage.Stage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import kotlinx.coroutines.javafx.JavaFx as Main

class ExampleApp: Application() {

    private val hello = Text("Hello World!").apply {
        fill = Color.valueOf("#C0C0C0")
    }

    private val fab = Circle(20.0, Color.valueOf("#FF4081"))

    private val root = StackPane().apply {
        children += hello
        children += fab
        StackPane.setAlignment(hello, Pos.CENTER)
        StackPane.setAlignment(fab, Pos.BOTTOM_RIGHT)
        StackPane.setMargin(fab, Insets(15.0))
    }

    private val scene = Scene(root, 240.0, 380.0).apply {
        fill = Color.valueOf("#303030")
    }

    override fun start(stage: Stage) {
        stage.title = "Example"
        stage.scene = scene
        stage.show()
        setup(hello, fab)
    }
}

fun setup(hello: Text, fab: Circle) {
    GlobalScope.launch(Dispatchers.Main) {
        (10 downTo 1).forEach {
            hello.text = "Counting $it ..."
            delay(500)
        }
        hello.text = "Done!"
    }
}

fun main(args: Array<String>) {
    Application.launch(ExampleApp::class.java, *args)
}