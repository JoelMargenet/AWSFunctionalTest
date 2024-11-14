package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.ModelIdentifier;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Person type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "People", type = Model.Type.USER, version = 1)
public final class Person implements Model {
  public static final QueryField ID = field("Person", "id");
  public static final QueryField NAME = field("Person", "name");
  public static final QueryField LAST_NAME = field("Person", "lastName");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String", isRequired = true) String lastName;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  /** @deprecated This API is internal to Amplify and should not be used. */
  @Deprecated
   public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getLastName() {
      return lastName;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Person(String id, String name, String lastName) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Person person = (Person) obj;
      return ObjectsCompat.equals(getId(), person.getId()) &&
              ObjectsCompat.equals(getName(), person.getName()) &&
              ObjectsCompat.equals(getLastName(), person.getLastName()) &&
              ObjectsCompat.equals(getCreatedAt(), person.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), person.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getLastName())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Person {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("lastName=" + String.valueOf(getLastName()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Person justId(String id) {
    return new Person(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      lastName);
  }
  public interface NameStep {
    LastNameStep name(String name);
  }
  

  public interface LastNameStep {
    BuildStep lastName(String lastName);
  }
  

  public interface BuildStep {
    Person build();
    BuildStep id(String id);
  }
  

  public static class Builder implements NameStep, LastNameStep, BuildStep {
    private String id;
    private String name;
    private String lastName;
    public Builder() {
      
    }
    
    private Builder(String id, String name, String lastName) {
      this.id = id;
      this.name = name;
      this.lastName = lastName;
    }
    
    @Override
     public Person build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Person(
          id,
          name,
          lastName);
    }
    
    @Override
     public LastNameStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep lastName(String lastName) {
        Objects.requireNonNull(lastName);
        this.lastName = lastName;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, String lastName) {
      super(id, name, lastName);
      Objects.requireNonNull(name);
      Objects.requireNonNull(lastName);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder lastName(String lastName) {
      return (CopyOfBuilder) super.lastName(lastName);
    }
  }
  

  public static class PersonIdentifier extends ModelIdentifier<Person> {
    private static final long serialVersionUID = 1L;
    public PersonIdentifier(String id) {
      super(id);
    }
  }
  
}
