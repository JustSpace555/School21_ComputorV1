DEP='Dependencies'
JAVA_INCL_HOME="$DEP/java"
NAME='computor'
BUILD_FOLDER='build'
CONFIG='config.json'

if [[ "$OSTYPE" == "linux-gnu"* ]];
then
	$JAVA_INCL_HOME/bin/java -jar $DEP/packr-all-2.7.0.jar --platform linux64 --jdk $JAVA_INCL_HOME --useZgcIfSupportedOs --executable $NAME --classpath $NAME.jar --mainclass MainKt --output $BUILD_FOLDER
	mv $BUILD_FOLDER/$NAME $NAME
	mv $BUILD_FOLDER/$CONFIG $CONFIG
	mv $BUILD_FOLDER/jre jre

elif [[ "$OSTYPE" == "darwin"* ]];
then
	$JAVA_INCL_HOME/bin/java -jar $DEP/packr-all-2.7.0.jar --platform mac --jdk $JAVA_INCL_HOME --useZgcIfSupportedOs --executable $NAME --classpath $NAME.jar --mainclass MainKt --output $BUILD_FOLDER
	mv $BUILD_FOLDER/Contents/MacOS/$NAME $NAME
	mv $BUILD_FOLDER/Contents/Resources/$CONFIG $CONFIG
	mv $BUILD_FOLDER/Contents/Resources/jre jre

fi

rm -rf $BUILD_FOLDER
