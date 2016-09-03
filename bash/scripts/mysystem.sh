#!/bin/bash 

clear

echo "This is information provided by mysystem.sh. Program starts now."

echo "Hello, $USER"
echo # empty line

echo "Today's date is $(date), this is week  $(date +'%V')"
echo

echo "there users currently connected:"
w | cut -d" " -f1 - | grep -v USER | sort -u
echo 

echo "This is $(uname -s) running on a $(uname -m) processor."
echo

echo "This is the uptime information:"
uptime
