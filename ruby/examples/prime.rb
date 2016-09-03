def prime? n
  return false if x < 2

  (2...n).each do |x|
    return false if n % x == 0 
  end
          
  return true
end

print prime? 5
print prime? 14
print prime? 2
print prime? 1

