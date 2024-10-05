package dev.luisacu.pc01_picon_1_y_2

data class Player(
    val imageResId: Int, // Recurso de la imagen
    val fullName: String,
    val birthYear: Int
) {
    val age: Int
        get() = 2023 - birthYear // Calcula la edad
}