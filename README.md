[![License](https://img.shields.io/badge/license-GPLv2-blue.svg)](https://github.com/toolable/notes.stub/blob/develop/LICENSE)
![Version](https://img.shields.io/badge/version-0.1-yellow.svg)
[![Build status](https://travis-ci.org/toolable/notes.stub.svg?branch=develop)](https://travis-ci.org/toolable/notes.stub/branches)
[![Code coverage](https://img.shields.io/codecov/c/github/toolable/notes.stub/develop.svg)](https://codecov.io/github/toolable/notes.stub/?branch=develop)

# Notes Stub
This is a *minimalistic* Lotus Notes behaviors reproduction for unit testing purpose. It's written in kotlin an designed to be used from kotlin an java.

The goal is to let you create fake documents, collections, databases that will behave like Lotus Notes would.

## Setup
This project need a `Notes.jar` archive, that is property of IBM and cannot be distributed. Therefore, you need a licensed installation of Lotus Notes.

To setup, create a folder "libs" at the root of the project and put there a copy the `Notes.jar` from your Lotus Notes installation.

Then you can test an build the project with gradle : `./gradlew check`

## Use exemple
```
// Create a new document stub
Document doc = new DocumentStub();

// Add some fields
doc.set("MyStringField", "Hello");
doc.set("MyNumerciField", 42);
doc.set("MyDateTimeField", DateTime.now());

// Get the notes implementation
Document doc = stub.getImplementation();

// Pass the reference of the implementation to your code for testing purpose
System.out.println(doc.getItemValueString("MyStringField"));    // Print : "Hello"
```

## Documentation
See complete reference in KDoc here : (http://toolable.github.io/notes.stub/doc/0.1)