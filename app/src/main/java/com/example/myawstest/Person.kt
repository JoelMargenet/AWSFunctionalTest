package com.example.myawstest

import com.amplifyframework.core.model.Model
import com.amplifyframework.core.model.annotations.ModelConfig
import com.amplifyframework.core.model.annotations.ModelField

@ModelConfig(pluralName = "Persons")
data class Person(
    @ModelField(targetType = "ID", isRequired = true)
    val id: String,

    @ModelField(targetType = "String", isRequired = true)
    val name: String,

    @ModelField(targetType = "String", isRequired = true)
    val lastName: String
) : Model {
    // Constructor to initialize the ID automatically if needed
    constructor(name: String, lastName: String) : this(id = java.util.UUID.randomUUID().toString(), name, lastName)
}
