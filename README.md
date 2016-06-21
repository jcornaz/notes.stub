[![License](https://img.shields.io/badge/license-GPLv2-blue.svg)](https://github.com/toolable/notes.stub/blob/develop/LICENSE)

# Notes Stub
This is a *minimalistic* Lotus Notes behaviors reproduction for unit testing purpose. It's written in kotlin an designed to be used from kotlin or java.

The goal is to let you create fake documents, collections, databases that will behave like Lotus Notes would. Then you can do real unit tests of your Lotus Notes application, without network or disk access and with better reproducibility.

### Latest release
[![Version](https://img.shields.io/badge/version-0.1.1-yellow.svg)](https://github.com/toolable/notes.stub/releases/tag/v0.1.1)
[![Build status](https://travis-ci.org/toolable/notes.stub.svg?branch=master)](https://travis-ci.org/toolable/notes.stub/branches)
[![Code coverage](https://img.shields.io/codecov/c/github/toolable/notes.stub/master.svg)](https://codecov.io/github/toolable/notes.stub/?branch=master)

Documentation (KDoc) : http://toolable.github.io/notes.stub/doc/0.1

### Nightly build (develop branch)
[![Version](https://img.shields.io/badge/version-0.2--SNAPSHOT-orange.svg)](https://github.com/toolable/notes.stub/tree/develop)
[![Build status](https://travis-ci.org/toolable/notes.stub.svg?branch=develop)](https://travis-ci.org/toolable/notes.stub/branches)
[![Code coverage](https://img.shields.io/codecov/c/github/toolable/notes.stub/develop.svg)](https://codecov.io/github/toolable/notes.stub/?branch=develop)

Documentation (KDoc) : http://toolable.github.io/notes.stub/doc/develop

## Setup
This project need a `Notes.jar` archive, that is property of IBM and cannot be distributed. Therefore, you need a licensed installation of Lotus Notes.

Create a folder "libs" at the root of the project and put there a copy the `Notes.jar` from your Lotus Notes installation.

You can test and build the project with gradle : `./gradlew check`

## Use exemple
```
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

No all lotus methods interface methods are supported. Be aware of the supported methods.
[Documentation](http://toolable.github.io/notes.stub/doc/0.1/com.toolable.notes.stub.impl) will tell you which operation is supported or not.