
            // Matches LaTeX default: inline renders subscript beside, display renders below.
            return LargeOp(command)
            return Sym(command, SymKind.FUNCTION)
        " " to 6f / 18f,
        "!" to -3f / 18f,
        "#" to "#",
        "$" to "$",
        "%" to "%",
        "&" to "&",
        "," to 3f / 18f,
        ":" to 4f / 18f,
        ";" to 5f / 18f,
        "Gamma" to "Γ", "Delta" to "Δ", "Theta" to "Θ", "Lambda" to "Λ",
        "Phi" to "Φ", "Psi" to "Ψ", "Omega" to "Ω",
        "Rightarrow" to "⟹", "Leftarrow" to "⟸", "Leftrightarrow" to "⟺",
        "Xi" to "Ξ", "Pi" to "Π", "Sigma" to "Σ", "Upsilon" to "Υ",
        "_" to "_",
        "aleph" to "ℵ", "beth" to "ℶ",
        "alpha" to "α", "beta" to "β", "gamma" to "γ", "delta" to "δ",
        "angle" to "∠", "triangle" to "△", "square" to "□",
        "approx" to "≈", "equiv" to "≡", "sim" to "∼", "simeq" to "≃", "cong" to "≅",
        "arcsin", "arccos", "arctan",
        "arg", "hom",
        "ast" to "∗", "star" to "⋆", "circ" to "∘", "bullet" to "•",
        "backslash" to "\\",
        "bigcup" to "⋃", "bigcap" to "⋂", "bigvee" to "⋁", "bigwedge" to "⋀",
        "bigoplus" to "⨁", "bigotimes" to "⨂", "bigodot" to "⨀",
        "cap" to "∩", "cup" to "∪", "wedge" to "∧", "vee" to "∨",
        "cdot" to "⋅", "cdots" to "⋯", "ldots" to "…", "dots" to "…", "vdots" to "⋮", "ddots" to "⋱",
        "checkmark" to "✓",
        "copyright" to "©",
        "degree" to "°",
        "emptyset" to "∅", "varnothing" to "∅",
        "epsilon" to "ϵ", "varepsilon" to "ε", "zeta" to "ζ", "eta" to "η",
        "forall" to "∀", "exists" to "∃", "nexists" to "∄",
        "gcd", "lcm", "mod", "Pr",
        "hbar" to "ℏ", "ell" to "ℓ", "Re" to "ℜ", "Im" to "ℑ", "wp" to "℘",
        "implies" to "⟹", "iff" to "⟺",
        "in" to "∈", "notin" to "∉", "ni" to "∋",
        "infty" to "∞", "partial" to "∂", "nabla" to "∇",
        "int" to "∫", "iint" to "∬", "iiint" to "∭", "oint" to "∮",
        "lambda" to "λ", "mu" to "μ", "nu" to "ν", "xi" to "ξ",
        "leq" to "≤", "le" to "≤", "geq" to "≥", "ge" to "≥",
        "ll" to "≪", "gg" to "≫",
        "log", "ln", "lg", "exp",
        "mapsto" to "⟼", "leftrightarrow" to "⟷",
        "min", "max", "inf", "sup", "det", "dim", "ker", "deg",
        "neg" to "¬", "lnot" to "¬",
        "neq" to "≠", "ne" to "≠",
        "omega" to "ω",
        "oplus" to "⊕", "ominus" to "⊖", "otimes" to "⊗", "oslash" to "⊘", "odot" to "⊙",
        "phi" to "ϕ", "varphi" to "φ", "chi" to "χ", "psi" to "ψ",
        "pi" to "π", "varpi" to "ϖ", "rho" to "ρ", "varrho" to "ϱ",
        "prime" to "′", "dagger" to "†", "ddagger" to "‡",
        "propto" to "∝",
        "qquad" to 2f,
        "quad" to 1f,
        "setminus" to "∖",
        "sigma" to "σ", "varsigma" to "ς", "tau" to "τ", "upsilon" to "υ",
        "sin", "cos", "tan", "cot", "sec", "csc",
        "sinh", "cosh", "tanh", "coth",
        "subset" to "⊂", "supset" to "⊃", "subseteq" to "⊆", "supseteq" to "⊇",
        "sum" to "∑", "prod" to "∏", "coprod" to "∐",
        "theta" to "θ", "vartheta" to "ϑ", "iota" to "ι", "kappa" to "κ",
        "times" to "×", "div" to "÷", "pm" to "±", "mp" to "∓",
        "to" to "⟶", "rightarrow" to "⟶", "leftarrow" to "⟵", "gets" to "⟵",
        "top" to "⊤", "bot" to "⊥", "perp" to "⊥", "parallel" to "∥",
        "{" to "{",
        "}" to "}",
        'A' to "𝒜", 'B' to "ℬ", 'C' to "𝒞", 'D' to "𝒟", 'E' to "ℰ", 'F' to "ℱ",
        'A' to "𝔸", 'B' to "𝔹", 'C' to "ℂ", 'D' to "𝔻", 'E' to "𝔼", 'F' to "𝔽",
        'G' to "𝒢", 'H' to "ℋ", 'I' to "ℐ", 'J' to "𝒥", 'K' to "𝒦", 'L' to "ℒ",
        'G' to "𝔾", 'H' to "ℍ", 'I' to "𝕀", 'J' to "𝕁", 'K' to "𝕂", 'L' to "𝕃",
        'M' to "ℳ", 'N' to "𝒩", 'O' to "𝒪", 'P' to "𝒫", 'Q' to "𝒬", 'R' to "ℛ",
        'M' to "𝕄", 'N' to "ℕ", 'O' to "𝕆", 'P' to "ℙ", 'Q' to "ℚ", 'R' to "ℝ",
        'S' to "𝒮", 'T' to "𝒯", 'U' to "𝒰", 'V' to "𝒱", 'W' to "𝒲", 'X' to "𝒳",
        'S' to "𝕊", 'T' to "𝕋", 'U' to "𝕌", 'V' to "𝕍", 'W' to "𝕎", 'X' to "𝕏",
        'Y' to "𝒴", 'Z' to "𝒵",
        'Y' to "𝕐", 'Z' to "ℤ",
        // U+2190). The short arrowhead collapses to a single pixel at subscript sizes and reads
        // Use the long-arrow variants (U+27F6 / U+27F5) instead of the short ones (U+2192 /
        // as a dash; the long variants keep the arrow shape identifiable at any size.
        BINARY_OPS[command]?.let { return Sym(it, SymKind.BIN_OP) }
        GREEK_LOWER[command]?.let { return Sym(it, SymKind.VARIABLE) }
        GREEK_UPPER[command]?.let { return Sym(it, SymKind.ORDINARY) }
        LARGE_OPS[command]?.let { return LargeOp(it) }
        LITERAL_ESCAPES[command]?.let { return Sym(it, SymKind.ORDINARY) }
        MISC_SYMBOLS[command]?.let { return Sym(it, SymKind.ORDINARY) }
        RELATION_OPS[command]?.let { return Sym(it, SymKind.REL_OP) }
        SPACE_COMMANDS[command]?.let { return Space(it) }
        if (command in FUNCTION_NAMES) {
        if (command in LIMIT_FUNCTIONS) {
        return null
        }
    )
    /** Commands that typeset as upright function names: `\sin`, `\cos`, etc. */
    /** Commands whose output is literally one character (e.g. `\{` → `{`). */
    /** Function names that also always typeset their subscript as a limit (below in display). */
    fun lookup(command: String): MathAtom? {
    fun mapCalligraphic(ch: Char): String = CALLIGRAPHIC_UPPER[ch] ?: ch.toString()
    fun mapDoubleStruck(ch: Char): String = DOUBLE_STRUCK_UPPER[ch] ?: ch.toString()
    private val BINARY_OPS = mapOf(
    private val CALLIGRAPHIC_UPPER = mapOf(
    private val DOUBLE_STRUCK_UPPER = mapOf(
    private val FUNCTION_NAMES = setOf(
    private val GREEK_LOWER = mapOf(
    private val GREEK_UPPER = mapOf(
    private val LARGE_OPS = mapOf(
    private val LIMIT_FUNCTIONS = setOf("lim", "liminf", "limsup", "max", "min", "sup", "inf")
    private val LITERAL_ESCAPES = mapOf(
    private val MISC_SYMBOLS = mapOf(
    private val RELATION_OPS = mapOf(
    private val SPACE_COMMANDS = mapOf(
    }
 * Kept deliberately small; unknown commands fall back to rendering the raw `\name` string.
 * LaTeX command → Unicode mapping for the symbols that LLMs actually emit.
 */
/**
internal object MathSymbols {
package com.inspiredandroid.kai.ui.markdown.math
}
