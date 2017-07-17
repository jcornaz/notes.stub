# Notes Stub
[![License](https://img.shields.io/badge/license-LGPLv3-blue.svg)](https://github.com/slimaku/notes.stub/blob/develop/LICENSE)
![Version](https://img.shields.io/badge/version-0.1.1-yellow.svg)

*Minimalistic* Lotus Notes behaviors reproduction for unit testing purpose. Written in kotlin an designed to be used from kotlin or java.

The goal is to be able to create fake documents, collections, databases that will behave like Lotus Notes would need of a real notes database access. Whith it you can do real unit tests of your Lotus Notes java application, without network or disk access and with better reproducibility.

## Project status
This project stay here for consultation purpose, but wont be maintened.

Everyone is free to fork and create derivated tools.

## Use exemple
### With java
```java
// Create a new document stub
DocumentStub docStub = new DocumentStub();

// Add some fields
docStub.set("MyStringField", "Hello");
docStub.set("MyNumerciField", 42);
docStub.set("MyDateTimeField", DateTime.now());

// Get the notes implementation
Document doc = stub.getImplementation();

// Pass the reference of the implementation to your code for testing purpose
System.out.println(doc.getItemValueString("MyStringField"));    // Print : "Hello"
```

### With kotlin
```kotlin
// Create a new document stub
val docStub = DocumentStub()

// Add some fields
docStub["MyStringField"] = "Hello"
docStub["MyNumerciField"] = 42
docStub["MyDateTimeField"] = DateTime.now()

// Get the notes implementation
val doc = stub.implementation

// Pass the reference of the implementation to your code for testing purpose
println(doc.getItemValueString("MyStringField"));    // Print : "Hello"
```

## Setup
Please note, this project need a `Notes.jar` archive, that is property of IBM and cannot be distributed. Therefore, you need a licensed installation of Lotus Notes.

1. Start by cloning this repo : `git clone --branch v0.1.1 git@github.com:slimaku/notes.stub.git`
2. Create a folder "libs" at the root of the project and put there a copy the `Notes.jar` from your Lotus Notes installation.
3. Test it : `./gradlew check`

From here you can work in it or add it in your project with your favorite method.
