#!/usr/bin/ruby
# -*- coding: utf-8 -*-

filename = ARGV.first

puts "We're going to erase #{filename}"
puts "hit ctrl+c if you dont want that!"
puts "Hit return if you want that."

$stdin.gets # return key

puts "Opening the file..."
target = open(filename, 'w')

puts "Truncating the file. Goodbye!"
target.truncate(0)

puts "Now I'm going to ask you for three lines."

print "Line 1: "
line1 = $stdin.gets.chomp
print "Line 2: "
line2 = $stdin.gets.chomp
print "Line 3: "
line3 = $stdin.gets.chomp

target.write(line1)
target.write("\n")
target.write(line2)
target.write("\n")
target.write(line3)
target.write("\n")

puts "And finally, we close it."
target.close
