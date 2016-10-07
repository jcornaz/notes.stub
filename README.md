# Notes Stub
[![License](https://img.shields.io/badge/license-GPLv2-blue.svg)](https://github.com/slimaku/notes.stub/blob/develop/LICENSE)
![Version](https://img.shields.io/badge/version-0.1.1-yellow.svg)
[![Build status](https://travis-ci.org/slimaku/notes.stub.svg?branch=master)](https://travis-ci.org/slimaku/notes.stub)
[![Code coverage](https://codecov.io/gh/slimaku/notes.stub/branch/master/graph/badge.svg)](https://codecov.io/gh/slimaku/notes.stub)

*Minimalistic* Lotus Notes behaviors reproduction for unit testing purpose. Written in kotlin an designed to be used from kotlin or java.

The goal is to be able to create fake documents, collections, databases that will behave like Lotus Notes would need of a real notes database access. Whith it you can do real unit tests of your Lotus Notes java application, without network or disk access and with better reproducibility.

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

**IMPORTNANT** : Not all lotus interface methods are supported. Be aware of the supported methods.
The [documentation](https://slimaku.github.io/notes.stub/doc/0.1/notesstub/com.toolable.notes.stub.impl/index.html) will tell you which operation is supported or not.

Feel free to implements more methods and to propose pull-requests.

## Setup
Please note, this project need a `Notes.jar` archive, that is property of IBM and cannot be distributed. Therefore, you need a licensed installation of Lotus Notes.

1. Start by cloning this repo : `git clone --branch v0.1.1 git@github.com:slimaku/notes.stub.git`
2. Create a folder "libs" at the root of the project and put there a copy the `Notes.jar` from your Lotus Notes installation.
3. Test it : `./gradlew check`

From here you can work in it or add it in your project with your favorite method.

## API Reference
* [Complete KDoc](https://slimaku.github.io/notes.stub/doc/0.1/notesstub/index.html)
* [Supported lotus notes methods](https://slimaku.github.io/notes.stub/doc/0.1/notesstub/com.toolable.notes.stub.impl/index.html)
