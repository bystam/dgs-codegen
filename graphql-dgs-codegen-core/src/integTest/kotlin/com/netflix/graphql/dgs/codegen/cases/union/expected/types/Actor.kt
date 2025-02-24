package com.netflix.graphql.dgs.codegen.cases.union.expected.types

import com.fasterxml.jackson.`annotation`.JsonIgnoreProperties
import com.fasterxml.jackson.`annotation`.JsonProperty
import com.fasterxml.jackson.`annotation`.JsonTypeInfo
import com.fasterxml.jackson.databind.`annotation`.JsonDeserialize
import com.fasterxml.jackson.databind.`annotation`.JsonPOJOBuilder
import java.lang.IllegalStateException
import kotlin.String
import kotlin.jvm.JvmName

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonDeserialize(builder = Actor.Builder::class)
public class Actor(
  name: () -> String? = nameDefault,
) : SearchResult {
  private val _name: () -> String? = name

  @get:JvmName("getName")
  public val name: String?
    get() = _name.invoke()

  public companion object {
    private val nameDefault: () -> String? = 
        { throw IllegalStateException("Field `name` was not requested") }

  }

  @JsonPOJOBuilder
  @JsonIgnoreProperties("__typename")
  public class Builder {
    private var name: () -> String? = nameDefault

    @JsonProperty("name")
    public fun withName(name: String?): Builder = this.apply {
      this.name = { name }
    }

    public fun build() = Actor(
      name = name,
    )
  }
}
