#!/usr/bin/env sh

touch .env

# mongodb-connection-string
MONGO_VAR=$(grep MONGO .env | cut -d '=' -f2)
if [[ $MONGO_VAR = '' ]]
then
  echo 'Enter mongodb-connection-string:'
  read mongo_connection_string
else
  echo "Enter mongodb-connection-string: ($MONGO_VAR)"
  read mongo_connection_string
  if [[ $mongo_connection_string = '' ]]
  then
    mongo_connection_string=$MONGO_VAR
  fi
fi

rm -f .env
echo "MONGO=$mongo_connection_string" >> .env
