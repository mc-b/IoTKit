#!/bin/bash

# Zero out the free space to save space in the final image:
dd if=/dev/zero of=/EMPTY bs=1M count=1000
sync
rm -f /EMPTY
sync

read x