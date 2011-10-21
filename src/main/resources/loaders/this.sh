#!/bin/sh

ls | while read line
do
	if [ -e $line/loader.properties.template ] ;
	then
		cp $line/loader.properties.template loader.properties
	fi

	if [ -e $line/datasources.txt.template ] ;
	then
		cp $line/datasources.txt.template $line/datasources.txt
	fi
done
