## Roles
ANONYMOUS:
- view planning activity

CUSTOMER:
- set subscription
- add owned pet
- delete owned pet
- join activity
Quand 

EMPLOYEE:
- set vacancy
- update owned profil
- update his user password
- update his user name

ADMIN: 
- delete employee
- add employee => add new user aspect
- set activity
- delete activity
- create activity
- update activity

## TABLES

USER
- When a User is created => a new Customer is created,
- When an Employee is created => a new User is created 

## PSQL CRASH
brew services list
psql -U serotonine -d pet_sitter_db
ps aux | grep postgres


## TODO LIST 
### EmployeeEnrolment
- add => response => see also activity
### Other
- set the responseEntity at the Controller level
- nulValuePropertyStrategy @BeanMapping (mapper)
- set the responseEntity at the Controller level on Employee
- Implement spring security
- Add Test for Activity
- Understood well @JsonManagedReference
- add save pet on create customer
- UserResponseDTO to do
-
---
Bugs & Refactoring — Pet Sitter Application

  


## Bora Movie example
https://github.com/MustafaBora/spring-boot-movie/


### Json annotations
@JsonManagedReference et @JsonBackReference
Ce sont deux annotations qui travaillent toujours en paire pour gérer les relations bidirectionnelles :
@JsonManagedReference  = le côté PARENT  → sérialisé ✅
@JsonBackReference     = le côté ENFANT  → PAS sérialisé ❌
java// Parent — Activity
@OneToMany(mappedBy = "activity")
@JsonManagedReference("activity-pet")  // ← inclus dans le JSON
private List<PetEnrolment> petEnrolments;

// Enfant — PetEnrolment
@ManyToOne
@JsonBackReference("activity-pet")  // ← exclu du JSON
private Activity activity;
Résultat JSON :
json{
"id": 1,
"name": "Walk",
"petEnrolments": [        ← inclus ✅
{ "id": 1, "pet": {...} }
// activity n'apparaît pas ici ✅
]
}

Toutes les annotations @Json importantes :

Gestion des champs :
java// Exclut totalement un champ du JSON (lecture ET écriture)
@JsonIgnore
private String password;

// Exclut des champs spécifiques d'une autre classe
@JsonIgnoreProperties({"password", "createdAt"})
private User user;

// Exclut tous les champs inconnus à la désérialisation
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO { }

// Renomme un champ dans le JSON
@JsonProperty("first_name")
private String firstName;
// JSON: { "first_name": "Julie" } ↔ Java: firstName

// Inclut un champ même s'il est null
@JsonInclude(JsonInclude.Include.ALWAYS)
private String middleName;

// Exclut les champs null du JSON
@JsonInclude(JsonInclude.Include.NON_NULL)
private String middleName;
// → si null, le champ n'apparaît pas dans le JSON ✅

Gestion des dates :
java// Formate une date dans le JSON
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createdAt;
// JSON: { "createdAt": "2026-05-12 14:30:00" }

// Désérialise une date avec un format spécifique
@JsonDeserialize(using = LocalDateTimeDeserializer.class)
private LocalDateTime startDate;

Gestion des relations bidirectionnelles :
java// Côté parent — inclus dans le JSON
@JsonManagedReference
private List<PetEnrolment> enrolments;

// Côté enfant — exclu du JSON
@JsonBackReference
private Activity activity;

Gestion du polymorphisme :
java// Ajoute le type dans le JSON (utile pour l'héritage)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
@JsonSubTypes.Type(value = Dog.class, name = "dog"),
@JsonSubTypes.Type(value = Cat.class, name = "cat")
})
public abstract class Pet { }
// JSON: { "type": "dog", "name": "Rex" }

Gestion de la sérialisation :
java// Ajoute un wrapper autour du JSON
@JsonRootName("user")
public class User { }
// JSON: { "user": { "id": 1, "name": "Julie" } }

// Méthode appelée après désérialisation
@JsonCreator
public User(@JsonProperty("id") Long id,
@JsonProperty("name") String name) { }

// Champ calculé — ajouté au JSON mais pas en DB
@JsonGetter("fullName")
public String getFullName() {
return firstName + " " + lastName;
}

// Ignore un champ à la sérialisation (lecture seule)
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private String password;
// → accepté en entrée (POST) mais jamais retourné en réponse ✅

Résumé — les plus utiles en Spring Boot :
AnnotationUsage@JsonIgnoreexclure un champ (ex: password)@JsonPropertyrenommer un champ@JsonInclude(NON_NULL)ne pas retourner les nulls@JsonFormatformater les dates@JsonIgnoreProperties(ignoreUnknown=true)ignorer les champs inconnus du JSON entrant@JsonManagedReferencecôté parent d'une relation@JsonBackReferencecôté enfant d'une relation@JsonProperty(WRITE_ONLY)accepter en entrée mais ne pas retourner
Le plus utilisé au quotidien : @JsonIgnore, @JsonProperty et @JsonInclude(NON_NULL)
