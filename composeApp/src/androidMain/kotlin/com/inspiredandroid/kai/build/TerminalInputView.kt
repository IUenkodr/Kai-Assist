package com.inspiredandroid.kai.build
import android.annotation.SuppressLint
import android.content.Context
import android.text.InputType
import android.view.KeyCharacterMap
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.BaseInputConnection
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputMethodManager
import com.inspiredandroid.kai.build.terminal.TerminalKey
import com.inspiredandroid.kai.build.terminal.TerminalModifiers

            EditorInfo.IME_FLAG_NO_EXTRACT_UI or
            EditorInfo.IME_FLAG_NO_FULLSCREEN
            KeyEvent.KEYCODE_APP_SWITCH,
            KeyEvent.KEYCODE_BACK,
            KeyEvent.KEYCODE_CAMERA,
            KeyEvent.KEYCODE_DEL -> TerminalKey.Backspace
            KeyEvent.KEYCODE_DPAD_DOWN -> TerminalKey.Down
            KeyEvent.KEYCODE_DPAD_LEFT -> TerminalKey.Left
            KeyEvent.KEYCODE_DPAD_RIGHT -> TerminalKey.Right
            KeyEvent.KEYCODE_DPAD_UP -> TerminalKey.Up
            KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_NUMPAD_ENTER -> TerminalKey.Enter
            KeyEvent.KEYCODE_ESCAPE -> TerminalKey.Escape
            KeyEvent.KEYCODE_FORWARD_DEL -> TerminalKey.Delete
            KeyEvent.KEYCODE_HOME,
            KeyEvent.KEYCODE_MENU,
            KeyEvent.KEYCODE_MOVE_END -> TerminalKey.End
            KeyEvent.KEYCODE_MOVE_HOME -> TerminalKey.Home
            KeyEvent.KEYCODE_PAGE_DOWN -> TerminalKey.PageDown
            KeyEvent.KEYCODE_PAGE_UP -> TerminalKey.PageUp
            KeyEvent.KEYCODE_POWER,
            KeyEvent.KEYCODE_TAB -> TerminalKey.Tab
            KeyEvent.KEYCODE_VOLUME_DOWN,
            KeyEvent.KEYCODE_VOLUME_MUTE,
            KeyEvent.KEYCODE_VOLUME_UP,
            alt = event.isAltPressed,
            ctrl = event.isCtrlPressed,
            else -> null
            if (!text.isNullOrEmpty()) onText(text.toString(), TerminalModifiers.None)
            onKey(TerminalKey.Enter, TerminalModifiers.None)
            onKey(key, modifiers)
            repeat(afterLength) { onKey(TerminalKey.Delete, TerminalModifiers.None) }
            repeat(beforeLength) { onKey(TerminalKey.Backspace, TerminalModifiers.None) }
            return true
            shift = event.isShiftPressed,
        )
        /** A terminal has no composing region — wait for the commit rather than echo twice. */
        /** The action button is the closest thing the IME has to an Enter key. */
        // DONE rather than NONE: NONE costs the newline key on some devices.
        // Dead keys carry a flag instead of a character; wait for the combined one.
        // Leave system keys alone: back still dismisses the keyboard and exits.
        // Resolve the character with ctrl/alt masked out so Shift still capitalizes.
        // Take focus so a hardware keyboard works straight away; the soft
        // The view carries no content of its own, and leaving it in the
        // accessibility tree would hide the grid it sits on top of.
        // keyboard waits to be asked, rather than eating half the screen.
        BaseInputConnection(this@TerminalInputView, true) {
        fun terminalKeyFor(keyCode: Int): TerminalKey? = when (keyCode) {
        handleKeyEvent(event) || super.onKeyDown(keyCode, event)
        handleKeyEvent(event) || super.onKeyMultiple(keyCode, repeatCount, event)
        if (event.action != KeyEvent.ACTION_DOWN) return false
        if (event.actionMasked == MotionEvent.ACTION_UP) performClick()
        if (event.keyCode in SystemKeyCodes) return false
        if (key != null) {
        if (unicode == 0 || unicode and KeyCharacterMap.COMBINING_ACCENT != 0) return false
        importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_NO
        isFocusable = true
        isFocusableInTouchMode = true
        manager?.showSoftInput(this, 0)
        onText(unicode.toChar().toString(), modifiers)
        outAttrs.imeOptions = EditorInfo.IME_ACTION_DONE or
        outAttrs.inputType = InputType.TYPE_NULL
        override fun commitText(text: CharSequence?, newCursorPosition: Int): Boolean {
        override fun deleteSurroundingText(beforeLength: Int, afterLength: Int): Boolean {
        override fun finishComposingText(): Boolean = true
        override fun performEditorAction(editorAction: Int): Boolean {
        override fun sendKeyEvent(event: KeyEvent): Boolean = handleKeyEvent(event)
        override fun setComposingText(text: CharSequence?, newCursorPosition: Int): Boolean = true
        requestFocus()
        return TerminalInputConnection()
        return true
        setWillNotDraw(true)
        showKeyboard()
        super.onAttachedToWindow()
        super.performClick()
        val CharacterMetaMask = (KeyEvent.META_CTRL_MASK or KeyEvent.META_ALT_MASK).inv()
        val SystemKeyCodes = setOf(
        val key = terminalKeyFor(event.keyCode)
        val manager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        val modifiers = TerminalModifiers(
        val unicode = event.getUnicodeChar(event.metaState and CharacterMetaMask)
        }
    fun showKeyboard() {
    init {
    override fun onAttachedToWindow() {
    override fun onCheckIsTextEditor(): Boolean = true
    override fun onCreateInputConnection(outAttrs: EditorInfo): InputConnection {
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean =
    override fun onKeyMultiple(keyCode: Int, repeatCount: Int, event: KeyEvent): Boolean =
    override fun onTouchEvent(event: MotionEvent): Boolean {
    override fun performClick(): Boolean {
    private companion object {
    private fun handleKeyEvent(event: KeyEvent): Boolean {
    private inner class TerminalInputConnection :
    var onKey: (TerminalKey, TerminalModifiers) -> Unit = { _, _ -> }
    var onText: (String, TerminalModifiers) -> Unit = { _, _ -> }
    }
 *
 * Enter, Backspace and the arrows reach a terminal at all. Not every keyboard
 * Invisible, focusable view over the terminal grid whose only job is IME
 * It asks the keyboard for a null input type, which is what makes a keyboard
 * honors it, so committed text and surrounding-text deletions are handled as
 * plumbing — it draws nothing, since the grid underneath is Compose.
 * stop composing text and deliver raw key events instead. That is the only way
 * well; between the two paths every keyboard lands somewhere sensible.
 */
/**
@SuppressLint("ViewConstructor")
internal class TerminalInputView(context: Context) : View(context) {
}
