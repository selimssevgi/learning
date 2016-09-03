#!/usr/bin/ruby
# -*- coding: utf-8 -*-

def cheese_and_crackers(cheese_count, boxes_of_crackers)
  puts "You have #{cheese_count} cheeses!"
  puts "You have #{boxes_of_crackers} boxes of crackers!"
end

puts "passing numbers directly:"
cheese_and_crackers(20, 40)

puts "Or, passing them via variables:"
amount_of_cheese = 10
amount_of_crackers = 50

cheese_and_crackers(amount_of_cheese, amount_of_crackers)

