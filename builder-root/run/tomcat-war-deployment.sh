#!/bin/bash

# HASTAAKSHAR Home and Catalina Home must be set correctly
. ./setenv.sh

echo "HASTAAKSHAR HOME: "$HASTAAKSHAR_HOME
echo "CATALINA HOME: "$CATALINA_HOME

export APP_DIR=$HASTAAKSHAR_HOME/setup/applications
export TARGET_DIR=$CATALINA_HOME/webapps


echo "Enter the war file names seperated by commas"
read strn

IFS=',' read -r -a array <<< "$strn"

for element in "${array[@]}"; do
  	echo "element: "$element
	if [ "$element" = "builder-service.war" ]; then 
		rm -rf $TARGET_DIR/iamws#hastaakshar && mkdir -p $TARGET_DIR/iamws#hastaakshar && cd $TARGET_DIR/iamws#hastaakshar && jar -xvf $APP_DIR/builder-service.war
		echo $element " Updated Successfully"
	else 
		echo $element "Not Updated"
fi
done

cd $HASTAAKSHAR_HOME/bin
