#!/bin/bash

KOTLIN='kotlinc'
JAVA='java'
DEP='Dependencies'

if ! [ -d $DEP ]
then
	mkdir $DEP
fi

if ! [ -d $DEP/$JAVA ]
then
	echo "Downloading java...


	"

	if [[ "$OSTYPE" == "linux-gnu"* ]];
	then
		wget https://download.java.net/java/GA/jdk14.0.1/664493ef4a6946b186ff29eb326336a2/7/GPL/openjdk-14.0.1_linux-x64_bin.tar.gz
		echo ""
		echo ""
		echo "Unarchiving file..."
		tar -xvf openjdk-14.0.1_linux-x64_bin.tar.gz
		rm openjdk-14.0.1_linux-x64_bin.tar.gz
		mv jdk* $DEP/$JAVA

	elif [[ "$OSTYPE" == "darwin"* ]];
	then
		curl -L https://download.java.net/java/GA/jdk14.0.1/664493ef4a6946b186ff29eb326336a2/7/GPL/openjdk-14.0.1_osx-x64_bin.tar.gz --output openjdk-14.0.1_osx-x64_bin.tar.gz
		echo ""
		echo ""
		echo "Unarchiving file..."
		tar -xvf openjdk-14.0.1_osx-x64_bin.tar.gz
		rm openjdk-14.0.1_osx-x64_bin.tar.gz
		mv jdk*/Contents/Home $DEP/$JAVA

	else
		echo ERROR: "
			Unknown OS type. Please download appropriate with your OS kotlinc program from https://jdk.java.net/archive/.
			Then unpack it, place into $DEP folder and rename folder to $JAVA
		"
		exit 1
	fi

	rm -rf jdk*
fi



if ! [ -d $DEP/$KOTLIN ]
then
	echo "Downloaging kotlin compiler...


	"

	if [[ "$OSTYPE" == "linux-gnu"* ]];
	then
		wget https://github.com/JetBrains/kotlin/releases/download/v1.4.10/kotlin-compiler-1.4.10.zip
		echo ""
		echo ""
		echo "Unarchiving file..."

		unzip kotlin-compiler-1.4.10.zip
		mv kotlin* $DEP/$KOTLIN
		kotlin-compiler-1.4.10.zip

	elif [[ "$OSTYPE" == "darwin"* ]];
	then
		curl -L https://github.com/JetBrains/kotlin/releases/download/v1.4.10/kotlin-compiler-1.4.10.zip --output kotlin-compiler-1.4.10.zip
		echo ""
		echo ""
		echo "Unarchiving file..."

		unzip kotlin-compiler-1.4.10.zip
		mv $KOTLIN $DEP/$KOTLIN
		rm kotlin-compiler-1.4.10.zip
	else
		echo ERROR: "
			Unknown OS type. Please download appropriate with your OS kotlinc program from https://github.com/JetBrains/kotlin/releases/tag/v1.4.10.
			Then unpack it, place into $DEP folder and rename folder to $KOTLIN
		"
		exit 1
	fi
fi


if ! [ -f $DEP/packr-all* ]
then
	if [[ "$OSTYPE" == "linux-gnu"* ]];
	then
		wget https://github.com/libgdx/packr/releases/download/packr-2.7.0/packr-all-2.7.0.jar

	elif [[ "$OSTYPE" == "darwin"* ]];
	then
		curl -L https://github.com/libgdx/packr/releases/download/packr-2.7.0/packr-all-2.7.0.jar --output packr-all-2.7.0.jar

	else
		echo ERROR: "
			Unknown OS type. Please download appropriate with your OS packr-all program from https://github.com/libgdx/packr/releases/download/packr-2.7.0
			Then move it into $DEP folder
		"
		exit 1
	fi
	mv packr* $DEP/packr-all-2.7.0.jar
fi
