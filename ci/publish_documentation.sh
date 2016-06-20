#!/bin/bash

app_name='com.toolable.notesstub'
version='0.1-SNAPSHOT'

if [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ]; then

  echo $(pwd)

  echo "Cloning gh-pages..."
  git config --global user.email "contact@travis-ci.com"
  git config --global user.name "travis-ci"
  git clone --branch=gh-pages https://${GH_TOKEN}@github.com/$GH_REPOSITORY.git gh-pages &> /dev/null

  echo "Generating doc..."
  ./gradlew dokka

  echo "Copying doc..."
  rm -rf gh-pages/doc/*-SNAPSHOT
  mkdir gh-pages/doc/$version
  cp -r ./build/dokka/$app_name/* gh-pages/doc/$version

  echo "Pushing a new version of gh-pages..."
  cd gh-pages
  git add -A
  git commit -m "[CI] Update document after successful build $TRAVIS_BUILD_NUMBER"
  git push origin gh-pages &> /dev/null

  echo "Documentation Published."
fi
