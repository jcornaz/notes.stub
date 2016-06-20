# Notes Stub
A minimalistic Lotus Notes behaviors reproduction in java for unit testing purpose.

[![License](https://img.shields.io/badge/license-GPLv2-blue.svg)](https://github.com/toolable/notes.stub/blob/develop/LICENSE)

![Version](https://img.shields.io/badge/version-0.1-yellow.svg)
[![Build status](https://travis-ci.org/toolable/notes.stub.svg?branch=develop)](https://travis-ci.org/toolable/notes.stub/branches)
[![Code coverage](https://img.shields.io/codecov/c/github/toolable/notes.stub/develop.svg)](https://codecov.io/github/toolable/notes.stub/?branch=develop)

## Setup
This project need a `Notes.jar` archive, that is property of IBM and cannot be distributed. Therefore, you need a licensed installation of Lotus Notes.

To setup, create a folder "libs" at the root of the project and put there a copy the `Notes.jar` from your Lotus Notes installation.

Then you can test an build the project with gradle : `./gradlew check`
