#!/bin/bash
javac -cp /lib/postgresql.jdbc41.jar -d bin project/project/* project/tables/*
java -cp .:/lib/postgresql.jdbc41.jar:bin/ project.Comp5120