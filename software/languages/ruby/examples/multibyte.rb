#d = <<-END
def count_multibyte_char str
  total_count = 0

  str.each_char do |c|
    count = 0
  
    c.each_byte do |b|
      count += 1
    end  

    if count > 1
      total_count += 1
    else
      puts "else branch"
    end

  end

  return total_count   
end
#END


puts count_multibyte_char('Selim')
str = "selim"
count = 0
puts count.class
str.each_char do |c|
    count += 1
    puts c
    puts str
end

puts count
