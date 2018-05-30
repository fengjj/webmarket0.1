#!/bin/bash
PATH=$1
FILE=$2
NEWNAME=$3
echo "Starting to ftp..."
/usr/bin/ftp -n<<!
open 132.120.115.119
user realsale realsale@123
binary
cd ${PATH}
lcd /data/websale/cust_groups/
prompt
get ${FILE} ${NEWNAME}
close
bye
!
/usr/bin/python /data/proc/custgroup.py /data/websale/cust_groups/${NEWNAME} /data/websale/cust_groups/detail 10
echo "done"
