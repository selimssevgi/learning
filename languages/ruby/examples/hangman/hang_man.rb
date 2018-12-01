#!/usr/bin/ruby
# -*- coding : utf-8 -*-

# Setting
words_file = "words.txt"

def draw_man(level)
  case level
  when 0
    puts """
     ____________
    |     
    |          
    |         
    |        
    |       
    |      
    |
  =====
  """
  when 1
    puts """
     ____________
    |           |
    |     
    |    
    |   
    |  
    | 
    |
  =====
  """
  when 2
    puts """
     ____________
    |           |
    |          ( )
    |  
    | 
    |
    |
    |
  =====
  """
  when 3
    puts """
     ____________
    |           |
    |          ( )
    |           |
    |     
    |    
    |   
    |
  =====
  """
  when 4
    puts """
     ____________
    |           |
    |          ( )
    |           |
    |          /|\
    |       
    |      
    |
  =====
  """
  when 5
    puts """
     ____________
    |           |
    |          ( )
    |           |
    |          /|\
    |           |
    |  
    |
  =====
  """
  when 6
    puts """
     ____________
    |           |
    |          ( )
    |           |
    |          /|\
    |           |
    |          / \
    |
  =====
  """
  else
    #
  end
end

def get_words(file)
  fd = open(file)
  words = []

  fd.each_line do |line|
    words.push(line)
  end 
  
  return words
end

def pick_word(words)
  # return words[rand(words.size)]
  size = words.size

  rand_index = rand(size)
  
  return words[rand_index]
end

failed = false
screen_word = []
while !failed
  print ""
words = get_words(words_file)

picked_word = pick_word(words)
