#!/bin/bash

if [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ]; then

  echo $(pwd)

  echo "Cloning gh-pages..."
  git config --global user.email "contact@travis-ci.com"
  git config --global user.name "travis-ci"
  git clone --branch=gh-pages https://${GH_TOKEN}@github.com/$GH_REPOSITORY.git gh-pages &> /dev/null

  echo "Copying javadoc..."
  rm -rf gh-pages/javadoc
  mkdir gh-pages/javadoc
  cp -r ./build/docs/javadoc/* gh-pages/javadoc/

  echo "Pushing a new version of gh-pages..."
  cd gh-pages
  git add -A
  git commit -m "[CI] Javadoc updated after successful build $TRAVIS_BUILD_NUMBER"
  git push origin gh-pages &> /dev/null

  echo "Javadoc Published."
fi
