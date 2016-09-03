#!/usr/bin/ruby
# -*- coding: utf-8 -*-

puts "Let's practice everything."
puts 'you\'d need to know \'bout escapes with \\ that do \n newlines and \t tabs.'

poem = <<END
\tThe lovely world
with logic so firmly planted
cannot discern \n the needs of love
nor comprehend passion from intuition
and requires an explanation
\n\t\twhere there is none.
END

puts "-" * 10
puts poem
puts "-" * 10

five = 10 - 2 + 3 - 6
puts "This should be five: #{five}"

def secret_formula(started)
  jelly_beans = started * 500
  jars = jelly_beans / 1000
  crates = jars / 100
  return jelly_beans, jars, crates
end

start_point = 5000
beans, jars, crates = secret_formula(start_point)

puts "with a starting  point of: #{start_point}"
puts "We'd have #{beans} beans, #{jars} jars, and #{crates} creates"








