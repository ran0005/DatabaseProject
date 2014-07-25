#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

(

	cd $DIR


	javac -cp lib/postgresql.jdbc41.jar -d bin project/project/* project/tables/* project/menu/*
	java -cp "lib/*;bin" project.Comp5120

)
