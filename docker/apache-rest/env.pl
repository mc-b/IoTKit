#!/usr/bin/perl
  
  print "Content-type: text/plain\n\n";
  for (keys %ENV) {
      print "$_ => $ENV{$_}\n";
  }

