ROOT="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

(

	cd $ROOT

	# Use gradle! It's great! See this for an example: https://github.com/vmrob/aciddb-java-client
	# Note the "build.gradle" file


	javac -cp lib/postgresql.jdbc41.jar -d bin project/project/* project/tables/*
	java -cp "lib/*;bin" project.Comp5120

)
