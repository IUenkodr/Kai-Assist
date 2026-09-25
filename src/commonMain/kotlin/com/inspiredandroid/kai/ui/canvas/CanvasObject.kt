package com.inspiredandroid.kai.ui.canvas

sealed class CanvasObject(val id: String, val position: androidx.compose.ui.geometry.Offset)
class TextCanvasObject(id: String, position: androidx.compose.ui.geometry.Offset, val text: String) : CanvasObject(id, position)
class CodeCanvasObject(id: String, position: androidx.compose.ui.geometry.Offset, val code: String) : CanvasObject(id, position)
